// Generated from LANGdradig.g4 by ANTLR 4.4
package scallywags.langdradig.grammatica;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LANGdradigParser}.
 */
public interface LANGdradigListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(@NotNull LANGdradigParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(@NotNull LANGdradigParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterTrueExpr(@NotNull LANGdradigParser.TrueExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitTrueExpr(@NotNull LANGdradigParser.TrueExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTermExpr(@NotNull LANGdradigParser.TermExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTermExpr(@NotNull LANGdradigParser.TermExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code syncStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSyncStat(@NotNull LANGdradigParser.SyncStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code syncStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSyncStat(@NotNull LANGdradigParser.SyncStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code declStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDeclStat(@NotNull LANGdradigParser.DeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code declStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDeclStat(@NotNull LANGdradigParser.DeclStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGdradigParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull LANGdradigParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGdradigParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull LANGdradigParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpr(@NotNull LANGdradigParser.FactorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpr(@NotNull LANGdradigParser.FactorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBoolType(@NotNull LANGdradigParser.BoolTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBoolType(@NotNull LANGdradigParser.BoolTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cmpExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCmpExpr(@NotNull LANGdradigParser.CmpExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cmpExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCmpExpr(@NotNull LANGdradigParser.CmpExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterParExpr(@NotNull LANGdradigParser.ParExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitParExpr(@NotNull LANGdradigParser.ParExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idfExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIdfExpr(@NotNull LANGdradigParser.IdfExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idfExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIdfExpr(@NotNull LANGdradigParser.IdfExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGdradigParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull LANGdradigParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGdradigParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull LANGdradigParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code crementExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCrementExpr(@NotNull LANGdradigParser.CrementExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code crementExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCrementExpr(@NotNull LANGdradigParser.CrementExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterFalseExpr(@NotNull LANGdradigParser.FalseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitFalseExpr(@NotNull LANGdradigParser.FalseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(@NotNull LANGdradigParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(@NotNull LANGdradigParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(@NotNull LANGdradigParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(@NotNull LANGdradigParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(@NotNull LANGdradigParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(@NotNull LANGdradigParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code primExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimExpr(@NotNull LANGdradigParser.PrimExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code primExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimExpr(@NotNull LANGdradigParser.PrimExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(@NotNull LANGdradigParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(@NotNull LANGdradigParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGdradigParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(@NotNull LANGdradigParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGdradigParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(@NotNull LANGdradigParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull LANGdradigParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull LANGdradigParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forkStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForkStat(@NotNull LANGdradigParser.ForkStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forkStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForkStat(@NotNull LANGdradigParser.ForkStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code joinStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterJoinStat(@NotNull LANGdradigParser.JoinStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code joinStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitJoinStat(@NotNull LANGdradigParser.JoinStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LANGdradigParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(@NotNull LANGdradigParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LANGdradigParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(@NotNull LANGdradigParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterNumExpr(@NotNull LANGdradigParser.NumExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitNumExpr(@NotNull LANGdradigParser.NumExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqExpr(@NotNull LANGdradigParser.EqExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqExpr(@NotNull LANGdradigParser.EqExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(@NotNull LANGdradigParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(@NotNull LANGdradigParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNegExpr(@NotNull LANGdradigParser.NegExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNegExpr(@NotNull LANGdradigParser.NegExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssExpr(@NotNull LANGdradigParser.AssExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssExpr(@NotNull LANGdradigParser.AssExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(@NotNull LANGdradigParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(@NotNull LANGdradigParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(@NotNull LANGdradigParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(@NotNull LANGdradigParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rangeExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterRangeExpr(@NotNull LANGdradigParser.RangeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rangeExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitRangeExpr(@NotNull LANGdradigParser.RangeExprContext ctx);
}