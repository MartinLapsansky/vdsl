// Generated from C:/Users/Admin/Documents/skola/5r/vdsl/escape-room-spring/Escaperoom.g4 by ANTLR 4.13.2
package org.example.escaperoomspring.antlr4;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class EscaperoomParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		STRING=18, WS=19, INT=20;
	public static final int
		RULE_escaperoom = 0, RULE_welcomeMessage = 1, RULE_escapeMessage = 2, 
		RULE_room = 3, RULE_description = 4, RULE_finalTask = 5, RULE_task = 6, 
		RULE_taskDetails = 7, RULE_successColors = 8, RULE_type = 9, RULE_hint = 10, 
		RULE_solution = 11, RULE_lightSequence = 12, RULE_successColor = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"escaperoom", "welcomeMessage", "escapeMessage", "room", "description", 
			"finalTask", "task", "taskDetails", "successColors", "type", "hint", 
			"solution", "lightSequence", "successColor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'escapeRoom'", "'welcomeMessage'", "'escapeMessage'", "'room'", 
			"'description'", "'finalTask'", "'task'", "'taskDetails'", "'LOGIC_PUZZLE'", 
			"'VOICE_PUZZLE'", "'CODE_PUZZLE'", "'LIGHT_PUZZLE'", "'RIDDLE_PUZZLE'", 
			"'hint'", "'solution'", "'lightSequence'", "'successColor'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "STRING", "WS", "INT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Escaperoom.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public EscaperoomParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EscaperoomContext extends ParserRuleContext {
		public WelcomeMessageContext welcomeMessage() {
			return getRuleContext(WelcomeMessageContext.class,0);
		}
		public EscapeMessageContext escapeMessage() {
			return getRuleContext(EscapeMessageContext.class,0);
		}
		public List<RoomContext> room() {
			return getRuleContexts(RoomContext.class);
		}
		public RoomContext room(int i) {
			return getRuleContext(RoomContext.class,i);
		}
		public EscaperoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escaperoom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterEscaperoom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitEscaperoom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitEscaperoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscaperoomContext escaperoom() throws RecognitionException {
		EscaperoomContext _localctx = new EscaperoomContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_escaperoom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			welcomeMessage();
			setState(30);
			escapeMessage();
			setState(32); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(31);
				room();
				}
				}
				setState(34); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__3 );
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

	@SuppressWarnings("CheckReturnValue")
	public static class WelcomeMessageContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscaperoomParser.STRING, 0); }
		public WelcomeMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_welcomeMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterWelcomeMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitWelcomeMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitWelcomeMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WelcomeMessageContext welcomeMessage() throws RecognitionException {
		WelcomeMessageContext _localctx = new WelcomeMessageContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_welcomeMessage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(T__1);
			setState(37);
			match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EscapeMessageContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscaperoomParser.STRING, 0); }
		public EscapeMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_escapeMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterEscapeMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitEscapeMessage(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitEscapeMessage(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EscapeMessageContext escapeMessage() throws RecognitionException {
		EscapeMessageContext _localctx = new EscapeMessageContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_escapeMessage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(T__2);
			setState(40);
			match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class RoomContext extends ParserRuleContext {
		public Token timeLimit;
		public Token name;
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public TerminalNode INT() { return getToken(EscaperoomParser.INT, 0); }
		public TerminalNode STRING() { return getToken(EscaperoomParser.STRING, 0); }
		public List<TaskContext> task() {
			return getRuleContexts(TaskContext.class);
		}
		public TaskContext task(int i) {
			return getRuleContext(TaskContext.class,i);
		}
		public FinalTaskContext finalTask() {
			return getRuleContext(FinalTaskContext.class,0);
		}
		public RoomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_room; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterRoom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitRoom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitRoom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoomContext room() throws RecognitionException {
		RoomContext _localctx = new RoomContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_room);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__3);
			setState(43);
			((RoomContext)_localctx).timeLimit = match(INT);
			setState(44);
			((RoomContext)_localctx).name = match(STRING);
			setState(45);
			description();
			setState(47); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(46);
				task();
				}
				}
				setState(49); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__6 );
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(51);
				finalTask();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class DescriptionContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscaperoomParser.STRING, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_description);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__4);
			setState(55);
			match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class FinalTaskContext extends ParserRuleContext {
		public SuccessColorsContext successColors() {
			return getRuleContext(SuccessColorsContext.class,0);
		}
		public FinalTaskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finalTask; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterFinalTask(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitFinalTask(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitFinalTask(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinalTaskContext finalTask() throws RecognitionException {
		FinalTaskContext _localctx = new FinalTaskContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_finalTask);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(T__5);
			setState(58);
			successColors();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TaskContext extends ParserRuleContext {
		public Token index;
		public Token name;
		public Token attempts;
		public DescriptionContext description() {
			return getRuleContext(DescriptionContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public HintContext hint() {
			return getRuleContext(HintContext.class,0);
		}
		public SolutionContext solution() {
			return getRuleContext(SolutionContext.class,0);
		}
		public TaskDetailsContext taskDetails() {
			return getRuleContext(TaskDetailsContext.class,0);
		}
		public SuccessColorContext successColor() {
			return getRuleContext(SuccessColorContext.class,0);
		}
		public List<TerminalNode> INT() { return getTokens(EscaperoomParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(EscaperoomParser.INT, i);
		}
		public TerminalNode STRING() { return getToken(EscaperoomParser.STRING, 0); }
		public List<LightSequenceContext> lightSequence() {
			return getRuleContexts(LightSequenceContext.class);
		}
		public LightSequenceContext lightSequence(int i) {
			return getRuleContext(LightSequenceContext.class,i);
		}
		public TaskContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_task; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterTask(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitTask(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitTask(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskContext task() throws RecognitionException {
		TaskContext _localctx = new TaskContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_task);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__6);
			setState(61);
			((TaskContext)_localctx).index = match(INT);
			setState(62);
			((TaskContext)_localctx).name = match(STRING);
			setState(63);
			description();
			setState(64);
			type();
			setState(65);
			hint();
			setState(66);
			solution();
			setState(67);
			taskDetails();
			setState(68);
			((TaskContext)_localctx).attempts = match(INT);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15) {
				{
				{
				setState(69);
				lightSequence();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			successColor();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TaskDetailsContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscaperoomParser.STRING, 0); }
		public TaskDetailsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_taskDetails; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterTaskDetails(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitTaskDetails(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitTaskDetails(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TaskDetailsContext taskDetails() throws RecognitionException {
		TaskDetailsContext _localctx = new TaskDetailsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_taskDetails);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__7);
			setState(78);
			match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SuccessColorsContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(EscaperoomParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(EscaperoomParser.STRING, i);
		}
		public SuccessColorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_successColors; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterSuccessColors(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitSuccessColors(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitSuccessColors(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuccessColorsContext successColors() throws RecognitionException {
		SuccessColorsContext _localctx = new SuccessColorsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_successColors);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(80);
				match(STRING);
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 15872L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	@SuppressWarnings("CheckReturnValue")
	public static class HintContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(EscaperoomParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(EscaperoomParser.STRING, i);
		}
		public HintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterHint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitHint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitHint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HintContext hint() throws RecognitionException {
		HintContext _localctx = new HintContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_hint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(T__13);
			setState(89); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(88);
				match(STRING);
				}
				}
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
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

	@SuppressWarnings("CheckReturnValue")
	public static class SolutionContext extends ParserRuleContext {
		public Token correctAnswer;
		public TerminalNode STRING() { return getToken(EscaperoomParser.STRING, 0); }
		public SolutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterSolution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitSolution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitSolution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SolutionContext solution() throws RecognitionException {
		SolutionContext _localctx = new SolutionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_solution);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(T__14);
			setState(94);
			((SolutionContext)_localctx).correctAnswer = match(STRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LightSequenceContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(EscaperoomParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(EscaperoomParser.STRING, i);
		}
		public LightSequenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lightSequence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterLightSequence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitLightSequence(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitLightSequence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LightSequenceContext lightSequence() throws RecognitionException {
		LightSequenceContext _localctx = new LightSequenceContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_lightSequence);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(T__15);
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				match(STRING);
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==STRING );
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

	@SuppressWarnings("CheckReturnValue")
	public static class SuccessColorContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(EscaperoomParser.STRING, 0); }
		public SuccessColorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_successColor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).enterSuccessColor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof EscaperoomListener ) ((EscaperoomListener)listener).exitSuccessColor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof EscaperoomVisitor ) return ((EscaperoomVisitor<? extends T>)visitor).visitSuccessColor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuccessColorContext successColor() throws RecognitionException {
		SuccessColorContext _localctx = new SuccessColorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_successColor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(T__16);
			setState(103);
			match(STRING);
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

	public static final String _serializedATN =
		"\u0004\u0001\u0014j\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000!\b\u0000\u000b\u0000\f\u0000\"\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0004\u00030\b\u0003\u000b\u0003\f\u0003"+
		"1\u0001\u0003\u0003\u00035\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006G\b\u0006\n\u0006\f\u0006J\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0004\bR\b\b"+
		"\u000b\b\f\bS\u0001\t\u0001\t\u0001\n\u0001\n\u0004\nZ\b\n\u000b\n\f\n"+
		"[\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0004\fc\b\f\u000b"+
		"\f\f\fd\u0001\r\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0001"+
		"\u0001\u0000\t\rb\u0000\u001c\u0001\u0000\u0000\u0000\u0002$\u0001\u0000"+
		"\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000\u0006*\u0001\u0000\u0000"+
		"\u0000\b6\u0001\u0000\u0000\u0000\n9\u0001\u0000\u0000\u0000\f<\u0001"+
		"\u0000\u0000\u0000\u000eM\u0001\u0000\u0000\u0000\u0010Q\u0001\u0000\u0000"+
		"\u0000\u0012U\u0001\u0000\u0000\u0000\u0014W\u0001\u0000\u0000\u0000\u0016"+
		"]\u0001\u0000\u0000\u0000\u0018`\u0001\u0000\u0000\u0000\u001af\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0005\u0001\u0000\u0000\u001d\u001e\u0003"+
		"\u0002\u0001\u0000\u001e \u0003\u0004\u0002\u0000\u001f!\u0003\u0006\u0003"+
		"\u0000 \u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\" \u0001"+
		"\u0000\u0000\u0000\"#\u0001\u0000\u0000\u0000#\u0001\u0001\u0000\u0000"+
		"\u0000$%\u0005\u0002\u0000\u0000%&\u0005\u0012\u0000\u0000&\u0003\u0001"+
		"\u0000\u0000\u0000\'(\u0005\u0003\u0000\u0000()\u0005\u0012\u0000\u0000"+
		")\u0005\u0001\u0000\u0000\u0000*+\u0005\u0004\u0000\u0000+,\u0005\u0014"+
		"\u0000\u0000,-\u0005\u0012\u0000\u0000-/\u0003\b\u0004\u0000.0\u0003\f"+
		"\u0006\u0000/.\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u00001/\u0001"+
		"\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000\u0000\u0000"+
		"35\u0003\n\u0005\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"5\u0007\u0001\u0000\u0000\u000067\u0005\u0005\u0000\u000078\u0005\u0012"+
		"\u0000\u00008\t\u0001\u0000\u0000\u00009:\u0005\u0006\u0000\u0000:;\u0003"+
		"\u0010\b\u0000;\u000b\u0001\u0000\u0000\u0000<=\u0005\u0007\u0000\u0000"+
		"=>\u0005\u0014\u0000\u0000>?\u0005\u0012\u0000\u0000?@\u0003\b\u0004\u0000"+
		"@A\u0003\u0012\t\u0000AB\u0003\u0014\n\u0000BC\u0003\u0016\u000b\u0000"+
		"CD\u0003\u000e\u0007\u0000DH\u0005\u0014\u0000\u0000EG\u0003\u0018\f\u0000"+
		"FE\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000"+
		"\u0000\u0000KL\u0003\u001a\r\u0000L\r\u0001\u0000\u0000\u0000MN\u0005"+
		"\b\u0000\u0000NO\u0005\u0012\u0000\u0000O\u000f\u0001\u0000\u0000\u0000"+
		"PR\u0005\u0012\u0000\u0000QP\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000T\u0011\u0001"+
		"\u0000\u0000\u0000UV\u0007\u0000\u0000\u0000V\u0013\u0001\u0000\u0000"+
		"\u0000WY\u0005\u000e\u0000\u0000XZ\u0005\u0012\u0000\u0000YX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001"+
		"\u0000\u0000\u0000\\\u0015\u0001\u0000\u0000\u0000]^\u0005\u000f\u0000"+
		"\u0000^_\u0005\u0012\u0000\u0000_\u0017\u0001\u0000\u0000\u0000`b\u0005"+
		"\u0010\u0000\u0000ac\u0005\u0012\u0000\u0000ba\u0001\u0000\u0000\u0000"+
		"cd\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000e\u0019\u0001\u0000\u0000\u0000fg\u0005\u0011\u0000\u0000gh\u0005"+
		"\u0012\u0000\u0000h\u001b\u0001\u0000\u0000\u0000\u0007\"14HS[d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}