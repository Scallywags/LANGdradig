package scallywags.langdradig.generate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import scallywags.langdradig.grammatica.LANGdradigBaseVisitor;
import scallywags.langdradig.grammatica.LANGdradigLexer;
import scallywags.langdradig.grammatica.LANGdradigParser;
import scallywags.langdradig.grammatica.LANGdradigParser.*;

public class Generator extends LANGdradigBaseVisitor<String> {

	private static final String NEWLINE = System.lineSeparator();
	private static final String QUOTE = "\"";
	
	private static final String MODULE = "module";
	private static final String WHERE = "where";
	private static final String IMPORT_AST = "import AST";
	
	private static final String TYPE_DECL = "ast :: Prog";
	private static final String FUN_DECL = "ast = ";

	private static final String LPAR = "(";
	private static final String RPAR = ")";
	private static final String LSQ = "[";
	private static final String RSQ = "]";
	private static final String DATA = "data";
	
	private static final String PROG = "Prog";
	private static final String STAT = "Stat"; 
	private static final String EXPR = "Expr";
	private static final String BINOP = "BinOp";
	private static final String UNOP = "UnOp";
	private static final String PRIM = "Prim";
	private static final String TYPE = "Type";
	
	private static final String DECL = "Decl";
	private static final String BLOCK = "Block";
	private static final String IF_THEN = "IfThen";
	private static final String IF_THEN_ELSE = "IfThenElse";
	private static final String WHILE = "While";
	private static final String FORK = "Fork";
	private static final String WAIT = "Wait";
	private static final String SYNC = "Sync";
	
	private static final String ASS = "Ass";
	
	private static final String PLUS = "Plus";
	private static final String MINUS = "Minus";
	private static final String TIMES = "Times";
	private static final String DIVIDE = "Divide";
	private static final String MODULO = "Modulo";
	private static final String POWER = "Power";
	private static final String BETWEEN = "Between";
	private static final String INSIDE = "Inside";
	private static final String OUTSIDE = "Outside";
	private static final String LESS_THAN = "LessThan";
	private static final String LESS_THAN_EQ = "LessThAnEq";
	private static final String GREATER_THAN = "GreaterThan";
	private static final String GREATER_THAN_EQ = "GreaterThanEq";
	private static final String EQUAL = "Equal";
	private static final String NOT_EQUAL = "NotEqual";
	private static final String AND = "And";
	private static final String OR = "Or";
	
	private static final String MIN = "Min";
	private static final String NOT = "Not";
	private static final String INCR = "Incr";
	private static final String DECR = "Decr";
	
	private static final String PAR = "Par";
	private static final String BOOL = "Bool";
	private static final String IDF = "Idf";
	private static final String STRING = "String";
	private static final String INT = "Int";
	
	private static final String INT_TYPE = "IntType";
	private static final String BOOL_TYPE = "BoolType";
	private static final String ARRAY = "Array";

	private static final String BASE_DIR = "src/scallywags/haskell/"; 

	private final String programName;
	private final String sourceProgramPath;
	
	public Generator(String sourceFilePath) {
		
		File file = new File(sourceFilePath);
		String programName = file.getName();
		
		if (sourceFilePath == null) {
			throw new IllegalArgumentException("Source file path cannot be null.");
		}
		
		if (programName.endsWith(".langdradig")) {
			programName = programName.substring(0, programName.length() - 11);
		}
		
		if (programName.isEmpty()) {
			throw new IllegalArgumentException("Program name cannot be empty.");
		}
		
		this.sourceProgramPath = sourceFilePath;
		this.programName = programName.substring(0, 1).toUpperCase() + programName.substring(1).toLowerCase();
	}
	
	// -------------- Program --------------
	
	@Override
	public String visitProgram(ProgramContext ctx) {
		StringBuilder builder = new StringBuilder();
		builder.append(MODULE).append(' ').append(WHERE);
		builder.append(NEWLINE);
		builder.append(IMPORT_AST);
		builder.append(NEWLINE);
		
		builder.append(TYPE_DECL).append(NEWLINE);
		builder.append(FUN_DECL).append(' ');
		
		builder.append(LPAR);
		for (StatementContext stmnt : ctx.statement()) {
			builder.append(visit(stmnt)).append(':');
		}
		builder.append(LSQ).append(RSQ);
		builder.append(RPAR);
		
		return builder.toString();
	}
	
	// -------------- Statement --------------
	
	@Override
	public String visitDeclStat(DeclStatContext ctx) {
		return DECL + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE
				+ " " + LPAR + visit(ctx.type()) + LPAR;
	}
	
	@Override
	public String visitBlockStat(BlockStatContext ctx) {
		StringBuilder builder = new StringBuilder();
		builder.append(BLOCK).append(' ');
		builder.append(LPAR);
		for (StatementContext stmnt : ctx.statement()) {
			builder.append(visit(stmnt)).append(':');
		}
		builder.append(LSQ).append(RSQ);
		builder.append(RPAR);
		
		return builder.toString();
	}
	
	@Override
	public String visitExprStat(ExprStatContext ctx) {
		return EXPR + " " + LPAR + visit(ctx.expression()) + RPAR;
	}
	
	@Override
	public String visitIfStat(IfStatContext ctx) {
		List<StatementContext> stmnts = ctx.statement();
		boolean hasElse = stmnts.size() > 1;
		
		StringBuilder builder = new StringBuilder();
		if (hasElse) {
			builder.append(IF_THEN_ELSE);
		} else {
			builder.append(IF_THEN);
		}
		builder.append(' ').append(LPAR).append(visit(ctx.expression())).append(RPAR);
		builder.append(' ').append(LPAR).append(visit(stmnts.get(0))).append(RPAR);
		if (hasElse) {
			builder.append(' ').append(LPAR).append(visit(stmnts.get(1))).append(RPAR);
		}
		return builder.toString();
	}
	
	@Override
	public String visitWhileStat(WhileStatContext ctx) {
		return WHILE + " " + LPAR + visit(ctx.expression()) + RPAR
				+ " " + LPAR + visit(ctx.statement()) + RPAR;
	}
	
	@Override
	public String visitForkStat(ForkStatContext ctx) {
		return FORK + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE
				+ " " + LPAR + visit(ctx.statement()) + RPAR;
	}
	
	@Override
	public String visitJoinStat(JoinStatContext ctx) {
		return WAIT + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE;
	}
	
	@Override
	public String visitSyncStat(SyncStatContext ctx) {
		return SYNC + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE
				+ " " + LPAR + visit(ctx.statement()) + RPAR;
	}
	
	// -------------- Expression --------------
	
	//TODO
	
	// -------------- Terminal --------------
	
	@Override
	public String visitTerminal(TerminalNode ctx) {
		return ctx.getText();
	}
	
	// -------------- Rest --------------
	
	public String generate() throws IOException {
		return visitProgram(new LANGdradigParser(new CommonTokenStream(new LANGdradigLexer(new ANTLRFileStream(sourceProgramPath)))).program());
	}
	
	public String toString() {
		try {
			return generate();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		//MY WHOLE LIFE HAS BEEN A LIE!!!!!!!!!!!!
	}

	public void writeAST(String filename) {
		//TODO write string from builder to the file.
		//TODO check also if file already exists.
	}

//	public void desugar(ExpressionContext expr, Collection<String> excludedIdentifierNames) {
//		if (expr instanceof RangeExprContext) {
//			ParserRuleContext parent = expr.getParent();
//
//			List<ParseTree> copy = new ArrayList<>();
//
//			for (int i = 0; i < parent.getChildCount(); i++) {
//				ParseTree child = parent.getChild(i);
//				if (child instanceof RangeExprContext) {
//					RangeExprContext sugar = (RangeExprContext) child;
//
//					ExpressionContext toRangeCheck = sugar.expression(0);
//					ExpressionContext lowerBound = sugar.expression(1);
//					ExpressionContext upperBound = sugar.expression(2);
//
//					if (sugar.TUSSEN() != null) {
//
//					} else if (sugar.BINNEN() != null) {
//
//						
//					} else if (sugar.BUITEN() != null) {
//
//						
//					}
//
//				} else {
//					copy.add(child);
//				}
//			}
//
//			parent.children = copy;
//		}
//	}

}
