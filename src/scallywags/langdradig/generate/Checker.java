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
import scallywags.langdradig.listeners.LANGdradigErrorListener;

/**
 * The type- and scope checker for the LANGdradig programming language.
 */

public class Checker extends LANGdradigBaseListener {

    private SymbolTable symbolTable = new SymbolTable();
    private ForkTable forkTable = new ForkTable();

    private ParseTreeProperty<Type> types = new ParseTreeProperty<>();

    private List<CheckerException> exceptions = new ArrayList<>();

    private LANGdradigErrorListener errorListener = new LANGdradigErrorListener();

    /**
     * @param source the file to be scanned and checked
     * @throws IOException      if the file cannot be read
     * @throws CheckerException if the source program was invalid somewhere somehow
     */
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

    // ------------- Program -------------

    @Override
    public void enterProgram(ProgramContext ctx) {
        symbolTable.openScope();
        forkTable.openScope();
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        symbolTable.closeScope();
        if (!forkTable.waitedOnAll()) {
            System.out.println("exitProgram");
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
        if (ctx.IDENTIFIER() != null) {
            String id = ctx.IDENTIFIER().getText();
            if (forkTable.contains(id) && !forkTable.getWaitedOn(id)) {
                System.out.println("enterFork");
                exceptions.add(new NotWaitingForThreadException(ctx, id));
            }
        }
        forkTable.openScope();
        symbolTable.openScope();
    }

    @Override
    public void exitForkStat(ForkStatContext ctx) {
        if (!forkTable.waitedOnAll()) {
            System.out.println("exitFork");
            exceptions.add(new NotWaitingForThreadException(ctx, forkTable.getNotWaitedOn()));
        }
        forkTable.closeScope();
        symbolTable.closeScope();
        if (ctx.IDENTIFIER() != null) {
            String id = ctx.IDENTIFIER().getText();
            forkTable.addWorker(id);
        }
    }

    @Override
    public void exitJoinStat(JoinStatContext ctx) {
        if (ctx.IDENTIFIER() != null) {
            String id = ctx.IDENTIFIER().getText();
            if (!forkTable.contains(id)) {
                exceptions.add(new UndeclaredException(ctx, id));
            } else {
                forkTable.waitWorker(id);
            }
        }
    }

    @Override
    public void enterBlockStat(BlockStatContext ctx) {
        symbolTable.openScope();
    }

    @Override
    public void exitBlockStat(BlockStatContext ctx) {
        symbolTable.closeScope();
    }

    @Override
    public void exitDeclStat(DeclStatContext ctx) {
        Type type = types.get(ctx.type());
        boolean success = symbolTable.add(ctx.IDENTIFIER().getText(), type);
        if (!success) {
            exceptions.add(new AlreadyDeclaredException(ctx, ctx.IDENTIFIER().getText()));
        }
    }

    @Override
    public void exitSharedDeclStat(SharedDeclStatContext ctx) {
        Type type = types.get(ctx.type());
        boolean success = symbolTable.add(ctx.IDENTIFIER().getText(), type);
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
            Type type = symbolTable.getType(ctx.IDENTIFIER().getText());
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
        if (t1 != t2) {
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
        Type idfType = symbolTable.getType(ctx.IDENTIFIER().getText());
        if (exprType != idfType) {
            exceptions.add(new TypeException(ctx, idfType, exprType));
        }
        types.put(ctx, exprType);
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
        Type type = symbolTable.getType(ctx.getText());
        if (type == null) {
            exceptions.add(new UndeclaredException(ctx, ctx.getText()));
        }
        types.put(ctx, type);
    }

    @Override
    public void exitNumExpr(NumExprContext ctx) {
        types.put(ctx, Type.INTEGER);
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
        types.put(ctx, Type.ARRAY(elemType, Integer.parseInt(ctx.NUMBER().getText())));
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

    public List<Variable> getVariables() {
        return symbolTable.getVariables();
    }


}
