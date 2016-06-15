// Generated from LANGdradig.g4 by ANTLR 4.4
package scallywags.langdradig.grammatica;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LANGdradigParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MIN=2, KEER=3, GEDEELDDOOR=4, TOTDEMACHT=5, MODULUS=6, NIET=7, 
		EN=8, OF=9, GELIJKAAN=10, ONGELIJKAAN=11, KLEINERDAN=12, GROTERDAN=13, 
		KLEINEROFGELIJK=14, GROTEROFGELIJK=15, WORDT=16, ALS=17, DAN=18, ANDERS=19, 
		VOOR=20, ZOLANG=21, GEHEELGETAL=22, WAARHEID=23, REEKS=24, TEKST=25, WAAR=26, 
		ONWAAR=27, KLOPT=28, VERHOOG=29, HOOG=30, VERLAAG=31, LIGT=32, TUSSEN=33, 
		BINNEN=34, BUITEN=35, DOE=36, KLAAR=37, KRITIEK=38, BESTEED=39, UIT=40, 
		AAN=41, WACHT=42, PUNT=43, KOMMA=44, LH=45, RH=46, IS=47, EEN=48, OP=49, 
		NUMBER=50, IDENTIFIER=51, WITRUIMTE=52;
	public static final String[] tokenNames = {
		"<INVALID>", "PLUS", "MIN", "KEER", "GEDEELDDOOR", "TOTDEMACHT", "MODULUS", 
		"NIET", "EN", "OF", "GELIJKAAN", "ONGELIJKAAN", "KLEINERDAN", "GROTERDAN", 
		"KLEINEROFGELIJK", "GROTEROFGELIJK", "WORDT", "ALS", "DAN", "ANDERS", 
		"VOOR", "ZOLANG", "GEHEELGETAL", "WAARHEID", "REEKS", "TEKST", "WAAR", 
		"ONWAAR", "KLOPT", "VERHOOG", "HOOG", "VERLAAG", "LIGT", "TUSSEN", "BINNEN", 
		"BUITEN", "DOE", "KLAAR", "KRITIEK", "BESTEED", "UIT", "AAN", "WACHT", 
		"'.'", "','", "'('", "')'", "IS", "EEN", "OP", "NUMBER", "IDENTIFIER", 
		"WITRUIMTE"
	};
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_assignment = 2, RULE_expression = 3, 
		RULE_primary = 4, RULE_type = 5;
	public static final String[] ruleNames = {
		"program", "statement", "assignment", "expression", "primary", "type"
	};

	@Override
	public String getGrammarFileName() { return "LANGdradig.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LANGdradigParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LH) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(12); statement();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatementContext {
		public TerminalNode DAN() { return getToken(LANGdradigParser.DAN, 0); }
		public TerminalNode KLOPT() { return getToken(LANGdradigParser.KLOPT, 0); }
		public TerminalNode ANDERS() { return getToken(LANGdradigParser.ANDERS, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode NIET() { return getToken(LANGdradigParser.NIET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ALS() { return getToken(LANGdradigParser.ALS, 0); }
		public IfStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatContext extends StatementContext {
		public TerminalNode DOE() { return getToken(LANGdradigParser.DOE, 0); }
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode KLAAR() { return getToken(LANGdradigParser.KLAAR, 0); }
		public BlockStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStatContext extends StatementContext {
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitExprStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SyncStatContext extends StatementContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode KRITIEK() { return getToken(LANGdradigParser.KRITIEK, 0); }
		public SyncStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterSyncStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitSyncStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitSyncStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForkStatContext extends StatementContext {
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public TerminalNode UIT() { return getToken(LANGdradigParser.UIT, 0); }
		public TerminalNode AAN() { return getToken(LANGdradigParser.AAN, 0); }
		public TerminalNode BESTEED() { return getToken(LANGdradigParser.BESTEED, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public ForkStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterForkStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitForkStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitForkStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclStatContext extends StatementContext {
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public TerminalNode IS() { return getToken(LANGdradigParser.IS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode EEN() { return getToken(LANGdradigParser.EEN, 0); }
		public DeclStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JoinStatContext extends StatementContext {
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public TerminalNode OP() { return getToken(LANGdradigParser.OP, 0); }
		public TerminalNode WACHT() { return getToken(LANGdradigParser.WACHT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public JoinStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterJoinStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitJoinStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitJoinStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatementContext {
		public TerminalNode KLOPT() { return getToken(LANGdradigParser.KLOPT, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode NIET() { return getToken(LANGdradigParser.NIET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ZOLANG() { return getToken(LANGdradigParser.ZOLANG, 0); }
		public WhileStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		int _la;
		try {
			setState(79);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new DeclStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(18); match(IDENTIFIER);
				setState(19); match(IS);
				setState(20); match(EEN);
				setState(21); type(0);
				setState(22); match(PUNT);
				}
				break;
			case 2:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(24); match(DOE);
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LH) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(25); statement();
					}
					}
					setState(30);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(31); match(KLAAR);
				setState(32); match(PUNT);
				}
				break;
			case 3:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(33); expression(0);
				setState(34); match(PUNT);
				}
				break;
			case 4:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(36); match(ALS);
				setState(37); expression(0);
				setState(42);
				_la = _input.LA(1);
				if (_la==NIET || _la==KLOPT) {
					{
					setState(39);
					_la = _input.LA(1);
					if (_la==NIET) {
						{
						setState(38); match(NIET);
						}
					}

					setState(41); match(KLOPT);
					}
				}

				setState(44); match(DAN);
				setState(45); statement();
				setState(48);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(46); match(ANDERS);
					setState(47); statement();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(50); match(ZOLANG);
				setState(51); expression(0);
				setState(56);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(53);
					_la = _input.LA(1);
					if (_la==NIET) {
						{
						setState(52); match(NIET);
						}
					}

					setState(55); match(KLOPT);
					}
					break;
				}
				setState(58); statement();
				}
				break;
			case 6:
				_localctx = new ForkStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(60); match(BESTEED);
				setState(61); match(UIT);
				setState(62); match(AAN);
				setState(63); match(IDENTIFIER);
				setState(64); statement();
				}
				break;
			case 7:
				_localctx = new ForkStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(65); match(BESTEED);
				setState(66); statement();
				setState(67); match(UIT);
				setState(68); match(AAN);
				setState(69); match(IDENTIFIER);
				setState(70); match(PUNT);
				}
				break;
			case 8:
				_localctx = new JoinStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(72); match(WACHT);
				setState(73); match(OP);
				setState(74); match(IDENTIFIER);
				setState(75); match(PUNT);
				}
				break;
			case 9:
				_localctx = new SyncStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(76); match(KRITIEK);
				setState(77); match(IDENTIFIER);
				setState(78); statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode WORDT() { return getToken(LANGdradigParser.WORDT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); match(IDENTIFIER);
			setState(82); match(WORDT);
			setState(83); expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqExprContext extends ExpressionContext {
		public TerminalNode GELIJKAAN() { return getToken(LANGdradigParser.GELIJKAAN, 0); }
		public TerminalNode ONGELIJKAAN() { return getToken(LANGdradigParser.ONGELIJKAAN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public EqExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitEqExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitEqExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotExprContext extends ExpressionContext {
		public TerminalNode NIET() { return getToken(LANGdradigParser.NIET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterNotExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitNotExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitNotExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimExprContext extends ExpressionContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public PrimExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterPrimExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitPrimExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitPrimExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegExprContext extends ExpressionContext {
		public TerminalNode MIN() { return getToken(LANGdradigParser.MIN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NegExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterNegExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitNegExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitNegExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TermExprContext extends ExpressionContext {
		public TerminalNode MIN() { return getToken(LANGdradigParser.MIN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(LANGdradigParser.PLUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TermExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterTermExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitTermExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitTermExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssExprContext extends ExpressionContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterAssExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitAssExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitAssExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CrementExprContext extends ExpressionContext {
		public TerminalNode OP() { return getToken(LANGdradigParser.OP, 0); }
		public TerminalNode VERLAAG() { return getToken(LANGdradigParser.VERLAAG, 0); }
		public TerminalNode HOOG() { return getToken(LANGdradigParser.HOOG, 0); }
		public TerminalNode VERHOOG() { return getToken(LANGdradigParser.VERHOOG, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public CrementExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterCrementExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitCrementExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitCrementExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PowExprContext extends ExpressionContext {
		public TerminalNode TOTDEMACHT() { return getToken(LANGdradigParser.TOTDEMACHT, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public PowExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterPowExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitPowExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitPowExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends ExpressionContext {
		public TerminalNode OF() { return getToken(LANGdradigParser.OF, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EN() { return getToken(LANGdradigParser.EN, 0); }
		public BoolExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorExprContext extends ExpressionContext {
		public TerminalNode KEER() { return getToken(LANGdradigParser.KEER, 0); }
		public TerminalNode GEDEELDDOOR() { return getToken(LANGdradigParser.GEDEELDDOOR, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MODULUS() { return getToken(LANGdradigParser.MODULUS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public FactorExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterFactorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitFactorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitFactorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RangeExprContext extends ExpressionContext {
		public TerminalNode BINNEN() { return getToken(LANGdradigParser.BINNEN, 0); }
		public TerminalNode LIGT() { return getToken(LANGdradigParser.LIGT, 0); }
		public TerminalNode BUITEN() { return getToken(LANGdradigParser.BUITEN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TUSSEN() { return getToken(LANGdradigParser.TUSSEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EN() { return getToken(LANGdradigParser.EN, 0); }
		public RangeExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterRangeExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitRangeExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitRangeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CmpExprContext extends ExpressionContext {
		public TerminalNode GROTERDAN() { return getToken(LANGdradigParser.GROTERDAN, 0); }
		public TerminalNode GROTEROFGELIJK() { return getToken(LANGdradigParser.GROTEROFGELIJK, 0); }
		public TerminalNode KLEINEROFGELIJK() { return getToken(LANGdradigParser.KLEINEROFGELIJK, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode KLEINERDAN() { return getToken(LANGdradigParser.KLEINERDAN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CmpExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterCmpExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitCmpExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitCmpExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(86); match(MIN);
				setState(87); expression(12);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88); match(NIET);
				setState(89); expression(11);
				}
				break;
			case 3:
				{
				_localctx = new PrimExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90); primary();
				}
				break;
			case 4:
				{
				_localctx = new CrementExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				switch (_input.LA(1)) {
				case VERHOOG:
				case VERLAAG:
					{
					{
					setState(91);
					_la = _input.LA(1);
					if ( !(_la==VERHOOG || _la==VERLAAG) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(92); match(IDENTIFIER);
					}
					}
					break;
				case HOOG:
					{
					{
					setState(93); match(HOOG);
					setState(94); match(IDENTIFIER);
					setState(95); match(OP);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				{
				_localctx = new AssExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98); assignment();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(133);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(101);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(102); match(TOTDEMACHT);
						setState(103); expression(9);
						}
						break;
					case 2:
						{
						_localctx = new FactorExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(104);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(105);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEER) | (1L << GEDEELDDOOR) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(106); expression(9);
						}
						break;
					case 3:
						{
						_localctx = new TermExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(107);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(108);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MIN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(109); expression(8);
						}
						break;
					case 4:
						{
						_localctx = new RangeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(110);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(111); match(LIGT);
						setState(112);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TUSSEN) | (1L << BINNEN) | (1L << BUITEN))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(113); expression(0);
						setState(114); match(EN);
						setState(115); expression(7);
						}
						break;
					case 5:
						{
						_localctx = new CmpExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(117);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(118);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KLEINERDAN) | (1L << GROTERDAN) | (1L << KLEINEROFGELIJK) | (1L << GROTEROFGELIJK))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(119); expression(5);
						}
						break;
					case 6:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(121);
						_la = _input.LA(1);
						if ( !(_la==GELIJKAAN || _la==ONGELIJKAAN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(122); expression(4);
						}
						break;
					case 7:
						{
						_localctx = new BoolExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(123);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(124);
						_la = _input.LA(1);
						if ( !(_la==EN || _la==OF) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(125); expression(3);
						}
						break;
					case 8:
						{
						_localctx = new RangeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(127);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TUSSEN) | (1L << BINNEN) | (1L << BUITEN))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(128); expression(0);
						setState(129); match(EN);
						setState(130); expression(0);
						setState(131); match(LIGT);
						}
						break;
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ParExprContext extends PrimaryContext {
		public TerminalNode RH() { return getToken(LANGdradigParser.RH, 0); }
		public TerminalNode LH() { return getToken(LANGdradigParser.LH, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterParExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitParExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitParExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdfExprContext extends PrimaryContext {
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public IdfExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterIdfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitIdfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitIdfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueExprContext extends PrimaryContext {
		public TerminalNode WAAR() { return getToken(LANGdradigParser.WAAR, 0); }
		public TrueExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterTrueExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitTrueExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitTrueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FalseExprContext extends PrimaryContext {
		public TerminalNode ONWAAR() { return getToken(LANGdradigParser.ONWAAR, 0); }
		public FalseExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterFalseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitFalseExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitFalseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumExprContext extends PrimaryContext {
		public TerminalNode NUMBER() { return getToken(LANGdradigParser.NUMBER, 0); }
		public NumExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterNumExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitNumExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitNumExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primary);
		try {
			setState(146);
			switch (_input.LA(1)) {
			case LH:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138); match(LH);
				setState(139); expression(0);
				setState(140); match(RH);
				}
				break;
			case WAAR:
				_localctx = new TrueExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(142); match(WAAR);
				}
				break;
			case ONWAAR:
				_localctx = new FalseExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(143); match(ONWAAR);
				}
				break;
			case IDENTIFIER:
				_localctx = new IdfExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(144); match(IDENTIFIER);
				}
				break;
			case NUMBER:
				_localctx = new NumExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(145); match(NUMBER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode REEKS() { return getToken(LANGdradigParser.REEKS, 0); }
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntTypeContext extends TypeContext {
		public TerminalNode GEHEELGETAL() { return getToken(LANGdradigParser.GEHEELGETAL, 0); }
		public IntTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterIntType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitIntType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitIntType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolTypeContext extends TypeContext {
		public TerminalNode WAARHEID() { return getToken(LANGdradigParser.WAARHEID, 0); }
		public BoolTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterBoolType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitBoolType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitBoolType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			switch (_input.LA(1)) {
			case GEHEELGETAL:
				{
				_localctx = new IntTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(149); match(GEHEELGETAL);
				}
				break;
			case WAARHEID:
				{
				_localctx = new BoolTypeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(150); match(WAARHEID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(153);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(154); match(REEKS);
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3: return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 5: return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 9);
		case 1: return precpred(_ctx, 8);
		case 2: return precpred(_ctx, 7);
		case 3: return precpred(_ctx, 6);
		case 4: return precpred(_ctx, 4);
		case 5: return precpred(_ctx, 3);
		case 6: return precpred(_ctx, 2);
		case 7: return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\66\u00a3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\7\2\20\n\2\f\2\16\2\23\13"+
		"\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\35\n\3\f\3\16\3 \13\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3*\n\3\3\3\5\3-\n\3\3\3\3\3\3\3\3\3\5\3\63\n"+
		"\3\3\3\3\3\3\3\5\38\n\3\3\3\5\3;\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3R\n\3\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5c\n\5\3\5\5\5f\n"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u0088"+
		"\n\5\f\5\16\5\u008b\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0095\n\6"+
		"\3\7\3\7\3\7\5\7\u009a\n\7\3\7\3\7\7\7\u009e\n\7\f\7\16\7\u00a1\13\7\3"+
		"\7\2\4\b\f\b\2\4\6\b\n\f\2\t\4\2\37\37!!\4\2\5\6\b\b\3\2\3\4\3\2#%\3\2"+
		"\16\21\3\2\f\r\3\2\n\13\u00be\2\21\3\2\2\2\4Q\3\2\2\2\6S\3\2\2\2\be\3"+
		"\2\2\2\n\u0094\3\2\2\2\f\u0099\3\2\2\2\16\20\5\4\3\2\17\16\3\2\2\2\20"+
		"\23\3\2\2\2\21\17\3\2\2\2\21\22\3\2\2\2\22\3\3\2\2\2\23\21\3\2\2\2\24"+
		"\25\7\65\2\2\25\26\7\61\2\2\26\27\7\62\2\2\27\30\5\f\7\2\30\31\7-\2\2"+
		"\31R\3\2\2\2\32\36\7&\2\2\33\35\5\4\3\2\34\33\3\2\2\2\35 \3\2\2\2\36\34"+
		"\3\2\2\2\36\37\3\2\2\2\37!\3\2\2\2 \36\3\2\2\2!\"\7\'\2\2\"R\7-\2\2#$"+
		"\5\b\5\2$%\7-\2\2%R\3\2\2\2&\'\7\23\2\2\',\5\b\5\2(*\7\t\2\2)(\3\2\2\2"+
		")*\3\2\2\2*+\3\2\2\2+-\7\36\2\2,)\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7\24\2"+
		"\2/\62\5\4\3\2\60\61\7\25\2\2\61\63\5\4\3\2\62\60\3\2\2\2\62\63\3\2\2"+
		"\2\63R\3\2\2\2\64\65\7\27\2\2\65:\5\b\5\2\668\7\t\2\2\67\66\3\2\2\2\67"+
		"8\3\2\2\289\3\2\2\29;\7\36\2\2:\67\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\5\4\3"+
		"\2=R\3\2\2\2>?\7)\2\2?@\7*\2\2@A\7+\2\2AB\7\65\2\2BR\5\4\3\2CD\7)\2\2"+
		"DE\5\4\3\2EF\7*\2\2FG\7+\2\2GH\7\65\2\2HI\7-\2\2IR\3\2\2\2JK\7,\2\2KL"+
		"\7\63\2\2LM\7\65\2\2MR\7-\2\2NO\7(\2\2OP\7\65\2\2PR\5\4\3\2Q\24\3\2\2"+
		"\2Q\32\3\2\2\2Q#\3\2\2\2Q&\3\2\2\2Q\64\3\2\2\2Q>\3\2\2\2QC\3\2\2\2QJ\3"+
		"\2\2\2QN\3\2\2\2R\5\3\2\2\2ST\7\65\2\2TU\7\22\2\2UV\5\b\5\2V\7\3\2\2\2"+
		"WX\b\5\1\2XY\7\4\2\2Yf\5\b\5\16Z[\7\t\2\2[f\5\b\5\r\\f\5\n\6\2]^\t\2\2"+
		"\2^c\7\65\2\2_`\7 \2\2`a\7\65\2\2ac\7\63\2\2b]\3\2\2\2b_\3\2\2\2cf\3\2"+
		"\2\2df\5\6\4\2eW\3\2\2\2eZ\3\2\2\2e\\\3\2\2\2eb\3\2\2\2ed\3\2\2\2f\u0089"+
		"\3\2\2\2gh\f\13\2\2hi\7\7\2\2i\u0088\5\b\5\13jk\f\n\2\2kl\t\3\2\2l\u0088"+
		"\5\b\5\13mn\f\t\2\2no\t\4\2\2o\u0088\5\b\5\npq\f\b\2\2qr\7\"\2\2rs\t\5"+
		"\2\2st\5\b\5\2tu\7\n\2\2uv\5\b\5\tv\u0088\3\2\2\2wx\f\6\2\2xy\t\6\2\2"+
		"y\u0088\5\b\5\7z{\f\5\2\2{|\t\7\2\2|\u0088\5\b\5\6}~\f\4\2\2~\177\t\b"+
		"\2\2\177\u0088\5\b\5\5\u0080\u0081\f\7\2\2\u0081\u0082\t\5\2\2\u0082\u0083"+
		"\5\b\5\2\u0083\u0084\7\n\2\2\u0084\u0085\5\b\5\2\u0085\u0086\7\"\2\2\u0086"+
		"\u0088\3\2\2\2\u0087g\3\2\2\2\u0087j\3\2\2\2\u0087m\3\2\2\2\u0087p\3\2"+
		"\2\2\u0087w\3\2\2\2\u0087z\3\2\2\2\u0087}\3\2\2\2\u0087\u0080\3\2\2\2"+
		"\u0088\u008b\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\t\3"+
		"\2\2\2\u008b\u0089\3\2\2\2\u008c\u008d\7/\2\2\u008d\u008e\5\b\5\2\u008e"+
		"\u008f\7\60\2\2\u008f\u0095\3\2\2\2\u0090\u0095\7\34\2\2\u0091\u0095\7"+
		"\35\2\2\u0092\u0095\7\65\2\2\u0093\u0095\7\64\2\2\u0094\u008c\3\2\2\2"+
		"\u0094\u0090\3\2\2\2\u0094\u0091\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0093"+
		"\3\2\2\2\u0095\13\3\2\2\2\u0096\u0097\b\7\1\2\u0097\u009a\7\30\2\2\u0098"+
		"\u009a\7\31\2\2\u0099\u0096\3\2\2\2\u0099\u0098\3\2\2\2\u009a\u009f\3"+
		"\2\2\2\u009b\u009c\f\3\2\2\u009c\u009e\7\32\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\r\3\2\2\2"+
		"\u00a1\u009f\3\2\2\2\21\21\36),\62\67:Qbe\u0087\u0089\u0094\u0099\u009f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}