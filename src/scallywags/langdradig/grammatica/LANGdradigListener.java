// Generated from C:/Users/Jeroen Weener/Documents/Intellij Projects/LANGdradig/src/scallywags/langdradig/grammatica\LANGdradig.g4 by ANTLR 4.5.1
package scallywags.langdradig.grammatica;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LANGdradigParser}.
 */
public interface LANGdradigListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LANGdradigParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(LANGdradigParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGdradigParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(LANGdradigParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclStat(LANGdradigParser.DeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclStat(LANGdradigParser.DeclStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(LANGdradigParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(LANGdradigParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(LANGdradigParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(LANGdradigParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(LANGdradigParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(LANGdradigParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(LANGdradigParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(LANGdradigParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forkStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForkStat(LANGdradigParser.ForkStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forkStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForkStat(LANGdradigParser.ForkStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joinStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJoinStat(LANGdradigParser.JoinStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joinStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJoinStat(LANGdradigParser.JoinStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code syncStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSyncStat(LANGdradigParser.SyncStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code syncStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSyncStat(LANGdradigParser.SyncStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGdradigParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(LANGdradigParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGdradigParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(LANGdradigParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGdradigParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LANGdradigParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGdradigParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LANGdradigParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGdradigParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(LANGdradigParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGdradigParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(LANGdradigParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(LANGdradigParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(LANGdradigParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(LANGdradigParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(LANGdradigParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimExpr(LANGdradigParser.PrimExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimExpr(LANGdradigParser.PrimExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(LANGdradigParser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(LANGdradigParser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(LANGdradigParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(LANGdradigParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssExpr(LANGdradigParser.AssExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssExpr(LANGdradigParser.AssExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code crementExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCrementExpr(LANGdradigParser.CrementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code crementExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCrementExpr(LANGdradigParser.CrementExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(LANGdradigParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(LANGdradigParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(LANGdradigParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(LANGdradigParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpr(LANGdradigParser.FactorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpr(LANGdradigParser.FactorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rangeExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRangeExpr(LANGdradigParser.RangeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rangeExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRangeExpr(LANGdradigParser.RangeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmpExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCmpExpr(LANGdradigParser.CmpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmpExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCmpExpr(LANGdradigParser.CmpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(LANGdradigParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(LANGdradigParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(LANGdradigParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(LANGdradigParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(LANGdradigParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(LANGdradigParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idfExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIdfExpr(LANGdradigParser.IdfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idfExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIdfExpr(LANGdradigParser.IdfExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(LANGdradigParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(LANGdradigParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(LANGdradigParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(LANGdradigParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(LANGdradigParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(LANGdradigParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(LANGdradigParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(LANGdradigParser.BoolTypeContext ctx);
}