// Generated from SimpleGrammar.g4 by ANTLR 4.9
package pl.ziemniakoss.simplecompiler.grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, Else=2, ElseIf=3, GreaterOrEqual=4, SmallerOrEqual=5, Smaller=6, 
		Greater=7, Equal=8, Fucntion=9, Variable=10, LCurly=11, RCurly=12, LBracket=13, 
		RBracket=14, IntType=15, RealType=16, CommandTerminator=17, While=18, 
		Return=19, Plus=20, Minus=21, Div=22, Mod=23, Mult=24, Comma=25, Assigment=26, 
		ID=27, Int=28, Real=29, WS=30, LineComment=31, MultiLineComment=32;
	public static final int
		RULE_prog = 0, RULE_type = 1, RULE_arithmeticOperator = 2, RULE_valueComparison = 3, 
		RULE_valueComparator = 4, RULE_command = 5, RULE_conditionalStatement = 6, 
		RULE_ifStatement = 7, RULE_elseStatement = 8, RULE_elseIfStatement = 9, 
		RULE_codeBlock = 10, RULE_returnStatement = 11, RULE_varDeclaration = 12, 
		RULE_varAssigment = 13, RULE_simpleValue = 14, RULE_value = 15, RULE_functionCall = 16, 
		RULE_functionArguments = 17, RULE_funParameters = 18, RULE_funParameter = 19, 
		RULE_funDeclaration = 20;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "type", "arithmeticOperator", "valueComparison", "valueComparator", 
			"command", "conditionalStatement", "ifStatement", "elseStatement", "elseIfStatement", 
			"codeBlock", "returnStatement", "varDeclaration", "varAssigment", "simpleValue", 
			"value", "functionCall", "functionArguments", "funParameters", "funParameter", 
			"funDeclaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'elif'", "'>='", "'<='", "'<'", "'>'", "'=='", 
			"'fun'", "'var'", "'{'", "'}'", "'('", "')'", "'int'", "'real'", "';'", 
			"'while'", "'return'", "'+'", "'-'", "'/'", "'%'", "'*'", "','", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "If", "Else", "ElseIf", "GreaterOrEqual", "SmallerOrEqual", "Smaller", 
			"Greater", "Equal", "Fucntion", "Variable", "LCurly", "RCurly", "LBracket", 
			"RBracket", "IntType", "RealType", "CommandTerminator", "While", "Return", 
			"Plus", "Minus", "Div", "Mod", "Mult", "Comma", "Assigment", "ID", "Int", 
			"Real", "WS", "LineComment", "MultiLineComment"
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
	public String getGrammarFileName() { return "SimpleGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpleGrammarParser.EOF, 0); }
		public List<FunDeclarationContext> funDeclaration() {
			return getRuleContexts(FunDeclarationContext.class);
		}
		public FunDeclarationContext funDeclaration(int i) {
			return getRuleContext(FunDeclarationContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(42);
				funDeclaration();
				}
				}
				setState(45); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Fucntion );
			setState(47);
			match(EOF);
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
		public TerminalNode IntType() { return getToken(SimpleGrammarParser.IntType, 0); }
		public TerminalNode RealType() { return getToken(SimpleGrammarParser.RealType, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_la = _input.LA(1);
			if ( !(_la==IntType || _la==RealType) ) {
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

	public static class ArithmeticOperatorContext extends ParserRuleContext {
		public TerminalNode Plus() { return getToken(SimpleGrammarParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(SimpleGrammarParser.Minus, 0); }
		public TerminalNode Div() { return getToken(SimpleGrammarParser.Div, 0); }
		public TerminalNode Mod() { return getToken(SimpleGrammarParser.Mod, 0); }
		public TerminalNode Mult() { return getToken(SimpleGrammarParser.Mult, 0); }
		public ArithmeticOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterArithmeticOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitArithmeticOperator(this);
		}
	}

	public final ArithmeticOperatorContext arithmeticOperator() throws RecognitionException {
		ArithmeticOperatorContext _localctx = new ArithmeticOperatorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_arithmeticOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Div) | (1L << Mod) | (1L << Mult))) != 0)) ) {
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

	public static class ValueComparisonContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ValueComparatorContext valueComparator() {
			return getRuleContext(ValueComparatorContext.class,0);
		}
		public ValueComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueComparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterValueComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitValueComparison(this);
		}
	}

	public final ValueComparisonContext valueComparison() throws RecognitionException {
		ValueComparisonContext _localctx = new ValueComparisonContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_valueComparison);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			value();
			setState(54);
			valueComparator();
			setState(55);
			value();
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

	public static class ValueComparatorContext extends ParserRuleContext {
		public TerminalNode GreaterOrEqual() { return getToken(SimpleGrammarParser.GreaterOrEqual, 0); }
		public TerminalNode SmallerOrEqual() { return getToken(SimpleGrammarParser.SmallerOrEqual, 0); }
		public TerminalNode Smaller() { return getToken(SimpleGrammarParser.Smaller, 0); }
		public TerminalNode Greater() { return getToken(SimpleGrammarParser.Greater, 0); }
		public TerminalNode Equal() { return getToken(SimpleGrammarParser.Equal, 0); }
		public ValueComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueComparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterValueComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitValueComparator(this);
		}
	}

	public final ValueComparatorContext valueComparator() throws RecognitionException {
		ValueComparatorContext _localctx = new ValueComparatorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_valueComparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GreaterOrEqual) | (1L << SmallerOrEqual) | (1L << Smaller) | (1L << Greater) | (1L << Equal))) != 0)) ) {
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

	public static class CommandContext extends ParserRuleContext {
		public VarDeclarationContext varDeclaration() {
			return getRuleContext(VarDeclarationContext.class,0);
		}
		public VarAssigmentContext varAssigment() {
			return getRuleContext(VarAssigmentContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode CommandTerminator() { return getToken(SimpleGrammarParser.CommandTerminator, 0); }
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public ConditionalStatementContext conditionalStatement() {
			return getRuleContext(ConditionalStatementContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitCommand(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_command);
		try {
			setState(66);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				varDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				varAssigment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				functionCall();
				setState(62);
				match(CommandTerminator);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				returnStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(65);
				conditionalStatement();
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

	public static class ConditionalStatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public ConditionalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterConditionalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitConditionalStatement(this);
		}
	}

	public final ConditionalStatementContext conditionalStatement() throws RecognitionException {
		ConditionalStatementContext _localctx = new ConditionalStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_conditionalStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			ifStatement();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ElseIf) {
				{
				{
				setState(69);
				elseIfStatement();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Else) {
				{
				setState(75);
				elseStatement();
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

	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(SimpleGrammarParser.If, 0); }
		public TerminalNode LBracket() { return getToken(SimpleGrammarParser.LBracket, 0); }
		public ValueComparisonContext valueComparison() {
			return getRuleContext(ValueComparisonContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(SimpleGrammarParser.RBracket, 0); }
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(If);
			setState(79);
			match(LBracket);
			setState(80);
			valueComparison();
			setState(81);
			match(RBracket);
			setState(82);
			codeBlock();
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

	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(SimpleGrammarParser.Else, 0); }
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitElseStatement(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(Else);
			setState(85);
			codeBlock();
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

	public static class ElseIfStatementContext extends ParserRuleContext {
		public TerminalNode ElseIf() { return getToken(SimpleGrammarParser.ElseIf, 0); }
		public TerminalNode LBracket() { return getToken(SimpleGrammarParser.LBracket, 0); }
		public ValueComparisonContext valueComparison() {
			return getRuleContext(ValueComparisonContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(SimpleGrammarParser.RBracket, 0); }
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitElseIfStatement(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(ElseIf);
			setState(88);
			match(LBracket);
			setState(89);
			valueComparison();
			setState(90);
			match(RBracket);
			setState(91);
			codeBlock();
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

	public static class CodeBlockContext extends ParserRuleContext {
		public TerminalNode LCurly() { return getToken(SimpleGrammarParser.LCurly, 0); }
		public TerminalNode RCurly() { return getToken(SimpleGrammarParser.RCurly, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public List<CodeBlockContext> codeBlock() {
			return getRuleContexts(CodeBlockContext.class);
		}
		public CodeBlockContext codeBlock(int i) {
			return getRuleContext(CodeBlockContext.class,i);
		}
		public CodeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_codeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterCodeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitCodeBlock(this);
		}
	}

	public final CodeBlockContext codeBlock() throws RecognitionException {
		CodeBlockContext _localctx = new CodeBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_codeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(LCurly);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << If) | (1L << Variable) | (1L << LCurly) | (1L << Return) | (1L << ID))) != 0)) {
				{
				setState(96);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case If:
				case Variable:
				case Return:
				case ID:
					{
					setState(94);
					command();
					}
					break;
				case LCurly:
					{
					setState(95);
					codeBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(RCurly);
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

	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(SimpleGrammarParser.Return, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode CommandTerminator() { return getToken(SimpleGrammarParser.CommandTerminator, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(Return);
			setState(104);
			value();
			setState(105);
			match(CommandTerminator);
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

	public static class VarDeclarationContext extends ParserRuleContext {
		public TerminalNode Variable() { return getToken(SimpleGrammarParser.Variable, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleGrammarParser.ID, 0); }
		public TerminalNode Assigment() { return getToken(SimpleGrammarParser.Assigment, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode CommandTerminator() { return getToken(SimpleGrammarParser.CommandTerminator, 0); }
		public VarDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterVarDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitVarDeclaration(this);
		}
	}

	public final VarDeclarationContext varDeclaration() throws RecognitionException {
		VarDeclarationContext _localctx = new VarDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(Variable);
			setState(108);
			type();
			setState(109);
			match(ID);
			setState(110);
			match(Assigment);
			setState(111);
			value();
			setState(112);
			match(CommandTerminator);
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

	public static class VarAssigmentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleGrammarParser.ID, 0); }
		public TerminalNode Assigment() { return getToken(SimpleGrammarParser.Assigment, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode CommandTerminator() { return getToken(SimpleGrammarParser.CommandTerminator, 0); }
		public VarAssigmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssigment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterVarAssigment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitVarAssigment(this);
		}
	}

	public final VarAssigmentContext varAssigment() throws RecognitionException {
		VarAssigmentContext _localctx = new VarAssigmentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(ID);
			setState(115);
			match(Assigment);
			setState(116);
			value();
			setState(117);
			match(CommandTerminator);
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

	public static class SimpleValueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleGrammarParser.ID, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode Int() { return getToken(SimpleGrammarParser.Int, 0); }
		public TerminalNode Real() { return getToken(SimpleGrammarParser.Real, 0); }
		public SimpleValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterSimpleValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitSimpleValue(this);
		}
	}

	public final SimpleValueContext simpleValue() throws RecognitionException {
		SimpleValueContext _localctx = new SimpleValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_simpleValue);
		try {
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(Int);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(Real);
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

	public static class ValueContext extends ParserRuleContext {
		public List<SimpleValueContext> simpleValue() {
			return getRuleContexts(SimpleValueContext.class);
		}
		public SimpleValueContext simpleValue(int i) {
			return getRuleContext(SimpleValueContext.class,i);
		}
		public List<ArithmeticOperatorContext> arithmeticOperator() {
			return getRuleContexts(ArithmeticOperatorContext.class);
		}
		public ArithmeticOperatorContext arithmeticOperator(int i) {
			return getRuleContext(ArithmeticOperatorContext.class,i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			simpleValue();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Div) | (1L << Mod) | (1L << Mult) | (1L << ID) | (1L << Int) | (1L << Real))) != 0)) {
				{
				setState(128);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
				case Int:
				case Real:
					{
					setState(126);
					simpleValue();
					}
					break;
				case Plus:
				case Minus:
				case Div:
				case Mod:
				case Mult:
					{
					setState(127);
					arithmeticOperator();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(132);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SimpleGrammarParser.ID, 0); }
		public TerminalNode LBracket() { return getToken(SimpleGrammarParser.LBracket, 0); }
		public FunctionArgumentsContext functionArguments() {
			return getRuleContext(FunctionArgumentsContext.class,0);
		}
		public TerminalNode RBracket() { return getToken(SimpleGrammarParser.RBracket, 0); }
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(ID);
			setState(134);
			match(LBracket);
			setState(135);
			functionArguments();
			setState(136);
			match(RBracket);
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

	public static class FunctionArgumentsContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleGrammarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleGrammarParser.Comma, i);
		}
		public FunctionArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterFunctionArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitFunctionArguments(this);
		}
	}

	public final FunctionArgumentsContext functionArguments() throws RecognitionException {
		FunctionArgumentsContext _localctx = new FunctionArgumentsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << Int) | (1L << Real))) != 0)) {
				{
				setState(138);
				value();
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(139);
					match(Comma);
					setState(140);
					value();
					}
					}
					setState(145);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class FunParametersContext extends ParserRuleContext {
		public List<FunParameterContext> funParameter() {
			return getRuleContexts(FunParameterContext.class);
		}
		public FunParameterContext funParameter(int i) {
			return getRuleContext(FunParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleGrammarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleGrammarParser.Comma, i);
		}
		public FunParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterFunParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitFunParameters(this);
		}
	}

	public final FunParametersContext funParameters() throws RecognitionException {
		FunParametersContext _localctx = new FunParametersContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_funParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			funParameter();
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(149);
				match(Comma);
				setState(150);
				funParameter();
				}
				}
				setState(155);
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

	public static class FunParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleGrammarParser.ID, 0); }
		public FunParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterFunParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitFunParameter(this);
		}
	}

	public final FunParameterContext funParameter() throws RecognitionException {
		FunParameterContext _localctx = new FunParameterContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			type();
			setState(157);
			match(ID);
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

	public static class FunDeclarationContext extends ParserRuleContext {
		public TerminalNode Fucntion() { return getToken(SimpleGrammarParser.Fucntion, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(SimpleGrammarParser.ID, 0); }
		public TerminalNode LBracket() { return getToken(SimpleGrammarParser.LBracket, 0); }
		public TerminalNode RBracket() { return getToken(SimpleGrammarParser.RBracket, 0); }
		public CodeBlockContext codeBlock() {
			return getRuleContext(CodeBlockContext.class,0);
		}
		public FunParametersContext funParameters() {
			return getRuleContext(FunParametersContext.class,0);
		}
		public FunDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).enterFunDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleGrammarListener ) ((SimpleGrammarListener)listener).exitFunDeclaration(this);
		}
	}

	public final FunDeclarationContext funDeclaration() throws RecognitionException {
		FunDeclarationContext _localctx = new FunDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(Fucntion);
			setState(160);
			type();
			setState(161);
			match(ID);
			setState(162);
			match(LBracket);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IntType || _la==RealType) {
				{
				setState(163);
				funParameters();
				}
			}

			setState(166);
			match(RBracket);
			setState(167);
			codeBlock();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00ac\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\6\2.\n\2\r\2\16\2/\3\2\3"+
		"\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\5\7E\n\7\3\b\3\b\7\bI\n\b\f\b\16\bL\13\b\3\b\5\bO\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\7\fc\n"+
		"\f\f\f\16\ff\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20~\n\20\3\21\3\21"+
		"\3\21\7\21\u0083\n\21\f\21\16\21\u0086\13\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\7\23\u0090\n\23\f\23\16\23\u0093\13\23\5\23\u0095\n\23"+
		"\3\24\3\24\3\24\7\24\u009a\n\24\f\24\16\24\u009d\13\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\5\26\u00a7\n\26\3\26\3\26\3\26\3\26\2\2\27\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\5\3\2\21\22\3\2\26\32\3"+
		"\2\6\n\2\u00a8\2-\3\2\2\2\4\63\3\2\2\2\6\65\3\2\2\2\b\67\3\2\2\2\n;\3"+
		"\2\2\2\fD\3\2\2\2\16F\3\2\2\2\20P\3\2\2\2\22V\3\2\2\2\24Y\3\2\2\2\26_"+
		"\3\2\2\2\30i\3\2\2\2\32m\3\2\2\2\34t\3\2\2\2\36}\3\2\2\2 \177\3\2\2\2"+
		"\"\u0087\3\2\2\2$\u0094\3\2\2\2&\u0096\3\2\2\2(\u009e\3\2\2\2*\u00a1\3"+
		"\2\2\2,.\5*\26\2-,\3\2\2\2./\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\61\3\2\2"+
		"\2\61\62\7\2\2\3\62\3\3\2\2\2\63\64\t\2\2\2\64\5\3\2\2\2\65\66\t\3\2\2"+
		"\66\7\3\2\2\2\678\5 \21\289\5\n\6\29:\5 \21\2:\t\3\2\2\2;<\t\4\2\2<\13"+
		"\3\2\2\2=E\5\32\16\2>E\5\34\17\2?@\5\"\22\2@A\7\23\2\2AE\3\2\2\2BE\5\30"+
		"\r\2CE\5\16\b\2D=\3\2\2\2D>\3\2\2\2D?\3\2\2\2DB\3\2\2\2DC\3\2\2\2E\r\3"+
		"\2\2\2FJ\5\20\t\2GI\5\24\13\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2"+
		"KN\3\2\2\2LJ\3\2\2\2MO\5\22\n\2NM\3\2\2\2NO\3\2\2\2O\17\3\2\2\2PQ\7\3"+
		"\2\2QR\7\17\2\2RS\5\b\5\2ST\7\20\2\2TU\5\26\f\2U\21\3\2\2\2VW\7\4\2\2"+
		"WX\5\26\f\2X\23\3\2\2\2YZ\7\5\2\2Z[\7\17\2\2[\\\5\b\5\2\\]\7\20\2\2]^"+
		"\5\26\f\2^\25\3\2\2\2_d\7\r\2\2`c\5\f\7\2ac\5\26\f\2b`\3\2\2\2ba\3\2\2"+
		"\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\16\2\2h\27\3"+
		"\2\2\2ij\7\25\2\2jk\5 \21\2kl\7\23\2\2l\31\3\2\2\2mn\7\f\2\2no\5\4\3\2"+
		"op\7\35\2\2pq\7\34\2\2qr\5 \21\2rs\7\23\2\2s\33\3\2\2\2tu\7\35\2\2uv\7"+
		"\34\2\2vw\5 \21\2wx\7\23\2\2x\35\3\2\2\2y~\7\35\2\2z~\5\"\22\2{~\7\36"+
		"\2\2|~\7\37\2\2}y\3\2\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\37\3\2\2\2\177"+
		"\u0084\5\36\20\2\u0080\u0083\5\36\20\2\u0081\u0083\5\6\4\2\u0082\u0080"+
		"\3\2\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085!\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\35\2\2"+
		"\u0088\u0089\7\17\2\2\u0089\u008a\5$\23\2\u008a\u008b\7\20\2\2\u008b#"+
		"\3\2\2\2\u008c\u0091\5 \21\2\u008d\u008e\7\33\2\2\u008e\u0090\5 \21\2"+
		"\u008f\u008d\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u008c\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095%\3\2\2\2\u0096\u009b\5(\25\2\u0097\u0098\7\33\2\2"+
		"\u0098\u009a\5(\25\2\u0099\u0097\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\'\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"\u009f\5\4\3\2\u009f\u00a0\7\35\2\2\u00a0)\3\2\2\2\u00a1\u00a2\7\13\2"+
		"\2\u00a2\u00a3\5\4\3\2\u00a3\u00a4\7\35\2\2\u00a4\u00a6\7\17\2\2\u00a5"+
		"\u00a7\5&\24\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\3\2"+
		"\2\2\u00a8\u00a9\7\20\2\2\u00a9\u00aa\5\26\f\2\u00aa+\3\2\2\2\17/DJNb"+
		"d}\u0082\u0084\u0091\u0094\u009b\u00a6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}