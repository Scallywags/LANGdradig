// Generated from C:/Users/Jeroen Weener/Documents/Intellij Projects/LANGdradig/src/scallywags/langdradig/grammatica\LANGdradig.g4 by ANTLR 4.5.1
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MIN=2, KEER=3, GEDEELDDOOR=4, TOTDEMACHT=5, MODULUS=6, NIET=7, 
		EN=8, OF=9, GELIJKAAN=10, ONGELIJKAAN=11, KLEINERDAN=12, GROTERDAN=13, 
		KLEINEROFGELIJK=14, GROTEROFGELIJK=15, WORDT=16, ALS=17, DAN=18, ANDERS=19, 
		VOOR=20, ZOLANG=21, GETAL=22, STELLING=23, REEKS=24, TEKST=25, WAAR=26, 
		ONWAAR=27, KLOPT=28, VERHOOG=29, HOOG=30, VERLAAG=31, LIGT=32, TUSSEN=33, 
		BINNEN=34, BUITEN=35, DOE=36, KLAAR=37, KRITIEK=38, BESTEED=39, UIT=40, 
		AAN=41, WACHT=42, GEDEELDE=43, PUNT=44, KOMMA=45, LH=46, RH=47, IS=48, 
		EEN=49, OP=50, VAN=51, NUMBER=52, IDENTIFIER=53, COMMENTAAR=54, WITRUIMTE=55;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_expression = 2, RULE_primary = 3, 
		RULE_type = 4;
	public static final String[] ruleNames = {
		"program", "statement", "expression", "primary", "type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, "'.'", "','", "'('", "')'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PLUS", "MIN", "KEER", "GEDEELDDOOR", "TOTDEMACHT", "MODULUS", "NIET", 
		"EN", "OF", "GELIJKAAN", "ONGELIJKAAN", "KLEINERDAN", "GROTERDAN", "KLEINEROFGELIJK", 
		"GROTEROFGELIJK", "WORDT", "ALS", "DAN", "ANDERS", "VOOR", "ZOLANG", "GETAL", 
		"STELLING", "REEKS", "TEKST", "WAAR", "ONWAAR", "KLOPT", "VERHOOG", "HOOG", 
		"VERLAAG", "LIGT", "TUSSEN", "BINNEN", "BUITEN", "DOE", "KLAAR", "KRITIEK", 
		"BESTEED", "UIT", "AAN", "WACHT", "GEDEELDE", "PUNT", "KOMMA", "LH", "RH", 
		"IS", "EEN", "OP", "VAN", "NUMBER", "IDENTIFIER", "COMMENTAAR", "WITRUIMTE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "LANGdradig.g4"; }

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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LH) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(10);
				statement();
				}
				}
				setState(15);
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
		public TerminalNode ALS() { return getToken(LANGdradigParser.ALS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DAN() { return getToken(LANGdradigParser.DAN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode KLOPT() { return getToken(LANGdradigParser.KLOPT, 0); }
		public TerminalNode ANDERS() { return getToken(LANGdradigParser.ANDERS, 0); }
		public TerminalNode NIET() { return getToken(LANGdradigParser.NIET, 0); }
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
		public TerminalNode KLAAR() { return getToken(LANGdradigParser.KLAAR, 0); }
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
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
		public TerminalNode KRITIEK() { return getToken(LANGdradigParser.KRITIEK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
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
		public TerminalNode BESTEED() { return getToken(LANGdradigParser.BESTEED, 0); }
		public TerminalNode UIT() { return getToken(LANGdradigParser.UIT, 0); }
		public TerminalNode AAN() { return getToken(LANGdradigParser.AAN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
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
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode IS() { return getToken(LANGdradigParser.IS, 0); }
		public TerminalNode EEN() { return getToken(LANGdradigParser.EEN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public TerminalNode GEDEELDE() { return getToken(LANGdradigParser.GEDEELDE, 0); }
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
		public TerminalNode WACHT() { return getToken(LANGdradigParser.WACHT, 0); }
		public TerminalNode OP() { return getToken(LANGdradigParser.OP, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
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
		public TerminalNode ZOLANG() { return getToken(LANGdradigParser.ZOLANG, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode KLOPT() { return getToken(LANGdradigParser.KLOPT, 0); }
		public TerminalNode NIET() { return getToken(LANGdradigParser.NIET, 0); }
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
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new DeclStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(16);
				match(IDENTIFIER);
				setState(17);
				match(IS);
				setState(18);
				match(EEN);
				setState(20);
				_la = _input.LA(1);
				if (_la==GEDEELDE) {
					{
					setState(19);
					match(GEDEELDE);
					}
				}

				setState(22);
				type();
				setState(23);
				match(PUNT);
				}
				break;
			case 2:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(DOE);
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LH) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(26);
					statement();
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(32);
				match(KLAAR);
				setState(33);
				match(PUNT);
				}
				break;
			case 3:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				expression(0);
				setState(35);
				match(PUNT);
				}
				break;
			case 4:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(37);
				match(ALS);
				setState(38);
				expression(0);
				setState(43);
				_la = _input.LA(1);
				if (_la==NIET || _la==KLOPT) {
					{
					setState(40);
					_la = _input.LA(1);
					if (_la==NIET) {
						{
						setState(39);
						match(NIET);
						}
					}

					setState(42);
					match(KLOPT);
					}
				}

				setState(45);
				match(DAN);
				setState(46);
				statement();
				setState(49);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(47);
					match(ANDERS);
					setState(48);
					statement();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(51);
				match(ZOLANG);
				setState(52);
				expression(0);
				setState(57);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(54);
					_la = _input.LA(1);
					if (_la==NIET) {
						{
						setState(53);
						match(NIET);
						}
					}

					setState(56);
					match(KLOPT);
					}
					break;
				}
				setState(59);
				statement();
				}
				break;
			case 6:
				_localctx = new ForkStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(61);
				match(BESTEED);
				setState(62);
				match(UIT);
				setState(63);
				match(AAN);
				setState(64);
				match(IDENTIFIER);
				setState(65);
				statement();
				}
				break;
			case 7:
				_localctx = new ForkStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(66);
				match(BESTEED);
				setState(67);
				statement();
				setState(68);
				match(UIT);
				setState(69);
				match(AAN);
				setState(70);
				match(IDENTIFIER);
				setState(71);
				match(PUNT);
				}
				break;
			case 8:
				_localctx = new JoinStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(73);
				match(WACHT);
				setState(74);
				match(OP);
				setState(75);
				match(IDENTIFIER);
				setState(76);
				match(PUNT);
				}
				break;
			case 9:
				_localctx = new SyncStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(77);
				match(KRITIEK);
				setState(78);
				match(IDENTIFIER);
				setState(79);
				statement();
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GELIJKAAN() { return getToken(LANGdradigParser.GELIJKAAN, 0); }
		public TerminalNode ONGELIJKAAN() { return getToken(LANGdradigParser.ONGELIJKAAN, 0); }
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(LANGdradigParser.PLUS, 0); }
		public TerminalNode MIN() { return getToken(LANGdradigParser.MIN, 0); }
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
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode WORDT() { return getToken(LANGdradigParser.WORDT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode HOOG() { return getToken(LANGdradigParser.HOOG, 0); }
		public TerminalNode OP() { return getToken(LANGdradigParser.OP, 0); }
		public TerminalNode VERHOOG() { return getToken(LANGdradigParser.VERHOOG, 0); }
		public TerminalNode VERLAAG() { return getToken(LANGdradigParser.VERLAAG, 0); }
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode TOTDEMACHT() { return getToken(LANGdradigParser.TOTDEMACHT, 0); }
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EN() { return getToken(LANGdradigParser.EN, 0); }
		public TerminalNode OF() { return getToken(LANGdradigParser.OF, 0); }
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode KEER() { return getToken(LANGdradigParser.KEER, 0); }
		public TerminalNode GEDEELDDOOR() { return getToken(LANGdradigParser.GEDEELDDOOR, 0); }
		public TerminalNode MODULUS() { return getToken(LANGdradigParser.MODULUS, 0); }
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LIGT() { return getToken(LANGdradigParser.LIGT, 0); }
		public TerminalNode EN() { return getToken(LANGdradigParser.EN, 0); }
		public TerminalNode TUSSEN() { return getToken(LANGdradigParser.TUSSEN, 0); }
		public TerminalNode BINNEN() { return getToken(LANGdradigParser.BINNEN, 0); }
		public TerminalNode BUITEN() { return getToken(LANGdradigParser.BUITEN, 0); }
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode KLEINERDAN() { return getToken(LANGdradigParser.KLEINERDAN, 0); }
		public TerminalNode GROTERDAN() { return getToken(LANGdradigParser.GROTERDAN, 0); }
		public TerminalNode KLEINEROFGELIJK() { return getToken(LANGdradigParser.KLEINEROFGELIJK, 0); }
		public TerminalNode GROTEROFGELIJK() { return getToken(LANGdradigParser.GROTEROFGELIJK, 0); }
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(83);
				match(MIN);
				setState(84);
				expression(12);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(NIET);
				setState(86);
				expression(11);
				}
				break;
			case 3:
				{
				_localctx = new AssExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(IDENTIFIER);
				setState(88);
				match(WORDT);
				setState(89);
				expression(1);
				}
				break;
			case 4:
				{
				_localctx = new PrimExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				primary();
				}
				break;
			case 5:
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
					} else {
						consume();
					}
					setState(92);
					match(IDENTIFIER);
					}
					}
					break;
				case HOOG:
					{
					{
					setState(93);
					match(HOOG);
					setState(94);
					match(IDENTIFIER);
					setState(95);
					match(OP);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(134);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(132);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(100);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(101);
						match(TOTDEMACHT);
						setState(102);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new FactorExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(103);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(104);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEER) | (1L << GEDEELDDOOR) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(105);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new TermExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(107);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MIN) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(108);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new RangeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(109);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(110);
						match(LIGT);
						setState(111);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TUSSEN) | (1L << BINNEN) | (1L << BUITEN))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(112);
						expression(0);
						setState(113);
						match(EN);
						setState(114);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new CmpExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(117);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KLEINERDAN) | (1L << GROTERDAN) | (1L << KLEINEROFGELIJK) | (1L << GROTEROFGELIJK))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(118);
						expression(5);
						}
						break;
					case 6:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(120);
						_la = _input.LA(1);
						if ( !(_la==GELIJKAAN || _la==ONGELIJKAAN) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(121);
						expression(4);
						}
						break;
					case 7:
						{
						_localctx = new BoolExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(123);
						_la = _input.LA(1);
						if ( !(_la==EN || _la==OF) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(124);
						expression(3);
						}
						break;
					case 8:
						{
						_localctx = new RangeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(125);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(126);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TUSSEN) | (1L << BINNEN) | (1L << BUITEN))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(127);
						expression(0);
						setState(128);
						match(EN);
						setState(129);
						expression(0);
						setState(130);
						match(LIGT);
						}
						break;
					}
					} 
				}
				setState(136);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		public TerminalNode LH() { return getToken(LANGdradigParser.LH, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RH() { return getToken(LANGdradigParser.RH, 0); }
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
		enterRule(_localctx, 6, RULE_primary);
		try {
			setState(145);
			switch (_input.LA(1)) {
			case LH:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				match(LH);
				setState(138);
				expression(0);
				setState(139);
				match(RH);
				}
				break;
			case WAAR:
				_localctx = new TrueExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				match(WAAR);
				}
				break;
			case ONWAAR:
				_localctx = new FalseExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(142);
				match(ONWAAR);
				}
				break;
			case IDENTIFIER:
				_localctx = new IdfExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(IDENTIFIER);
				}
				break;
			case NUMBER:
				_localctx = new NumExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(NUMBER);
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
		public TerminalNode REEKS() { return getToken(LANGdradigParser.REEKS, 0); }
		public TerminalNode VAN() { return getToken(LANGdradigParser.VAN, 0); }
		public TerminalNode NUMBER() { return getToken(LANGdradigParser.NUMBER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		public TerminalNode GETAL() { return getToken(LANGdradigParser.GETAL, 0); }
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
		public TerminalNode STELLING() { return getToken(LANGdradigParser.STELLING, 0); }
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
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		try {
			setState(153);
			switch (_input.LA(1)) {
			case GETAL:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				match(GETAL);
				}
				break;
			case STELLING:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(STELLING);
				}
				break;
			case REEKS:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(149);
				match(REEKS);
				setState(150);
				match(VAN);
				setState(151);
				match(NUMBER);
				setState(152);
				type();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 4);
		case 5:
			return precpred(_ctx, 3);
		case 6:
			return precpred(_ctx, 2);
		case 7:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u009e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\3\3\3"+
		"\3\3\3\3\5\3\27\n\3\3\3\3\3\3\3\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\3\5\3.\n\3\3\3\3\3\3\3\3\3\5\3"+
		"\64\n\3\3\3\3\3\3\3\5\39\n\3\3\3\5\3<\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3S\n\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4c\n\4\5\4e\n\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u0087\n"+
		"\4\f\4\16\4\u008a\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0094\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\5\6\u009c\n\6\3\6\2\3\6\7\2\4\6\b\n\2\t\4\2\37"+
		"\37!!\4\2\5\6\b\b\3\2\3\4\3\2#%\3\2\16\21\3\2\f\r\3\2\n\13\u00bb\2\17"+
		"\3\2\2\2\4R\3\2\2\2\6d\3\2\2\2\b\u0093\3\2\2\2\n\u009b\3\2\2\2\f\16\5"+
		"\4\3\2\r\f\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\3\3\2\2"+
		"\2\21\17\3\2\2\2\22\23\7\67\2\2\23\24\7\62\2\2\24\26\7\63\2\2\25\27\7"+
		"-\2\2\26\25\3\2\2\2\26\27\3\2\2\2\27\30\3\2\2\2\30\31\5\n\6\2\31\32\7"+
		".\2\2\32S\3\2\2\2\33\37\7&\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36!\3\2\2\2"+
		"\37\35\3\2\2\2\37 \3\2\2\2 \"\3\2\2\2!\37\3\2\2\2\"#\7\'\2\2#S\7.\2\2"+
		"$%\5\6\4\2%&\7.\2\2&S\3\2\2\2\'(\7\23\2\2(-\5\6\4\2)+\7\t\2\2*)\3\2\2"+
		"\2*+\3\2\2\2+,\3\2\2\2,.\7\36\2\2-*\3\2\2\2-.\3\2\2\2./\3\2\2\2/\60\7"+
		"\24\2\2\60\63\5\4\3\2\61\62\7\25\2\2\62\64\5\4\3\2\63\61\3\2\2\2\63\64"+
		"\3\2\2\2\64S\3\2\2\2\65\66\7\27\2\2\66;\5\6\4\2\679\7\t\2\28\67\3\2\2"+
		"\289\3\2\2\29:\3\2\2\2:<\7\36\2\2;8\3\2\2\2;<\3\2\2\2<=\3\2\2\2=>\5\4"+
		"\3\2>S\3\2\2\2?@\7)\2\2@A\7*\2\2AB\7+\2\2BC\7\67\2\2CS\5\4\3\2DE\7)\2"+
		"\2EF\5\4\3\2FG\7*\2\2GH\7+\2\2HI\7\67\2\2IJ\7.\2\2JS\3\2\2\2KL\7,\2\2"+
		"LM\7\64\2\2MN\7\67\2\2NS\7.\2\2OP\7(\2\2PQ\7\67\2\2QS\5\4\3\2R\22\3\2"+
		"\2\2R\33\3\2\2\2R$\3\2\2\2R\'\3\2\2\2R\65\3\2\2\2R?\3\2\2\2RD\3\2\2\2"+
		"RK\3\2\2\2RO\3\2\2\2S\5\3\2\2\2TU\b\4\1\2UV\7\4\2\2Ve\5\6\4\16WX\7\t\2"+
		"\2Xe\5\6\4\rYZ\7\67\2\2Z[\7\22\2\2[e\5\6\4\3\\e\5\b\5\2]^\t\2\2\2^c\7"+
		"\67\2\2_`\7 \2\2`a\7\67\2\2ac\7\64\2\2b]\3\2\2\2b_\3\2\2\2ce\3\2\2\2d"+
		"T\3\2\2\2dW\3\2\2\2dY\3\2\2\2d\\\3\2\2\2db\3\2\2\2e\u0088\3\2\2\2fg\f"+
		"\13\2\2gh\7\7\2\2h\u0087\5\6\4\13ij\f\n\2\2jk\t\3\2\2k\u0087\5\6\4\13"+
		"lm\f\t\2\2mn\t\4\2\2n\u0087\5\6\4\nop\f\b\2\2pq\7\"\2\2qr\t\5\2\2rs\5"+
		"\6\4\2st\7\n\2\2tu\5\6\4\tu\u0087\3\2\2\2vw\f\6\2\2wx\t\6\2\2x\u0087\5"+
		"\6\4\7yz\f\5\2\2z{\t\7\2\2{\u0087\5\6\4\6|}\f\4\2\2}~\t\b\2\2~\u0087\5"+
		"\6\4\5\177\u0080\f\7\2\2\u0080\u0081\t\5\2\2\u0081\u0082\5\6\4\2\u0082"+
		"\u0083\7\n\2\2\u0083\u0084\5\6\4\2\u0084\u0085\7\"\2\2\u0085\u0087\3\2"+
		"\2\2\u0086f\3\2\2\2\u0086i\3\2\2\2\u0086l\3\2\2\2\u0086o\3\2\2\2\u0086"+
		"v\3\2\2\2\u0086y\3\2\2\2\u0086|\3\2\2\2\u0086\177\3\2\2\2\u0087\u008a"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\7\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008b\u008c\7\60\2\2\u008c\u008d\5\6\4\2\u008d\u008e\7"+
		"\61\2\2\u008e\u0094\3\2\2\2\u008f\u0094\7\34\2\2\u0090\u0094\7\35\2\2"+
		"\u0091\u0094\7\67\2\2\u0092\u0094\7\66\2\2\u0093\u008b\3\2\2\2\u0093\u008f"+
		"\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2\2\2\u0094"+
		"\t\3\2\2\2\u0095\u009c\7\30\2\2\u0096\u009c\7\31\2\2\u0097\u0098\7\32"+
		"\2\2\u0098\u0099\7\65\2\2\u0099\u009a\7\66\2\2\u009a\u009c\5\n\6\2\u009b"+
		"\u0095\3\2\2\2\u009b\u0096\3\2\2\2\u009b\u0097\3\2\2\2\u009c\13\3\2\2"+
		"\2\21\17\26\37*-\638;Rbd\u0086\u0088\u0093\u009b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}