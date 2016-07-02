package scallywags.langdradig.generate;

import java.io.IOException;
import java.util.*;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import scallywags.langdradig.generate.exceptions.*;
import scallywags.langdradig.grammatica.LANGdradigBaseListener;
import scallywags.langdradig.grammatica.LANGdradigLexer;
import scallywags.langdradig.grammatica.LANGdradigParser;
import scallywags.langdradig.grammatica.LANGdradigParser.*;
import scallywags.langdradig.ide.errors.LANGdradigError;
import scallywags.langdradig.ide.errors.LANGdradigErrorListener;

/**
 * The type- and scope checker for the LANGdradig programming language.
 */

public class Checker extends LANGdradigBaseListener {

    private ForkTable forkTable = new ForkTable();

    private ParseTreeProperty<Type> types = new ParseTreeProperty<>();

    private List<CheckerException> exceptions = new ArrayList<>();

    private LANGdradigErrorListener errorListener = new LANGdradigErrorListener();

    public void checkFile(String source) throws IOException {
        CharStream stream = new ANTLRFileStream(source);
        Lexer lexer = new LANGdradigLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        LANGdradigParser parser = new LANGdradigParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.program();
        new ParseTreeWalker().walk(this, tree);
    }

    public void checkString(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new LANGdradigLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        LANGdradigParser parser = new LANGdradigParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        ParseTree tree = parser.program();
        new ParseTreeWalker().walk(this, tree);
    }

    public Type getType(ParseTree node) {
        return types.get(node);
    }

    // ------------- Program -------------

    @Override
    public void enterProgram(ProgramContext ctx) {
        forkTable.openScope("Programma");
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        if (!forkTable.waitedOnAll()) {
            exceptions.add(new NotWaitingForThreadException(ctx, forkTable.getNotWaitedOn()));
        }
        forkTable.closeScope();
    }

    // ------------- Statement -------------

    @Override
    public void exitIfStat(IfStatContext ctx) {
        Type exprType = types.get(ctx.expression());
        if (exprType != Type.BOOLEAN) {
            exceptions.add(new TypeException(ctx, Type.BOOLEAN, exprType));
        }
    }

    @Override
    public void exitWhileStat(WhileStatContext ctx) {
        Type type = types.get(ctx.expression());
        if (type != Type.BOOLEAN) {
            exceptions.add(new TypeException(ctx, Type.BOOLEAN, type));
        }
    }

    @Override
    public void enterForkStat(ForkStatContext ctx) {
        String id;
        if (ctx.IDENTIFIER() != null) {
            id = ctx.IDENTIFIER().getText();
            if (forkTable.contains(id) && !forkTable.getWaitedOn(id)) {
                exceptions.add(new NotWaitingForThreadException(ctx, id));
            } else {
                forkTable.addThread(id);
            }
        } else {
            id = "onbekend";
        }
        forkTable.openScope(id);
    }

    @Override
    public void exitForkStat(ForkStatContext ctx) {
        if (!forkTable.waitedOnAll()) {
            exceptions.add(new NotWaitingForThreadException(ctx, forkTable.getNotWaitedOn()));
        }
        forkTable.closeScope();
    }

    @Override
    public void enterBlockForkStat(BlockForkStatContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            String id = ctx.IDENTIFIER().getText();
            if (forkTable.contains(id) && !forkTable.getWaitedOn(id)) {
                exceptions.add(new NotWaitingForThreadException(ctx, id));
            } else {
                forkTable.addThread(id);
            }
            forkTable.openScope(id);
        }
    }

    @Override
    public void exitBlockForkStat(BlockForkStatContext ctx) {
        if (!forkTable.waitedOnAll()) {
            exceptions.add(new NotWaitingForThreadException(ctx, forkTable.getNotWaitedOn()));
        }
        forkTable.closeScope();
    }

    @Override
    public void exitJoinStat(JoinStatContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            String id = ctx.IDENTIFIER().getText();
            if (forkTable.contains(id)) {
                forkTable.waitForThread(id);
            } else {
                exceptions.add(new UndeclaredException(ctx, id));
            }
        }
    }

    @Override
    public void enterBlockStat(BlockStatContext ctx) {
        forkTable.openScopeSymbolTable();
    }

    @Override
    public void exitBlockStat(BlockStatContext ctx) {
        forkTable.closeScopeSymbolTable();
    }

    @Override
    public void exitDeclStat(DeclStatContext ctx) {
        Type type = types.get(ctx.type());
        boolean success = forkTable.add(ctx.IDENTIFIER().getText(), type, false);
        if (!success) {
            exceptions.add(new AlreadyDeclaredException(ctx, ctx.IDENTIFIER().getText()));
        }
    }

    @Override
    public void exitSharedDeclStat(SharedDeclStatContext ctx) {
        Type type = types.get(ctx.type());
        boolean success = forkTable.add(ctx.IDENTIFIER().getText(), type, true);
        if (!success) {
            exceptions.add(new AlreadyDeclaredException(ctx, ctx.IDENTIFIER().getText()));
        }
    }

    // ------------- Expression -------------

    @Override
    public void exitPrimExpr(PrimExprContext ctx) {
        Type type = types.get(ctx.primary());
        types.put(ctx, type);
    }

    @Override
    public void exitNegExpr(NegExprContext ctx) {
        Type type = types.get(ctx.expression());
        if (type != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, type));
        }
        types.put(ctx, type);
    }

    @Override
    public void exitNotExpr(NotExprContext ctx) {
        Type type = types.get(ctx.expression());
        if (type != Type.BOOLEAN) {
            exceptions.add(new TypeException(ctx, Type.BOOLEAN, type));
        }
        types.put(ctx, type);
    }

    @Override
    public void exitCrementExpr(CrementExprContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            Type type = forkTable.getType(ctx.IDENTIFIER().getText());
            if (type == null) {
                exceptions.add(new UndeclaredException(ctx, ctx.IDENTIFIER().getText()));
            } else if (type != Type.INTEGER) {
                exceptions.add(new TypeException(ctx, Type.INTEGER, type));
            }
            types.put(ctx, type);
        }
    }

    @Override
    public void exitPowExpr(PowExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type t1 = types.get(expressions.get(0));
        if (t1 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t1));
        }
        Type t2 = types.get(expressions.get(1));
        if (t2 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t2));
        }
        types.put(ctx, t1);
    }

    @Override
    public void exitFactorExpr(FactorExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type t1 = types.get(expressions.get(0));
        if (t1 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t1));
        }
        Type t2 = types.get(expressions.get(1));
        if (t2 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t2));
        }
        types.put(ctx, t1);
    }

    @Override
    public void exitTermExpr(TermExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type t1 = types.get(expressions.get(0));
        if (t1 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t1));
        }
        Type t2 = types.get(expressions.get(1));
        if (t2 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t2));
        }
        types.put(ctx, t1);
    }

    @Override
    public void exitRangeExpr(RangeExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type t1 = types.get(expressions.get(0));
        if (t1 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t1));
        }
        Type t2 = types.get(expressions.get(1));
        if (t2 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t2));
        }
        // TODO !!!
        Type t3 = types.get(expressions.get(2));
        if (t3 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t3));
        }
        types.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitCmpExpr(CmpExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type t1 = types.get(expressions.get(0));
        if (t1 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t1));
        }
        Type t2 = types.get(expressions.get(1));
        if (t2 != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, t2));
        }
        types.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitEqExpr(EqExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type t1 = types.get(expressions.get(0));
        Type t2 = types.get(expressions.get(1));
        if (!t1.equals(t2)) {
            exceptions.add(new TypeException(ctx, t1, t2));
        }
        types.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitBoolExpr(BoolExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type t1 = types.get(expressions.get(0));
        if (t1 != Type.BOOLEAN) {
            exceptions.add(new TypeException(ctx, Type.BOOLEAN, t1));
        }
        Type t2 = types.get(expressions.get(1));
        if (t2 != Type.BOOLEAN) {
            exceptions.add(new TypeException(ctx, Type.BOOLEAN, t2));
        }
        types.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitAssExpr(AssExprContext ctx) {
        Type exprType = types.get(ctx.expression());
        Type idfType = forkTable.getType(ctx.IDENTIFIER().getText());
        if (exprType == null || idfType == null || !exprType.equals(idfType)) {
            exceptions.add(new TypeException(ctx, idfType, exprType));
        }
        types.put(ctx, exprType);
    }

    @Override
    public void exitIndexExpr(IndexExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type arrayType = types.get(expressions.get(0));
        Type exprType = types.get(expressions.get(1));
        if (arrayType instanceof Type.ArrayType) {
            types.put(ctx, arrayType);
        } else {
            exceptions.add(new TypeException(ctx, new Type.Array(), arrayType));
        }
        if (exprType != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, exprType));
        }
    }

    @Override
    public void exitIndexAss1Expr(IndexAss1ExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type valueType = types.get(expressions.get(0));
        Type indexType = types.get(expressions.get(1));
        Type arrayType = types.get(expressions.get(2));
        if (arrayType instanceof Type.Array) {
            if (!valueType.equals(((Type.ArrayType) arrayType).getElemType())) {
                exceptions.add(new TypeException(ctx, ((Type.ArrayType) arrayType).getElemType(), valueType));
            }
            types.put(ctx, arrayType);
        } else {
            exceptions.add(new TypeException(ctx, new Type.Array(), arrayType));
        }
        if (indexType != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, indexType));
        }
    }

    @Override
    public void exitIndexAss2Expr(IndexAss2ExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        Type valueType = types.get(expressions.get(0));
        Type arrayType = types.get(expressions.get(1));
        Type indexType = types.get(expressions.get(2));
        if (arrayType instanceof Type.Array) {
            if (!valueType.equals(((Type.ArrayType) arrayType).getElemType())) {
                exceptions.add(new TypeException(ctx, ((Type.ArrayType) arrayType).getElemType(), valueType));
            }
            types.put(ctx, ((Type.ArrayType) arrayType).getElemType());
        } else {
            exceptions.add(new TypeException(ctx, new Type.Array(), arrayType));
        }
        if (indexType != Type.INTEGER) {
            exceptions.add(new TypeException(ctx, Type.INTEGER, indexType));
        }
    }

    @Override
    public void exitLengthExpr(LengthExprContext ctx) {
            Type exprType = types.get(ctx.expression());
            if (exprType instanceof Type.ArrayType) {
                types.put(ctx, Type.INTEGER);
            } else {
                exceptions.add(new TypeException(ctx, new Type.Array(), exprType));
            }
    }

    // ------------- Primary -------------

    @Override
    public void exitParExpr(ParExprContext ctx) {
        Type type = types.get(ctx.expression());
        types.put(ctx, type);
    }

    @Override
    public void exitTrueExpr(TrueExprContext ctx) {
        types.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitFalseExpr(FalseExprContext ctx) {
        types.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitIdfExpr(IdfExprContext ctx) {
        Type type = forkTable.getType(ctx.getText());
        if (type == null) {
            exceptions.add(new UndeclaredException(ctx, ctx.getText()));
        }
        types.put(ctx, type);
    }

    @Override
    public void exitNumExpr(NumExprContext ctx) {
        types.put(ctx, Type.INTEGER);
    }

    @Override
    public void exitArrayExpr(ArrayExprContext ctx) {
        List<ExpressionContext> expressions = ctx.expression();
        if (expressions.size() > 0) {
            Type type = types.get(expressions.get(0));
            if (type != null) {
                if (expressions.stream().map(types::get).allMatch(type::equals)) {
                    types.put(ctx, Type.ARRAY(type, expressions.size()));
                } else {
                    expressions.subList(1, expressions.size()).stream().filter(expr -> types.get(expr) == null || !types.get(expr).equals(type))
                            .forEach(expr -> exceptions.add(new TypeException(expr, type, types.get(expr))));
                }
            }
        } else {
            types.put(ctx, Type.EMPTY_ARRAY);
        }
    }

    // ------------- Type -------------

    @Override
    public void exitIntType(IntTypeContext ctx) {
        types.put(ctx, Type.INTEGER);
    }

    @Override
    public void exitBoolType(BoolTypeContext ctx) {
        types.put(ctx, Type.BOOLEAN);
    }

    @Override
    public void exitArrayType(ArrayTypeContext ctx) {
        Type elemType = types.get(ctx.type());
        if (elemType != null) {
            try {
                int number = Integer.parseInt(ctx.NUMBER().getText());
                if (number == 0) {
                    types.put(ctx, Type.EMPTY_ARRAY);
                } else {
                    types.put(ctx, Type.ARRAY(elemType, number));
                }
            } catch (NumberFormatException ignore) {
                // Exception gets added elsewhere
            }
        }
    }

    // ------------- Other -------------

    @Override
    public void visitErrorNode(ErrorNode ctx) {
        //TODO
    }

    public List<CheckerException> getCheckerExceptions() {
        return exceptions;
    }

    public List<LANGdradigError> getParserExceptions() {
        return errorListener.getErrors();
    }

    public ForkTable getForkTable() {
        return forkTable;
    }

}
