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
		VOOR=20, ZOLANG=21, GETAL=22, STELLING=23, REEKS=24, TEKST=25, WAAR=26, 
		ONWAAR=27, PLEK=28, LENGTE=29, ZET=30, PLAATS=31, KLOPT=32, VERHOOG=33, 
		HOOG=34, VERLAAG=35, LIGT=36, TUSSEN=37, BINNEN=38, BUITEN=39, DOE=40, 
		KLAAR=41, KRITIEK=42, BESTEED=43, UIT=44, AAN=45, WACHT=46, GEDEELDE=47, 
		LAAT=48, ZIEN=49, PUNT=50, KOMMA=51, LH=52, RH=53, LSQ=54, RSQ=55, IS=56, 
		IN=57, EEN=58, OP=59, VAN=60, DE=61, NUMBER=62, IDENTIFIER=63, TELWOORD=64, 
		COMMENTAAR=65, WITRUIMTE=66, ERRORCHARACTER=67;
	public static final String[] tokenNames = {
		"<INVALID>", "PLUS", "MIN", "KEER", "GEDEELDDOOR", "TOTDEMACHT", "MODULUS", 
		"NIET", "EN", "OF", "GELIJKAAN", "ONGELIJKAAN", "KLEINERDAN", "GROTERDAN", 
		"KLEINEROFGELIJK", "GROTEROFGELIJK", "WORDT", "ALS", "DAN", "ANDERS", 
		"VOOR", "ZOLANG", "GETAL", "STELLING", "REEKS", "TEKST", "WAAR", "ONWAAR", 
		"PLEK", "LENGTE", "ZET", "PLAATS", "KLOPT", "VERHOOG", "HOOG", "VERLAAG", 
		"LIGT", "TUSSEN", "BINNEN", "BUITEN", "DOE", "KLAAR", "KRITIEK", "BESTEED", 
		"UIT", "AAN", "WACHT", "GEDEELDE", "LAAT", "ZIEN", "'.'", "','", "'('", 
		"')'", "'['", "']'", "IS", "IN", "EEN", "OP", "VAN", "DE", "NUMBER", "IDENTIFIER", 
		"TELWOORD", "COMMENTAAR", "WITRUIMTE", "ERRORCHARACTER"
	};
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_expression = 2, RULE_primary = 3, 
		RULE_type = 4;
	public static final String[] ruleNames = {
		"program", "statement", "expression", "primary", "type"
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
			setState(13);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << ZET) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LAAT) | (1L << LH) | (1L << LSQ) | (1L << DE) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(10); statement();
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
		public TerminalNode KLOPT() { return getToken(LANGdradigParser.KLOPT, 0); }
		public TerminalNode DAN() { return getToken(LANGdradigParser.DAN, 0); }
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
	public static class SharedDeclStatContext extends StatementContext {
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public TerminalNode IS() { return getToken(LANGdradigParser.IS, 0); }
		public TerminalNode GEDEELDE() { return getToken(LANGdradigParser.GEDEELDE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode EEN() { return getToken(LANGdradigParser.EEN, 0); }
		public SharedDeclStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterSharedDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitSharedDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitSharedDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintStatContext extends StatementContext {
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public TerminalNode ZIEN() { return getToken(LANGdradigParser.ZIEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LAAT() { return getToken(LANGdradigParser.LAAT, 0); }
		public PrintStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitPrintStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitPrintStat(this);
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
	public static class BlockForkStatContext extends StatementContext {
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public TerminalNode UIT() { return getToken(LANGdradigParser.UIT, 0); }
		public TerminalNode AAN() { return getToken(LANGdradigParser.AAN, 0); }
		public TerminalNode BESTEED() { return getToken(LANGdradigParser.BESTEED, 0); }
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public BlockForkStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterBlockForkStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitBlockForkStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitBlockForkStat(this);
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
			setState(95);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new DeclStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(16); match(IDENTIFIER);
				setState(17); match(IS);
				setState(18); match(EEN);
				setState(19); type();
				setState(20); match(PUNT);
				}
				break;
			case 2:
				_localctx = new SharedDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22); match(IDENTIFIER);
				setState(23); match(IS);
				setState(24); match(EEN);
				setState(25); match(GEDEELDE);
				setState(26); type();
				setState(27); match(PUNT);
				}
				break;
			case 3:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(29); match(DOE);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << ZET) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LAAT) | (1L << LH) | (1L << LSQ) | (1L << DE) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(30); statement();
					}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(36); match(KLAAR);
				setState(37); match(PUNT);
				}
				break;
			case 4:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(38); expression(0);
				setState(39); match(PUNT);
				}
				break;
			case 5:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(41); match(ALS);
				setState(42); expression(0);
				setState(47);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(44);
					_la = _input.LA(1);
					if (_la==NIET) {
						{
						setState(43); match(NIET);
						}
					}

					setState(46); match(KLOPT);
					}
					break;
				}
				setState(50);
				_la = _input.LA(1);
				if (_la==DAN) {
					{
					setState(49); match(DAN);
					}
				}

				setState(52); statement();
				setState(55);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(53); match(ANDERS);
					setState(54); statement();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(57); match(ZOLANG);
				setState(58); expression(0);
				setState(63);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(60);
					_la = _input.LA(1);
					if (_la==NIET) {
						{
						setState(59); match(NIET);
						}
					}

					setState(62); match(KLOPT);
					}
					break;
				}
				setState(65); statement();
				}
				break;
			case 7:
				_localctx = new ForkStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(67); match(BESTEED);
				setState(68); match(UIT);
				setState(69); match(AAN);
				setState(70); match(IDENTIFIER);
				setState(71); statement();
				}
				break;
			case 8:
				_localctx = new BlockForkStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(72); match(BESTEED);
				setState(74); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(73); statement();
					}
					}
					setState(76); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << ZET) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LAAT) | (1L << LH) | (1L << LSQ) | (1L << DE) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0) );
				setState(78); match(UIT);
				setState(79); match(AAN);
				setState(80); match(IDENTIFIER);
				setState(81); match(PUNT);
				}
				break;
			case 9:
				_localctx = new JoinStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(83); match(WACHT);
				setState(84); match(OP);
				setState(85); match(IDENTIFIER);
				setState(86); match(PUNT);
				}
				break;
			case 10:
				_localctx = new SyncStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(87); match(KRITIEK);
				setState(88); match(IDENTIFIER);
				setState(89); statement();
				}
				break;
			case 11:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(90); match(LAAT);
				setState(91); expression(0);
				setState(92); match(ZIEN);
				setState(93); match(PUNT);
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
	public static class IndexAssExprContext extends ExpressionContext {
		public TerminalNode ZET() { return getToken(LANGdradigParser.ZET, 0); }
		public TerminalNode OP() { return getToken(LANGdradigParser.OP, 0); }
		public TerminalNode VAN() { return getToken(LANGdradigParser.VAN, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLEK() { return getToken(LANGdradigParser.PLEK, 0); }
		public TerminalNode PLAATS() { return getToken(LANGdradigParser.PLAATS, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode IN() { return getToken(LANGdradigParser.IN, 0); }
		public IndexAssExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterIndexAssExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitIndexAssExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitIndexAssExpr(this);
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
	public static class IndexExprContext extends ExpressionContext {
		public TerminalNode OP() { return getToken(LANGdradigParser.OP, 0); }
		public TerminalNode PLEK() { return getToken(LANGdradigParser.PLEK, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IndexExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterIndexExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitIndexExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitIndexExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LengthExprContext extends ExpressionContext {
		public TerminalNode DE() { return getToken(LANGdradigParser.DE, 0); }
		public TerminalNode VAN() { return getToken(LANGdradigParser.VAN, 0); }
		public TerminalNode LENGTE() { return getToken(LANGdradigParser.LENGTE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public LengthExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterLengthExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitLengthExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitLengthExpr(this);
			else return visitor.visitChildren(this);
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
	public static class AssExprContext extends ExpressionContext {
		public TerminalNode WORDT() { return getToken(LANGdradigParser.WORDT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
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
			setState(137);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new IndexExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98); match(IDENTIFIER);
				setState(99); match(OP);
				setState(100); match(PLEK);
				setState(101); expression(14);
				}
				break;
			case 2:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(102); match(MIN);
				setState(103); expression(12);
				}
				break;
			case 3:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(104); match(NIET);
				setState(105); expression(11);
				}
				break;
			case 4:
				{
				_localctx = new AssExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106); match(IDENTIFIER);
				setState(107); match(WORDT);
				setState(108); expression(1);
				}
				break;
			case 5:
				{
				_localctx = new PrimExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109); primary();
				}
				break;
			case 6:
				{
				_localctx = new IndexAssExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110); match(ZET);
				setState(111); expression(0);
				setState(112); match(OP);
				setState(113);
				_la = _input.LA(1);
				if ( !(_la==PLEK || _la==PLAATS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(114); expression(0);
				setState(115);
				_la = _input.LA(1);
				if ( !(_la==IN || _la==VAN) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(116); match(IDENTIFIER);
				}
				break;
			case 7:
				{
				_localctx = new IndexAssExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118); match(ZET);
				setState(119); expression(0);
				setState(120); match(IN);
				setState(121); match(IDENTIFIER);
				setState(122); match(OP);
				setState(123);
				_la = _input.LA(1);
				if ( !(_la==PLEK || _la==PLAATS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(124); expression(0);
				}
				break;
			case 8:
				{
				_localctx = new LengthExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126); match(DE);
				setState(127); match(LENGTE);
				setState(128); match(VAN);
				setState(129); match(IDENTIFIER);
				}
				break;
			case 9:
				{
				_localctx = new CrementExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(135);
				switch (_input.LA(1)) {
				case VERHOOG:
				case VERLAAG:
					{
					{
					setState(130);
					_la = _input.LA(1);
					if ( !(_la==VERHOOG || _la==VERLAAG) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(131); match(IDENTIFIER);
					}
					}
					break;
				case HOOG:
					{
					{
					setState(132); match(HOOG);
					setState(133); match(IDENTIFIER);
					setState(134); match(OP);
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
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(171);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(139);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(140); match(TOTDEMACHT);
						setState(141); expression(9);
						}
						break;
					case 2:
						{
						_localctx = new FactorExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(142);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(143);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEER) | (1L << GEDEELDDOOR) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(144); expression(9);
						}
						break;
					case 3:
						{
						_localctx = new TermExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(146);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MIN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(147); expression(8);
						}
						break;
					case 4:
						{
						_localctx = new RangeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(148);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(149); match(LIGT);
						setState(150);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TUSSEN) | (1L << BINNEN) | (1L << BUITEN))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(151); expression(0);
						setState(152); match(EN);
						setState(153); expression(7);
						}
						break;
					case 5:
						{
						_localctx = new CmpExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(156);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KLEINERDAN) | (1L << GROTERDAN) | (1L << KLEINEROFGELIJK) | (1L << GROTEROFGELIJK))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(157); expression(5);
						}
						break;
					case 6:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(159);
						_la = _input.LA(1);
						if ( !(_la==GELIJKAAN || _la==ONGELIJKAAN) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(160); expression(4);
						}
						break;
					case 7:
						{
						_localctx = new BoolExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(162);
						_la = _input.LA(1);
						if ( !(_la==EN || _la==OF) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(163); expression(3);
						}
						break;
					case 8:
						{
						_localctx = new RangeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(165);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TUSSEN) | (1L << BINNEN) | (1L << BUITEN))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(166); expression(0);
						setState(167); match(EN);
						setState(168); expression(0);
						setState(169); match(LIGT);
						}
						break;
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
	public static class ArrayExprContext extends PrimaryContext {
		public TerminalNode KOMMA(int i) {
			return getToken(LANGdradigParser.KOMMA, i);
		}
		public TerminalNode RSQ() { return getToken(LANGdradigParser.RSQ, 0); }
		public List<TerminalNode> KOMMA() { return getTokens(LANGdradigParser.KOMMA); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode LSQ() { return getToken(LANGdradigParser.LSQ, 0); }
		public ArrayExprContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LANGdradigListener ) ((LANGdradigListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof LANGdradigVisitor ) return ((LANGdradigVisitor<? extends T>)visitor).visitArrayExpr(this);
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
		int _la;
		try {
			setState(196);
			switch (_input.LA(1)) {
			case LH:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176); match(LH);
				setState(177); expression(0);
				setState(178); match(RH);
				}
				break;
			case WAAR:
				_localctx = new TrueExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(180); match(WAAR);
				}
				break;
			case ONWAAR:
				_localctx = new FalseExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(181); match(ONWAAR);
				}
				break;
			case IDENTIFIER:
				_localctx = new IdfExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(182); match(IDENTIFIER);
				}
				break;
			case NUMBER:
				_localctx = new NumExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(183); match(NUMBER);
				}
				break;
			case LSQ:
				_localctx = new ArrayExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(184); match(LSQ);
				setState(193);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << WAAR) | (1L << ONWAAR) | (1L << ZET) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << LH) | (1L << LSQ) | (1L << DE) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					setState(185); expression(0);
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==KOMMA) {
						{
						{
						setState(186); match(KOMMA);
						setState(187); expression(0);
						}
						}
						setState(192);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(195); match(RSQ);
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
		public TerminalNode VAN() { return getToken(LANGdradigParser.VAN, 0); }
		public TerminalNode REEKS() { return getToken(LANGdradigParser.REEKS, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(LANGdradigParser.NUMBER, 0); }
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
			setState(204);
			switch (_input.LA(1)) {
			case GETAL:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(198); match(GETAL);
				}
				break;
			case STELLING:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199); match(STELLING);
				}
				break;
			case REEKS:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(200); match(REEKS);
				setState(201); match(VAN);
				setState(202); match(NUMBER);
				setState(203); type();
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
		case 2: return expression_sempred((ExpressionContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3E\u00d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16"+
		"\3%\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\3\5\3\62\n\3\3\3\5"+
		"\3\65\n\3\3\3\3\3\3\3\5\3:\n\3\3\3\3\3\3\3\5\3?\n\3\3\3\5\3B\n\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3M\n\3\r\3\16\3N\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3b\n\3\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\5\4\u008a\n\4\5\4\u008c\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\7\4\u00ae\n\4\f\4\16\4\u00b1\13\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00bf\n\5\f\5\16\5\u00c2\13\5\5\5\u00c4"+
		"\n\5\3\5\5\5\u00c7\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00cf\n\6\3\6\2\3\6"+
		"\7\2\4\6\b\n\2\13\4\2\36\36!!\4\2;;>>\4\2##%%\4\2\5\6\b\b\3\2\3\4\3\2"+
		"\')\3\2\16\21\3\2\f\r\3\2\n\13\u00f8\2\17\3\2\2\2\4a\3\2\2\2\6\u008b\3"+
		"\2\2\2\b\u00c6\3\2\2\2\n\u00ce\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\21"+
		"\3\2\2\2\17\r\3\2\2\2\17\20\3\2\2\2\20\3\3\2\2\2\21\17\3\2\2\2\22\23\7"+
		"A\2\2\23\24\7:\2\2\24\25\7<\2\2\25\26\5\n\6\2\26\27\7\64\2\2\27b\3\2\2"+
		"\2\30\31\7A\2\2\31\32\7:\2\2\32\33\7<\2\2\33\34\7\61\2\2\34\35\5\n\6\2"+
		"\35\36\7\64\2\2\36b\3\2\2\2\37#\7*\2\2 \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2"+
		"#!\3\2\2\2#$\3\2\2\2$&\3\2\2\2%#\3\2\2\2&\'\7+\2\2\'b\7\64\2\2()\5\6\4"+
		"\2)*\7\64\2\2*b\3\2\2\2+,\7\23\2\2,\61\5\6\4\2-/\7\t\2\2.-\3\2\2\2./\3"+
		"\2\2\2/\60\3\2\2\2\60\62\7\"\2\2\61.\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2"+
		"\2\63\65\7\24\2\2\64\63\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\669\5\4\3"+
		"\2\678\7\25\2\28:\5\4\3\29\67\3\2\2\29:\3\2\2\2:b\3\2\2\2;<\7\27\2\2<"+
		"A\5\6\4\2=?\7\t\2\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@B\7\"\2\2A>\3\2\2\2"+
		"AB\3\2\2\2BC\3\2\2\2CD\5\4\3\2Db\3\2\2\2EF\7-\2\2FG\7.\2\2GH\7/\2\2HI"+
		"\7A\2\2Ib\5\4\3\2JL\7-\2\2KM\5\4\3\2LK\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3"+
		"\2\2\2OP\3\2\2\2PQ\7.\2\2QR\7/\2\2RS\7A\2\2ST\7\64\2\2Tb\3\2\2\2UV\7\60"+
		"\2\2VW\7=\2\2WX\7A\2\2Xb\7\64\2\2YZ\7,\2\2Z[\7A\2\2[b\5\4\3\2\\]\7\62"+
		"\2\2]^\5\6\4\2^_\7\63\2\2_`\7\64\2\2`b\3\2\2\2a\22\3\2\2\2a\30\3\2\2\2"+
		"a\37\3\2\2\2a(\3\2\2\2a+\3\2\2\2a;\3\2\2\2aE\3\2\2\2aJ\3\2\2\2aU\3\2\2"+
		"\2aY\3\2\2\2a\\\3\2\2\2b\5\3\2\2\2cd\b\4\1\2de\7A\2\2ef\7=\2\2fg\7\36"+
		"\2\2g\u008c\5\6\4\20hi\7\4\2\2i\u008c\5\6\4\16jk\7\t\2\2k\u008c\5\6\4"+
		"\rlm\7A\2\2mn\7\22\2\2n\u008c\5\6\4\3o\u008c\5\b\5\2pq\7 \2\2qr\5\6\4"+
		"\2rs\7=\2\2st\t\2\2\2tu\5\6\4\2uv\t\3\2\2vw\7A\2\2w\u008c\3\2\2\2xy\7"+
		" \2\2yz\5\6\4\2z{\7;\2\2{|\7A\2\2|}\7=\2\2}~\t\2\2\2~\177\5\6\4\2\177"+
		"\u008c\3\2\2\2\u0080\u0081\7?\2\2\u0081\u0082\7\37\2\2\u0082\u0083\7>"+
		"\2\2\u0083\u008c\7A\2\2\u0084\u0085\t\4\2\2\u0085\u008a\7A\2\2\u0086\u0087"+
		"\7$\2\2\u0087\u0088\7A\2\2\u0088\u008a\7=\2\2\u0089\u0084\3\2\2\2\u0089"+
		"\u0086\3\2\2\2\u008a\u008c\3\2\2\2\u008bc\3\2\2\2\u008bh\3\2\2\2\u008b"+
		"j\3\2\2\2\u008bl\3\2\2\2\u008bo\3\2\2\2\u008bp\3\2\2\2\u008bx\3\2\2\2"+
		"\u008b\u0080\3\2\2\2\u008b\u0089\3\2\2\2\u008c\u00af\3\2\2\2\u008d\u008e"+
		"\f\13\2\2\u008e\u008f\7\7\2\2\u008f\u00ae\5\6\4\13\u0090\u0091\f\n\2\2"+
		"\u0091\u0092\t\5\2\2\u0092\u00ae\5\6\4\13\u0093\u0094\f\t\2\2\u0094\u0095"+
		"\t\6\2\2\u0095\u00ae\5\6\4\n\u0096\u0097\f\b\2\2\u0097\u0098\7&\2\2\u0098"+
		"\u0099\t\7\2\2\u0099\u009a\5\6\4\2\u009a\u009b\7\n\2\2\u009b\u009c\5\6"+
		"\4\t\u009c\u00ae\3\2\2\2\u009d\u009e\f\6\2\2\u009e\u009f\t\b\2\2\u009f"+
		"\u00ae\5\6\4\7\u00a0\u00a1\f\5\2\2\u00a1\u00a2\t\t\2\2\u00a2\u00ae\5\6"+
		"\4\6\u00a3\u00a4\f\4\2\2\u00a4\u00a5\t\n\2\2\u00a5\u00ae\5\6\4\5\u00a6"+
		"\u00a7\f\7\2\2\u00a7\u00a8\t\7\2\2\u00a8\u00a9\5\6\4\2\u00a9\u00aa\7\n"+
		"\2\2\u00aa\u00ab\5\6\4\2\u00ab\u00ac\7&\2\2\u00ac\u00ae\3\2\2\2\u00ad"+
		"\u008d\3\2\2\2\u00ad\u0090\3\2\2\2\u00ad\u0093\3\2\2\2\u00ad\u0096\3\2"+
		"\2\2\u00ad\u009d\3\2\2\2\u00ad\u00a0\3\2\2\2\u00ad\u00a3\3\2\2\2\u00ad"+
		"\u00a6\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\7\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b3\7\66\2\2\u00b3\u00b4"+
		"\5\6\4\2\u00b4\u00b5\7\67\2\2\u00b5\u00c7\3\2\2\2\u00b6\u00c7\7\34\2\2"+
		"\u00b7\u00c7\7\35\2\2\u00b8\u00c7\7A\2\2\u00b9\u00c7\7@\2\2\u00ba\u00c3"+
		"\78\2\2\u00bb\u00c0\5\6\4\2\u00bc\u00bd\7\65\2\2\u00bd\u00bf\5\6\4\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00bb\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\79\2\2\u00c6\u00b2\3\2"+
		"\2\2\u00c6\u00b6\3\2\2\2\u00c6\u00b7\3\2\2\2\u00c6\u00b8\3\2\2\2\u00c6"+
		"\u00b9\3\2\2\2\u00c6\u00ba\3\2\2\2\u00c7\t\3\2\2\2\u00c8\u00cf\7\30\2"+
		"\2\u00c9\u00cf\7\31\2\2\u00ca\u00cb\7\32\2\2\u00cb\u00cc\7>\2\2\u00cc"+
		"\u00cd\7@\2\2\u00cd\u00cf\5\n\6\2\u00ce\u00c8\3\2\2\2\u00ce\u00c9\3\2"+
		"\2\2\u00ce\u00ca\3\2\2\2\u00cf\13\3\2\2\2\24\17#.\61\649>ANa\u0089\u008b"+
		"\u00ad\u00af\u00c0\u00c3\u00c6\u00ce";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}