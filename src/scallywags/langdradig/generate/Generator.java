package scallywags.langdradig.generate;

import java.util.Objects;

import scallywags.langdradig.grammatica.LANGdradigBaseVisitor;
import scallywags.langdradig.grammatica.LANGdradigParser.ProgramContext;

public class Generator extends LANGdradigBaseVisitor<Void> {

	private static final String MODULE = "module";
	private static final String WHERE = "where";
	private static final String IMPORT = "import AST";
	
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
	private final StringBuilder builder = new StringBuilder();

	public Generator(String programName) {
		if (programName == null || programName.isEmpty()) {
			throw new IllegalArgumentException("Program name cannot be empty or null.");
		}
		this.programName = programName.substring(0, 1).toUpperCase() + programName.substring(1).toLowerCase();
	}
	
	@Override
	public Void visitProgram(ProgramContext ctx) {
		
		builder.append(MODULE).append(' ').append(WHERE);
		builder.append(System.lineSeparator());
		builder.append(IMPORT);
		
		return null;
	}
	
	public String toString() {
		return builder.toString();
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
