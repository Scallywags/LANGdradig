// Generated from LANGdradig.g4 by ANTLR 4.4
package scallywags.langdradig.grammatica;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LANGdradigParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LANGdradigVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(@NotNull LANGdradigParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueExpr(@NotNull LANGdradigParser.TrueExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code termExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermExpr(@NotNull LANGdradigParser.TermExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code syncStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSyncStat(@NotNull LANGdradigParser.SyncStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclStat(@NotNull LANGdradigParser.DeclStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LANGdradigParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull LANGdradigParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorExpr(@NotNull LANGdradigParser.FactorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolType(@NotNull LANGdradigParser.BoolTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExpr(@NotNull LANGdradigParser.CmpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParExpr(@NotNull LANGdradigParser.ParExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idfExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdfExpr(@NotNull LANGdradigParser.IdfExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link LANGdradigParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(@NotNull LANGdradigParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code crementExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCrementExpr(@NotNull LANGdradigParser.CrementExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code falseExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseExpr(@NotNull LANGdradigParser.FalseExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(@NotNull LANGdradigParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(@NotNull LANGdradigParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(@NotNull LANGdradigParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code primExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimExpr(@NotNull LANGdradigParser.PrimExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(@NotNull LANGdradigParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LANGdradigParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull LANGdradigParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intType}
	 * labeled alternative in {@link LANGdradigParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull LANGdradigParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forkStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForkStat(@NotNull LANGdradigParser.ForkStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code joinStat}
	 * labeled alternative in {@link LANGdradigParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJoinStat(@NotNull LANGdradigParser.JoinStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link LANGdradigParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(@NotNull LANGdradigParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numExpr}
	 * labeled alternative in {@link LANGdradigParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumExpr(@NotNull LANGdradigParser.NumExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqExpr(@NotNull LANGdradigParser.EqExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(@NotNull LANGdradigParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegExpr(@NotNull LANGdradigParser.NegExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssExpr(@NotNull LANGdradigParser.AssExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(@NotNull LANGdradigParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(@NotNull LANGdradigParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rangeExpr}
	 * labeled alternative in {@link LANGdradigParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeExpr(@NotNull LANGdradigParser.RangeExprContext ctx);
}