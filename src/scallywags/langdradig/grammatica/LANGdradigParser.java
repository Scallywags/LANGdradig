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
		AAN=41, WACHT=42, GEDEELDE=43, LAAT=44, ZIEN=45, PUNT=46, KOMMA=47, LH=48, 
		RH=49, LSQ=50, RSQ=51, IS=52, EEN=53, OP=54, VAN=55, DE=56, PLEK=57, NUMBER=58, 
		IDENTIFIER=59, TELWOORD=60, COMMENTAAR=61, WITRUIMTE=62, ERRORCHARACTER=63;
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
		null, null, null, null, null, null, null, null, null, null, "'.'", "','", 
		"'('", "')'", "'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PLUS", "MIN", "KEER", "GEDEELDDOOR", "TOTDEMACHT", "MODULUS", "NIET", 
		"EN", "OF", "GELIJKAAN", "ONGELIJKAAN", "KLEINERDAN", "GROTERDAN", "KLEINEROFGELIJK", 
		"GROTEROFGELIJK", "WORDT", "ALS", "DAN", "ANDERS", "VOOR", "ZOLANG", "GETAL", 
		"STELLING", "REEKS", "TEKST", "WAAR", "ONWAAR", "KLOPT", "VERHOOG", "HOOG", 
		"VERLAAG", "LIGT", "TUSSEN", "BINNEN", "BUITEN", "DOE", "KLAAR", "KRITIEK", 
		"BESTEED", "UIT", "AAN", "WACHT", "GEDEELDE", "LAAT", "ZIEN", "PUNT", 
		"KOMMA", "LH", "RH", "LSQ", "RSQ", "IS", "EEN", "OP", "VAN", "DE", "PLEK", 
		"NUMBER", "IDENTIFIER", "TELWOORD", "COMMENTAAR", "WITRUIMTE", "ERRORCHARACTER"
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LAAT) | (1L << LH) | (1L << LSQ) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
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
	public static class SharedDeclStatContext extends StatementContext {
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode IS() { return getToken(LANGdradigParser.IS, 0); }
		public TerminalNode EEN() { return getToken(LANGdradigParser.EEN, 0); }
		public TerminalNode GEDEELDE() { return getToken(LANGdradigParser.GEDEELDE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
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
		public TerminalNode LAAT() { return getToken(LANGdradigParser.LAAT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ZIEN() { return getToken(LANGdradigParser.ZIEN, 0); }
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
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
	public static class BlockForkStatContext extends StatementContext {
		public TerminalNode BESTEED() { return getToken(LANGdradigParser.BESTEED, 0); }
		public TerminalNode UIT() { return getToken(LANGdradigParser.UIT, 0); }
		public TerminalNode AAN() { return getToken(LANGdradigParser.AAN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(LANGdradigParser.IDENTIFIER, 0); }
		public TerminalNode PUNT() { return getToken(LANGdradigParser.PUNT, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
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
			setState(93);
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
				setState(19);
				type();
				setState(20);
				match(PUNT);
				}
				break;
			case 2:
				_localctx = new SharedDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(22);
				match(IDENTIFIER);
				setState(23);
				match(IS);
				setState(24);
				match(EEN);
				setState(25);
				match(GEDEELDE);
				setState(26);
				type();
				setState(27);
				match(PUNT);
				}
				break;
			case 3:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				match(DOE);
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LAAT) | (1L << LH) | (1L << LSQ) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0)) {
					{
					{
					setState(30);
					statement();
					}
					}
					setState(35);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(36);
				match(KLAAR);
				setState(37);
				match(PUNT);
				}
				break;
			case 4:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
				expression(0);
				setState(39);
				match(PUNT);
				}
				break;
			case 5:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(41);
				match(ALS);
				setState(42);
				expression(0);
				setState(47);
				_la = _input.LA(1);
				if (_la==NIET || _la==KLOPT) {
					{
					setState(44);
					_la = _input.LA(1);
					if (_la==NIET) {
						{
						setState(43);
						match(NIET);
						}
					}

					setState(46);
					match(KLOPT);
					}
				}

				setState(49);
				match(DAN);
				setState(50);
				statement();
				setState(53);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(51);
					match(ANDERS);
					setState(52);
					statement();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(55);
				match(ZOLANG);
				setState(56);
				expression(0);
				setState(61);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(58);
					_la = _input.LA(1);
					if (_la==NIET) {
						{
						setState(57);
						match(NIET);
						}
					}

					setState(60);
					match(KLOPT);
					}
					break;
				}
				setState(63);
				statement();
				}
				break;
			case 7:
				_localctx = new ForkStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				match(BESTEED);
				setState(66);
				match(UIT);
				setState(67);
				match(AAN);
				setState(68);
				match(IDENTIFIER);
				setState(69);
				statement();
				}
				break;
			case 8:
				_localctx = new BlockForkStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(70);
				match(BESTEED);
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(71);
					statement();
					}
					}
					setState(74); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MIN) | (1L << NIET) | (1L << ALS) | (1L << ZOLANG) | (1L << WAAR) | (1L << ONWAAR) | (1L << VERHOOG) | (1L << HOOG) | (1L << VERLAAG) | (1L << DOE) | (1L << KRITIEK) | (1L << BESTEED) | (1L << WACHT) | (1L << LAAT) | (1L << LH) | (1L << LSQ) | (1L << NUMBER) | (1L << IDENTIFIER))) != 0) );
				setState(76);
				match(UIT);
				setState(77);
				match(AAN);
				setState(78);
				match(IDENTIFIER);
				setState(79);
				match(PUNT);
				}
				break;
			case 9:
				_localctx = new JoinStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(81);
				match(WACHT);
				setState(82);
				match(OP);
				setState(83);
				match(IDENTIFIER);
				setState(84);
				match(PUNT);
				}
				break;
			case 10:
				_localctx = new SyncStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(85);
				match(KRITIEK);
				setState(86);
				match(IDENTIFIER);
				setState(87);
				statement();
				}
				break;
			case 11:
				_localctx = new PrintStatContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(88);
				match(LAAT);
				setState(89);
				expression(0);
				setState(90);
				match(ZIEN);
				setState(91);
				match(PUNT);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OP() { return getToken(LANGdradigParser.OP, 0); }
		public TerminalNode DE() { return getToken(LANGdradigParser.DE, 0); }
		public TerminalNode TELWOORD() { return getToken(LANGdradigParser.TELWOORD, 0); }
		public TerminalNode PLEK() { return getToken(LANGdradigParser.PLEK, 0); }
		public TerminalNode WORDT() { return getToken(LANGdradigParser.WORDT, 0); }
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
	public static class IndexExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OP() { return getToken(LANGdradigParser.OP, 0); }
		public TerminalNode DE() { return getToken(LANGdradigParser.DE, 0); }
		public TerminalNode TELWOORD() { return getToken(LANGdradigParser.TELWOORD, 0); }
		public TerminalNode PLEK() { return getToken(LANGdradigParser.PLEK, 0); }
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
			setState(111);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new NegExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(96);
				match(MIN);
				setState(97);
				expression(14);
				}
				break;
			case 2:
				{
				_localctx = new NotExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(NIET);
				setState(99);
				expression(13);
				}
				break;
			case 3:
				{
				_localctx = new AssExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(100);
				match(IDENTIFIER);
				setState(101);
				match(WORDT);
				setState(102);
				expression(2);
				}
				break;
			case 4:
				{
				_localctx = new PrimExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				primary();
				}
				break;
			case 5:
				{
				_localctx = new CrementExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				switch (_input.LA(1)) {
				case VERHOOG:
				case VERLAAG:
					{
					{
					setState(104);
					_la = _input.LA(1);
					if ( !(_la==VERHOOG || _la==VERLAAG) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(105);
					match(IDENTIFIER);
					}
					}
					break;
				case HOOG:
					{
					{
					setState(106);
					match(HOOG);
					setState(107);
					match(IDENTIFIER);
					setState(108);
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
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(157);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new PowExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(114);
						match(TOTDEMACHT);
						setState(115);
						expression(11);
						}
						break;
					case 2:
						{
						_localctx = new FactorExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(117);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEER) | (1L << GEDEELDDOOR) | (1L << MODULUS))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(118);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new TermExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(120);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MIN) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(121);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new RangeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(123);
						match(LIGT);
						setState(124);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TUSSEN) | (1L << BINNEN) | (1L << BUITEN))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(125);
						expression(0);
						setState(126);
						match(EN);
						setState(127);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new CmpExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(129);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(130);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KLEINERDAN) | (1L << GROTERDAN) | (1L << KLEINEROFGELIJK) | (1L << GROTEROFGELIJK))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(131);
						expression(7);
						}
						break;
					case 6:
						{
						_localctx = new EqExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(133);
						_la = _input.LA(1);
						if ( !(_la==GELIJKAAN || _la==ONGELIJKAAN) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(134);
						expression(6);
						}
						break;
					case 7:
						{
						_localctx = new BoolExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(136);
						_la = _input.LA(1);
						if ( !(_la==EN || _la==OF) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(137);
						expression(5);
						}
						break;
					case 8:
						{
						_localctx = new IndexAssExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(139);
						match(OP);
						setState(140);
						match(DE);
						setState(141);
						match(TELWOORD);
						setState(142);
						match(PLEK);
						setState(143);
						match(WORDT);
						setState(144);
						expression(1);
						}
						break;
					case 9:
						{
						_localctx = new RangeExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(145);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(146);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TUSSEN) | (1L << BINNEN) | (1L << BUITEN))) != 0)) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(147);
						expression(0);
						setState(148);
						match(EN);
						setState(149);
						expression(0);
						setState(150);
						match(LIGT);
						}
						break;
					case 10:
						{
						_localctx = new IndexExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(153);
						match(OP);
						setState(154);
						match(DE);
						setState(155);
						match(TELWOORD);
						setState(156);
						match(PLEK);
						}
						break;
					}
					} 
				}
				setState(161);
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
	public static class ArrayExprContext extends PrimaryContext {
		public TerminalNode LSQ() { return getToken(LANGdradigParser.LSQ, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RSQ() { return getToken(LANGdradigParser.RSQ, 0); }
		public List<TerminalNode> KOMMA() { return getTokens(LANGdradigParser.KOMMA); }
		public TerminalNode KOMMA(int i) {
			return getToken(LANGdradigParser.KOMMA, i);
		}
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
			setState(181);
			switch (_input.LA(1)) {
			case LH:
				_localctx = new ParExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(162);
				match(LH);
				setState(163);
				expression(0);
				setState(164);
				match(RH);
				}
				break;
			case WAAR:
				_localctx = new TrueExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(WAAR);
				}
				break;
			case ONWAAR:
				_localctx = new FalseExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				match(ONWAAR);
				}
				break;
			case IDENTIFIER:
				_localctx = new IdfExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				match(IDENTIFIER);
				}
				break;
			case NUMBER:
				_localctx = new NumExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(169);
				match(NUMBER);
				}
				break;
			case LSQ:
				_localctx = new ArrayExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(170);
				match(LSQ);
				setState(171);
				expression(0);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==KOMMA) {
					{
					{
					setState(172);
					match(KOMMA);
					setState(173);
					expression(0);
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				match(RSQ);
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
			setState(189);
			switch (_input.LA(1)) {
			case GETAL:
				_localctx = new IntTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				match(GETAL);
				}
				break;
			case STELLING:
				_localctx = new BoolTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(STELLING);
				}
				break;
			case REEKS:
				_localctx = new ArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				match(REEKS);
				setState(186);
				match(VAN);
				setState(187);
				match(NUMBER);
				setState(188);
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
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		case 7:
			return precpred(_ctx, 1);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3A\u00c2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\7\2\16\n\2\f\2\16\2\21\13\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\"\n\3\f\3\16"+
		"\3%\13\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3/\n\3\3\3\5\3\62\n\3\3\3\3"+
		"\3\3\3\3\3\5\38\n\3\3\3\3\3\3\3\5\3=\n\3\3\3\5\3@\n\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\6\3K\n\3\r\3\16\3L\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3`\n\3\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4p\n\4\5\4r\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\7\4\u00a0\n\4\f\4\16\4\u00a3\13\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00b1\n\5\f\5\16\5\u00b4\13\5\3\5\3"+
		"\5\5\5\u00b8\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c0\n\6\3\6\2\3\6\7\2\4"+
		"\6\b\n\2\t\4\2\37\37!!\4\2\5\6\b\b\3\2\3\4\3\2#%\3\2\16\21\3\2\f\r\3\2"+
		"\n\13\u00e5\2\17\3\2\2\2\4_\3\2\2\2\6q\3\2\2\2\b\u00b7\3\2\2\2\n\u00bf"+
		"\3\2\2\2\f\16\5\4\3\2\r\f\3\2\2\2\16\21\3\2\2\2\17\r\3\2\2\2\17\20\3\2"+
		"\2\2\20\3\3\2\2\2\21\17\3\2\2\2\22\23\7=\2\2\23\24\7\66\2\2\24\25\7\67"+
		"\2\2\25\26\5\n\6\2\26\27\7\60\2\2\27`\3\2\2\2\30\31\7=\2\2\31\32\7\66"+
		"\2\2\32\33\7\67\2\2\33\34\7-\2\2\34\35\5\n\6\2\35\36\7\60\2\2\36`\3\2"+
		"\2\2\37#\7&\2\2 \"\5\4\3\2! \3\2\2\2\"%\3\2\2\2#!\3\2\2\2#$\3\2\2\2$&"+
		"\3\2\2\2%#\3\2\2\2&\'\7\'\2\2\'`\7\60\2\2()\5\6\4\2)*\7\60\2\2*`\3\2\2"+
		"\2+,\7\23\2\2,\61\5\6\4\2-/\7\t\2\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60"+
		"\62\7\36\2\2\61.\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\24\2\2\64"+
		"\67\5\4\3\2\65\66\7\25\2\2\668\5\4\3\2\67\65\3\2\2\2\678\3\2\2\28`\3\2"+
		"\2\29:\7\27\2\2:?\5\6\4\2;=\7\t\2\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>@\7"+
		"\36\2\2?<\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\5\4\3\2B`\3\2\2\2CD\7)\2\2DE\7"+
		"*\2\2EF\7+\2\2FG\7=\2\2G`\5\4\3\2HJ\7)\2\2IK\5\4\3\2JI\3\2\2\2KL\3\2\2"+
		"\2LJ\3\2\2\2LM\3\2\2\2MN\3\2\2\2NO\7*\2\2OP\7+\2\2PQ\7=\2\2QR\7\60\2\2"+
		"R`\3\2\2\2ST\7,\2\2TU\78\2\2UV\7=\2\2V`\7\60\2\2WX\7(\2\2XY\7=\2\2Y`\5"+
		"\4\3\2Z[\7.\2\2[\\\5\6\4\2\\]\7/\2\2]^\7\60\2\2^`\3\2\2\2_\22\3\2\2\2"+
		"_\30\3\2\2\2_\37\3\2\2\2_(\3\2\2\2_+\3\2\2\2_9\3\2\2\2_C\3\2\2\2_H\3\2"+
		"\2\2_S\3\2\2\2_W\3\2\2\2_Z\3\2\2\2`\5\3\2\2\2ab\b\4\1\2bc\7\4\2\2cr\5"+
		"\6\4\20de\7\t\2\2er\5\6\4\17fg\7=\2\2gh\7\22\2\2hr\5\6\4\4ir\5\b\5\2j"+
		"k\t\2\2\2kp\7=\2\2lm\7 \2\2mn\7=\2\2np\78\2\2oj\3\2\2\2ol\3\2\2\2pr\3"+
		"\2\2\2qa\3\2\2\2qd\3\2\2\2qf\3\2\2\2qi\3\2\2\2qo\3\2\2\2r\u00a1\3\2\2"+
		"\2st\f\r\2\2tu\7\7\2\2u\u00a0\5\6\4\rvw\f\f\2\2wx\t\3\2\2x\u00a0\5\6\4"+
		"\ryz\f\13\2\2z{\t\4\2\2{\u00a0\5\6\4\f|}\f\n\2\2}~\7\"\2\2~\177\t\5\2"+
		"\2\177\u0080\5\6\4\2\u0080\u0081\7\n\2\2\u0081\u0082\5\6\4\13\u0082\u00a0"+
		"\3\2\2\2\u0083\u0084\f\b\2\2\u0084\u0085\t\6\2\2\u0085\u00a0\5\6\4\t\u0086"+
		"\u0087\f\7\2\2\u0087\u0088\t\7\2\2\u0088\u00a0\5\6\4\b\u0089\u008a\f\6"+
		"\2\2\u008a\u008b\t\b\2\2\u008b\u00a0\5\6\4\7\u008c\u008d\f\3\2\2\u008d"+
		"\u008e\78\2\2\u008e\u008f\7:\2\2\u008f\u0090\7>\2\2\u0090\u0091\7;\2\2"+
		"\u0091\u0092\7\22\2\2\u0092\u00a0\5\6\4\3\u0093\u0094\f\t\2\2\u0094\u0095"+
		"\t\5\2\2\u0095\u0096\5\6\4\2\u0096\u0097\7\n\2\2\u0097\u0098\5\6\4\2\u0098"+
		"\u0099\7\"\2\2\u0099\u00a0\3\2\2\2\u009a\u009b\f\5\2\2\u009b\u009c\78"+
		"\2\2\u009c\u009d\7:\2\2\u009d\u009e\7>\2\2\u009e\u00a0\7;\2\2\u009fs\3"+
		"\2\2\2\u009fv\3\2\2\2\u009fy\3\2\2\2\u009f|\3\2\2\2\u009f\u0083\3\2\2"+
		"\2\u009f\u0086\3\2\2\2\u009f\u0089\3\2\2\2\u009f\u008c\3\2\2\2\u009f\u0093"+
		"\3\2\2\2\u009f\u009a\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1"+
		"\u00a2\3\2\2\2\u00a2\7\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a5\7\62\2"+
		"\2\u00a5\u00a6\5\6\4\2\u00a6\u00a7\7\63\2\2\u00a7\u00b8\3\2\2\2\u00a8"+
		"\u00b8\7\34\2\2\u00a9\u00b8\7\35\2\2\u00aa\u00b8\7=\2\2\u00ab\u00b8\7"+
		"<\2\2\u00ac\u00ad\7\64\2\2\u00ad\u00b2\5\6\4\2\u00ae\u00af\7\61\2\2\u00af"+
		"\u00b1\5\6\4\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2"+
		"\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00b6\7\65\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00a4\3\2\2\2\u00b7\u00a8\3"+
		"\2\2\2\u00b7\u00a9\3\2\2\2\u00b7\u00aa\3\2\2\2\u00b7\u00ab\3\2\2\2\u00b7"+
		"\u00ac\3\2\2\2\u00b8\t\3\2\2\2\u00b9\u00c0\7\30\2\2\u00ba\u00c0\7\31\2"+
		"\2\u00bb\u00bc\7\32\2\2\u00bc\u00bd\79\2\2\u00bd\u00be\7<\2\2\u00be\u00c0"+
		"\5\n\6\2\u00bf\u00b9\3\2\2\2\u00bf\u00ba\3\2\2\2\u00bf\u00bb\3\2\2\2\u00c0"+
		"\13\3\2\2\2\22\17#.\61\67<?L_oq\u009f\u00a1\u00b2\u00b7\u00bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}