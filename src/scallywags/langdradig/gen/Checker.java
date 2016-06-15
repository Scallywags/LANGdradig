package scallywags.langdradig.gen;

import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import scallywags.langdradig.gen.exception.AlreadyDeclaredException;
import scallywags.langdradig.gen.exception.CheckerException;
import scallywags.langdradig.gen.exception.TypeException;
import scallywags.langdradig.gen.exception.UndeclaredException;
import scallywags.langdradig.grammatica.LANGdradigBaseListener;
import scallywags.langdradig.grammatica.LANGdradigLexer;
import scallywags.langdradig.grammatica.LANGdradigParser;
import scallywags.langdradig.grammatica.LANGdradigParser.*;

/**
 * 
 * The type- and scope checker for the LANGdradig™ programming language. 
 * 
 * @author Jan
 *
 */
public class Checker extends LANGdradigBaseListener {
	
	private SymbolTable table = new SymbolTable();
	
	private ParseTreeProperty<Type> types = new ParseTreeProperty<>();
	
	/**
	 * @param file the file to be scanned and checked
	 * @throws IOException if the file cannot be read.
	 * @throws CheckerException if the source program was invalid somewhere somehow
	 */
	public void checkFile(String source) throws IOException {
		CharStream stream = new ANTLRFileStream(source);
		Lexer lexer = new LANGdradigLexer(stream);
		TokenStream tokens = new CommonTokenStream(lexer);
		LANGdradigParser parser = new LANGdradigParser(tokens);
		
		ParseTree tree = parser.program();
		new ParseTreeWalker().walk(this, tree);
	}
	
	// ------------- Program -------------
	
	@Override
	public void enterProgram(ProgramContext ctx) {
		table.openScope();
	}
	
	@Override
	public void exitProgram(ProgramContext ctx) {
		table.closeScope();
	}
	
	// ------------- Statement -------------
	
	@Override
	public void exitIfStat(IfStatContext ctx) {
		Type exprType = types.get(ctx.expression());
		if (exprType != Type.BOOLEAN) {
			throw new TypeException(ctx, Type.BOOLEAN, exprType);
		}
	}

	@Override
	public void exitWhileStat(WhileStatContext ctx) {
		Type type = types.get(ctx.expression());
		if (type != Type.BOOLEAN) {
			throw new TypeException(ctx, Type.BOOLEAN, type);
		}
	}
	
	@Override
	public void enterBlockStat(BlockStatContext ctx) {
		table.openScope();
	}
	
	@Override
	public void exitBlockStat(BlockStatContext ctx) {
		table.closeScope();
	}

	// ------------- Declaration -------------
	
	public void exitDeclaration(DeclarationContext ctx) {
		Type type = types.get(ctx.type());
		boolean success = table.add(ctx.IDENTIFIER().getText(), type);
		if (!success) {
			throw new AlreadyDeclaredException(ctx.IDENTIFIER().getText());
		}
	}
	
	// ------------- Assignment -------------
	
	@Override
	public void exitAssignment(AssignmentContext ctx) {
		Type exprType = types.get(ctx.expression());
		Type idfType = table.get(ctx.IDENTIFIER().getText());
		if (exprType != idfType) {
			throw new TypeException(ctx, idfType, exprType);
		}
		types.put(ctx, exprType);
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
			throw new TypeException(ctx, Type.INTEGER, type);
		}
		types.put(ctx, type);
	}
	
	@Override
	public void exitNotExpr(NotExprContext ctx) {
		Type type = types.get(ctx.expression());
		if (type != Type.BOOLEAN) {
			throw new TypeException(ctx, Type.BOOLEAN, type);
		}
		types.put(ctx, type);
	}
	
	@Override
	public void exitPowExpr(PowExprContext ctx) {
		List<ExpressionContext> expressions = ctx.expression();
		Type t1 = types.get(expressions.get(0));
		if (t1 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t1);
		}
		Type t2 = types.get(expressions.get(1));
		if (t2 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t2);
		}
		types.put(ctx, t1);		
	}
	
	@Override
	public void exitFactorExpr(FactorExprContext ctx) {
		List<ExpressionContext> expressions = ctx.expression();
		Type t1 = types.get(expressions.get(0));
		if (t1 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t1);
		}
		Type t2 = types.get(expressions.get(1));
		if (t2 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t2);
		}
		types.put(ctx, t1);
	}
	
	@Override
	public void exitTermExpr(TermExprContext ctx) {
		List<ExpressionContext> expressions = ctx.expression();
		Type t1 = types.get(expressions.get(0));
		if (t1 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t1);
		}
		Type t2 = types.get(expressions.get(1));
		if (t2 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t2);
		}
		types.put(ctx, t1);
	}
	
	@Override
	public void exitRangeExpr(RangeExprContext ctx) {
		List<ExpressionContext> expressions = ctx.expression();
		Type t1 = types.get(expressions.get(0));
		if (t1 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t1);
		}
		Type t2 = types.get(expressions.get(1));
		if (t2 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t2);
		}
		Type t3 = types.get(expressions.get(2));
		if (t3 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t3);
		}
		types.put(ctx, Type.BOOLEAN);
	}
	
	@Override
	public void exitCmpExpr(CmpExprContext ctx) {
		List<ExpressionContext> expressions = ctx.expression();
		Type t1 = types.get(expressions.get(0));
		if (t1 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t1);
		}
		Type t2 = types.get(expressions.get(1));
		if (t2 != Type.INTEGER) {
			throw new TypeException(ctx, Type.INTEGER, t2);
		}
		types.put(ctx, Type.BOOLEAN);
	}
	
	@Override
	public void exitEqExpr(EqExprContext ctx) {
		List<ExpressionContext> expressions = ctx.expression();
		Type t1 = types.get(expressions.get(0));
		Type t2 = types.get(expressions.get(1));
		if (t1 != t2) {
			throw new TypeException(ctx, t1, t2);
		}
		types.put(ctx, Type.BOOLEAN);
	}
	
	@Override
	public void exitBoolExpr(BoolExprContext ctx) {
		List<ExpressionContext> expressions = ctx.expression();
		Type t1 = types.get(expressions.get(0));
		if (t1 != Type.BOOLEAN) {
			throw new TypeException(ctx, Type.BOOLEAN, t1);
		}
		Type t2 = types.get(expressions.get(1));
		if (t2 != Type.BOOLEAN) {
			throw new TypeException(ctx, Type.BOOLEAN, t2);
		}
		types.put(ctx, Type.BOOLEAN);
	}
	
	@Override
	public void exitAssExpr(AssExprContext ctx) {
		Type type = types.get(ctx.assignment());
		types.put(ctx, type);
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
		Type type = table.get(ctx.getText());
		if (type == null) {
			throw new UndeclaredException(ctx.getText());
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
	
	//TODO support Array Types
	
}
