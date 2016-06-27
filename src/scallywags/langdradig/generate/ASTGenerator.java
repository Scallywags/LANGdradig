package scallywags.langdradig.generate;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import scallywags.langdradig.grammatica.LANGdradigBaseVisitor;
import scallywags.langdradig.grammatica.LANGdradigLexer;
import scallywags.langdradig.grammatica.LANGdradigParser;
import scallywags.langdradig.grammatica.LANGdradigParser.*;

public class ASTGenerator extends LANGdradigBaseVisitor<String> {

	private static final String NEWLINE = System.lineSeparator();
	private static final String QUOTE = "\"";
	private static final String FOUR_SPACES = "    ";
	
	private static final String IMPORT_AST = "import AST";
	private static final String IMPORT_GENERATOR = "import Generator";
	private static final String WHERE = "where";
	
	private static final String AST_TYPE_DECL = "ast :: Prog";
	private static final String AST_FUN_DECL = "ast = ";
	private static final String WRITE_SPRIL_TYPE_DECL = "main :: IO ()";
	private static final String WRITE_SPRIL_FUN_DECL = "main = ";

	private static final String LPAR = "(";
	private static final String RPAR = ")";
	private static final String LSQ = "[";
	private static final String RSQ = "]";
	private static final String COLON = ":";
	
	private static final String PROG = "Prog";
	private static final String EXPR = "Expr";
	private static final String TRIN_OP = "TrinOp";
	private static final String BIN_OP = "BinOp";
	private static final String UN_OP = "UnOp";
	private static final String CREM = "Crem";
	
	private static final String DECL = "Decl";
	private static final String DECL_SHARED = "DeclShared";
	private static final String BLOCK = "Block";
	private static final String IF_THEN = "IfThen";
	private static final String IF_THEN_ELSE = "IfThenElse";
	private static final String WHILE = "While";
	private static final String PRINT = "Show";
	private static final String FORK = "Fork";
	private static final String JOIN = "Join";
	private static final String SYNC = "Sync";
	
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
	private static final String LESS_THAN_EQ = "LessThanEq";
	private static final String GREATER_THAN = "GreaterThan";
	private static final String GREATER_THAN_EQ = "GreaterThanEq";
	private static final String EQUAL = "Equal";
	private static final String NOT_EQUAL = "NotEqual";
	private static final String LOGIC_AND = "LogicAnd";
	private static final String LOGIC_OR = "LogicOr";
	private static final String ASS = "Ass";	
	
	private static final String NEG = "Neg";
	private static final String NOT = "Not";
	private static final String INCREM = "Increm";
	private static final String DECREM = "Decrem";
	
	private static final String PAR = "Par";
	private static final String BOOL = "Bool";
	private static final String IDF = "Idf";
	private static final String INT = "Int";
	private static final String TRUE = "True";
	private static final String FALSE = "False";
	private static final String ARRAY = "Array";										//TODO
	
	private static final String INT_TYPE = "IntType";
	private static final String BOOL_TYPE = "BoolType";
	private static final String ARRAY_TYPE = "ArrayType";

	private static final String HASKELL_DIR = "src/scallywags/haskell/";
	private static final String EXAMPLE_DIR = "src/scallywags/langdradig/example/";

	private final String programName;
	private final String sourceProgramPath;
	private final File sourceFile;
	
	public ASTGenerator(String sourceFilePath) {
		sourceFile = new File(sourceFilePath);
		String programName = sourceFile.getName();
		
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
	
	public String getProgramName() {
		return programName;
	}

	public File getSourceFile() {
		return sourceFile;
	}
	
	public static void main(String[] args) throws IOException {
		//temporary test main function	
		ASTGenerator gen = new ASTGenerator(EXAMPLE_DIR + "concurrencyTest1.langdradig");
		gen.writeAST(HASKELL_DIR);		
	}
	
	public String generate() throws IOException {
		return visitProgram(new LANGdradigParser(new CommonTokenStream(new LANGdradigLexer(new ANTLRFileStream(sourceProgramPath)))).program());
	}

	public void writeAST(String directory) throws IOException {
		if (!directory.endsWith(File.separator)) directory += File.separator;
		PrintWriter writer = new PrintWriter(directory + programName + ".ast.hs", "UTF-8");
		writer.write(generate());
		writer.close();
	}
	
	// -------------- Program --------------
	
	@Override
	public String visitProgram(ProgramContext ctx) {
		StringBuilder builder = new StringBuilder();
		builder.append(IMPORT_AST).append(NEWLINE).append(IMPORT_GENERATOR);
		builder.append(NEWLINE).append(NEWLINE);
		
		builder.append(AST_TYPE_DECL).append(NEWLINE);
		builder.append(AST_FUN_DECL).append(' ');
		
		builder.append(PROG).append(' ');
		builder.append(LPAR);
		for (StatementContext stmnt : ctx.statement()) {
			builder.append(visit(stmnt)).append(COLON);
		}
		builder.append(LSQ).append(RSQ);
		builder.append(RPAR).append(' ');
		
		builder.append(NEWLINE).append(NEWLINE);
		
		builder.append(WRITE_SPRIL_TYPE_DECL).append(NEWLINE);
		builder.append(WRITE_SPRIL_FUN_DECL).append("writeFile").append(' ')
			.append(QUOTE).append(programName).append(".spril.hs").append(QUOTE).append(' ')
			.append("text").append(' ').append("where").append(NEWLINE);
		builder.append(FOUR_SPACES).append("text =  ").append(NEWLINE);
		builder.append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES);
		builder.append("\"import HardwareTypes\\nimport Simulation\\n\\n\" ++").append(NEWLINE);
		builder.append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES);
		builder.append("\"prog :: [Instruction]\\n\" ++").append(NEWLINE);
		builder.append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES);
		builder.append("\"prog = \" ++ show instructions ++ \"\\n\\n\" ++ --TODO also add optimizer").append(NEWLINE);	//TODO add optimizer :-)
		builder.append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES);
		builder.append("\"main :: IO ()\\n\" ++ ").append(NEWLINE);
		builder.append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES);
		builder.append("\"main = sysRun $ replicate \" ++ show (length (t_ids state) + 1) ++ \" prog\"").append(NEWLINE);
		builder.append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES);
		builder.append(WHERE).append(NEWLINE);
		builder.append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES).append(FOUR_SPACES);
		builder.append("(instructions, state) = generate ast").append(NEWLINE);
		
		return builder.toString();
	}
	
	// -------------- Statement --------------
	
	@Override
	public String visitDeclStat(DeclStatContext ctx) {
		String identifier = visit(ctx.IDENTIFIER());
		
		return DECL + " " + QUOTE + identifier + QUOTE
				+ " " + LPAR + visit(ctx.type()) + RPAR;
	}
	
	@Override
	public String visitSharedDeclStat(SharedDeclStatContext ctx) {
		String identifier = visit(ctx.IDENTIFIER());
		
		return DECL_SHARED + " " + QUOTE + identifier + QUOTE
				+ " " + LPAR + visit(ctx.type()) + RPAR;
	}
	
	@Override
	public String visitBlockStat(BlockStatContext ctx) {
		StringBuilder builder = new StringBuilder();
		builder.append(BLOCK).append(' ');
		builder.append(LPAR);
		for (StatementContext stmnt : ctx.statement()) {
			builder.append(visit(stmnt)).append(COLON);
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
		return FORK + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE + " " + LPAR + visit(ctx.statement()) + COLON + LSQ + RSQ + RPAR;
	}
	
	@Override
	public String visitBlockForkStat(BlockForkStatContext ctx) {
		StringBuilder builder = new StringBuilder()
				.append(FORK).append(' ').append(QUOTE).append(visit(ctx.IDENTIFIER())).append(QUOTE)
				.append(' ').append(LPAR);
		ctx.statement().forEach(stat -> builder.append(visit(stat)).append(COLON));
		builder.append(LSQ).append(RSQ).append(RPAR);
		
		return builder.toString();
	}
	
	@Override
	public String visitPrintStat(PrintStatContext ctx) {
		return PRINT + " " + visit(ctx.IDENTIFIER());
	}
	
	@Override
	public String visitJoinStat(JoinStatContext ctx) {
		return JOIN + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE;
	}
	
	@Override
	public String visitSyncStat(SyncStatContext ctx) {
		return SYNC + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE
				+ " " + LPAR + visit(ctx.statement()) + RPAR;
	}
	
	// -------------- Expression --------------
	
	@Override
	public String visitPrimExpr(PrimExprContext ctx) {
		return LPAR + visit(ctx.primary()) + RPAR;
	}
	
	@Override
	public String visitNegExpr(NegExprContext ctx) {
		return UN_OP + " " + NEG + " " + LPAR + visit(ctx.expression())+ RPAR;
	}
	
	@Override
	public String visitNotExpr(NotExprContext ctx) {
		return UN_OP + " " + NOT + " " + LPAR + visit(ctx.expression())+ RPAR;
	}
	
	@Override
	public String visitCrementExpr(CrementExprContext ctx) {
		return CREM + " " + (ctx.VERLAAG() == null ? INCREM : DECREM)
				+ " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE;
	}
	
	@Override
	public String visitPowExpr(PowExprContext ctx) {
		return BIN_OP + " " + POWER
				+ " " + LPAR + visit(ctx.expression(0)) + RPAR
				+ " " + LPAR + visit(ctx.expression(1)) + RPAR;
	}
	
	@Override
	public String visitFactorExpr(FactorExprContext ctx) {
		String op = ctx.KEER() != null ? TIMES : ctx.GEDEELDDOOR() != null ? DIVIDE : MODULO; 
		return BIN_OP + " " + op
				+ " " + LPAR + visit(ctx.expression(0)) + RPAR
				+ " " + LPAR + visit(ctx.expression(1)) + RPAR;
	}
	
	@Override
	public String visitTermExpr(TermExprContext ctx) {
		String op = ctx.PLUS() != null ? PLUS : MINUS;
		return BIN_OP + " " + op
				+ " " + LPAR + visit(ctx.expression(0)) + RPAR
				+ " " + LPAR + visit(ctx.expression(1)) + RPAR;
	}
	
	@Override
	public String visitRangeExpr(RangeExprContext ctx) {
		String op = ctx.TUSSEN() != null ? BETWEEN : ctx.BINNEN() != null ? INSIDE : OUTSIDE;
		return TRIN_OP + " " + op
				+ " " + LPAR + visit(ctx.expression(0)) + RPAR
				+ " " + LPAR + visit(ctx.expression(1)) + RPAR
				+ " " + LPAR + visit(ctx.expression(2)) + RPAR;
	}
	
	@Override
	public String visitCmpExpr(CmpExprContext ctx) {
		String op =
				ctx.KLEINERDAN() != null ? LESS_THAN :
				ctx.GROTERDAN() != null ? GREATER_THAN :
				ctx.KLEINEROFGELIJK() != null ? LESS_THAN_EQ :
					GREATER_THAN_EQ;
		return BIN_OP + " " + op
				+ " " + LPAR + visit(ctx.expression(0)) + RPAR
				+ " " + LPAR + visit(ctx.expression(1)) + RPAR;
	}
	
	@Override
	public String visitEqExpr(EqExprContext ctx) {
		String op = ctx.GELIJKAAN() == null ? NOT_EQUAL : EQUAL;
		return BIN_OP + " " + op
				+ " " + LPAR + visit(ctx.expression(0)) + RPAR
				+ " " + LPAR + visit(ctx.expression(1)) + RPAR;
	}
	
	@Override
	public String visitBoolExpr(BoolExprContext ctx) {
		String op = ctx.EN() == null ? LOGIC_OR : LOGIC_AND;
		return BIN_OP + " " + op
				+ " " + LPAR + visit(ctx.expression(0)) + RPAR
				+ " " + LPAR + visit(ctx.expression(1)) + RPAR;
	}
	
	@Override
	public String visitAssExpr(AssExprContext ctx) {
		return ASS + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE
				+ " " + LPAR + visit(ctx.expression()) + RPAR;
	}
	
	// -------------- Primary --------------
	
	public String visitParExpr(ParExprContext ctx) {
		return PAR + " " + LPAR + visit(ctx.expression()) + RPAR;
	}
	
	public String visitTrueExpr(TrueExprContext ctx) {
		return BOOL + " " + TRUE;
	}
	
	public String visitFalseExpr(FalseExprContext ctx) {
		return BOOL + " " + FALSE;
	}
	
	@Override
	public String visitIdfExpr(IdfExprContext ctx) {
		return IDF + " " + QUOTE + visit(ctx.IDENTIFIER()) + QUOTE;
	}
	
	@Override
	public String visitNumExpr(NumExprContext ctx) {
		return INT + " " + visit(ctx.NUMBER());
	}
	
	// -------------- Type --------------
	
	@Override
	public String visitIntType(IntTypeContext ctx) {
		return INT_TYPE;
	}
	
	@Override
	public String visitBoolType(BoolTypeContext ctx) {
		return BOOL_TYPE;
	}
	
	@Override
	public String visitArrayType(ArrayTypeContext ctx) {
		return ARRAY_TYPE + " " + ctx.NUMBER() + " " + visit(ctx.type());
	}
	
	// -------------- Terminal --------------
	
	@Override
	public String visitTerminal(TerminalNode ctx) {
		return ctx.getText();
	}
}
