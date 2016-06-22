package scallywags.langdradig.ide;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;
import scallywags.langdradig.grammatica.LANGdradigBaseListener;
import scallywags.langdradig.grammatica.LANGdradigParser;

/**
 * Created by Jeroen Weener on 21/06/2016.
 */
public class TreeFormatter extends LANGdradigBaseListener {
    private ParseTreeProperty<Integer> indentationLevel = new ParseTreeProperty<>();

    @Override
    public void enterProgram(LANGdradigParser.ProgramContext ctx) {
        indentationLevel.put(ctx, 0);
    }

    @Override
    public void enterDeclStat(LANGdradigParser.DeclStatContext ctx) {
        putSameIndentationAsParent(ctx);
    }

    @Override
    public void enterSharedDeclStat(LANGdradigParser.SharedDeclStatContext ctx) {
        putSameIndentationAsParent(ctx);
    }

    @Override
    public void enterBlockStat(LANGdradigParser.BlockStatContext ctx) {
//        ctx.statement()
    }

    @Override
    public void exitBlockStat(LANGdradigParser.BlockStatContext ctx) {

    }

    @Override
    public void enterExprStat(LANGdradigParser.ExprStatContext ctx) {

    }

    @Override
    public void exitExprStat(LANGdradigParser.ExprStatContext ctx) {

    }

    @Override
    public void enterIfStat(LANGdradigParser.IfStatContext ctx) {

    }

    @Override
    public void exitIfStat(LANGdradigParser.IfStatContext ctx) {

    }

    @Override
    public void enterWhileStat(LANGdradigParser.WhileStatContext ctx) {

    }

    @Override
    public void exitWhileStat(LANGdradigParser.WhileStatContext ctx) {

    }

    @Override
    public void enterForkStat(LANGdradigParser.ForkStatContext ctx) {

    }

    @Override
    public void exitForkStat(LANGdradigParser.ForkStatContext ctx) {

    }

    @Override
    public void enterJoinStat(LANGdradigParser.JoinStatContext ctx) {

    }

    @Override
    public void exitJoinStat(LANGdradigParser.JoinStatContext ctx) {

    }

    @Override
    public void enterSyncStat(LANGdradigParser.SyncStatContext ctx) {

    }

    @Override
    public void exitSyncStat(LANGdradigParser.SyncStatContext ctx) {

    }

    @Override
    public void enterEqExpr(LANGdradigParser.EqExprContext ctx) {

    }

    @Override
    public void exitEqExpr(LANGdradigParser.EqExprContext ctx) {

    }

    @Override
    public void enterNotExpr(LANGdradigParser.NotExprContext ctx) {

    }

    @Override
    public void exitNotExpr(LANGdradigParser.NotExprContext ctx) {

    }

    @Override
    public void enterPrimExpr(LANGdradigParser.PrimExprContext ctx) {

    }

    @Override
    public void exitPrimExpr(LANGdradigParser.PrimExprContext ctx) {

    }

    @Override
    public void enterNegExpr(LANGdradigParser.NegExprContext ctx) {

    }

    @Override
    public void exitNegExpr(LANGdradigParser.NegExprContext ctx) {

    }

    @Override
    public void enterTermExpr(LANGdradigParser.TermExprContext ctx) {

    }

    @Override
    public void exitTermExpr(LANGdradigParser.TermExprContext ctx) {

    }

    @Override
    public void enterAssExpr(LANGdradigParser.AssExprContext ctx) {

    }

    @Override
    public void exitAssExpr(LANGdradigParser.AssExprContext ctx) {

    }

    @Override
    public void enterCrementExpr(LANGdradigParser.CrementExprContext ctx) {

    }

    @Override
    public void exitCrementExpr(LANGdradigParser.CrementExprContext ctx) {

    }

    @Override
    public void enterPowExpr(LANGdradigParser.PowExprContext ctx) {

    }

    @Override
    public void exitPowExpr(LANGdradigParser.PowExprContext ctx) {

    }

    @Override
    public void enterBoolExpr(LANGdradigParser.BoolExprContext ctx) {

    }

    @Override
    public void exitBoolExpr(LANGdradigParser.BoolExprContext ctx) {

    }

    @Override
    public void enterFactorExpr(LANGdradigParser.FactorExprContext ctx) {

    }

    @Override
    public void exitFactorExpr(LANGdradigParser.FactorExprContext ctx) {

    }

    @Override
    public void enterRangeExpr(LANGdradigParser.RangeExprContext ctx) {

    }

    @Override
    public void exitRangeExpr(LANGdradigParser.RangeExprContext ctx) {

    }

    @Override
    public void enterCmpExpr(LANGdradigParser.CmpExprContext ctx) {

    }

    @Override
    public void exitCmpExpr(LANGdradigParser.CmpExprContext ctx) {

    }

    @Override
    public void enterParExpr(LANGdradigParser.ParExprContext ctx) {

    }

    @Override
    public void exitParExpr(LANGdradigParser.ParExprContext ctx) {

    }

    @Override
    public void enterTrueExpr(LANGdradigParser.TrueExprContext ctx) {

    }

    @Override
    public void exitTrueExpr(LANGdradigParser.TrueExprContext ctx) {

    }

    @Override
    public void enterFalseExpr(LANGdradigParser.FalseExprContext ctx) {

    }

    @Override
    public void exitFalseExpr(LANGdradigParser.FalseExprContext ctx) {

    }

    @Override
    public void enterIdfExpr(LANGdradigParser.IdfExprContext ctx) {

    }

    @Override
    public void exitIdfExpr(LANGdradigParser.IdfExprContext ctx) {

    }

    @Override
    public void enterNumExpr(LANGdradigParser.NumExprContext ctx) {

    }

    @Override
    public void exitNumExpr(LANGdradigParser.NumExprContext ctx) {

    }

    @Override
    public void enterIntType(LANGdradigParser.IntTypeContext ctx) {

    }

    @Override
    public void exitIntType(LANGdradigParser.IntTypeContext ctx) {

    }

    @Override
    public void enterBoolType(LANGdradigParser.BoolTypeContext ctx) {

    }

    @Override
    public void exitBoolType(LANGdradigParser.BoolTypeContext ctx) {

    }

    @Override
    public void enterArrayType(LANGdradigParser.ArrayTypeContext ctx) {

    }

    @Override
    public void exitArrayType(LANGdradigParser.ArrayTypeContext ctx) {

    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {

    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }

    private void putSameIndentationAsParent(ParserRuleContext ctx) {
        indentationLevel.put(ctx, indentationLevel.get(ctx.getParent()));
    }
}
