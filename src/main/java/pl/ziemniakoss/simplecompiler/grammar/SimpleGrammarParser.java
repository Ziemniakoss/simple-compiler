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
		If=1, Else=2, ElseIf=3, Fucntion=4, Variable=5, LCurly=6, RCurly=7, LBracket=8, 
		RBracket=9, IntType=10, RealType=11, CommandTerminator=12, While=13, Return=14, 
		Plus=15, Minus=16, Div=17, Mod=18, Mult=19, Comma=20, Assigment=21, ID=22, 
		Int=23, Real=24, WS=25, LineComment=26, MultiLineComment=27;
	public static final int
		RULE_prog = 0, RULE_type = 1, RULE_arithmeticOperator = 2, RULE_command = 3, 
		RULE_codeBlock = 4, RULE_returnStatement = 5, RULE_varDeclaration = 6, 
		RULE_varAssigment = 7, RULE_simpleValue = 8, RULE_value = 9, RULE_functionCall = 10, 
		RULE_functionArguments = 11, RULE_funParameters = 12, RULE_funParameter = 13, 
		RULE_funDeclaration = 14;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "type", "arithmeticOperator", "command", "codeBlock", "returnStatement", 
			"varDeclaration", "varAssigment", "simpleValue", "value", "functionCall", 
			"functionArguments", "funParameters", "funParameter", "funDeclaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'elIf'", "'fun'", "'var'", "'{'", "'}'", "'('", 
			"')'", "'int'", "'real'", "';'", "'while'", "'return'", "'+'", "'-'", 
			"'/'", "'%'", "'*'", "','", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "If", "Else", "ElseIf", "Fucntion", "Variable", "LCurly", "RCurly", 
			"LBracket", "RBracket", "IntType", "RealType", "CommandTerminator", "While", 
			"Return", "Plus", "Minus", "Div", "Mod", "Mult", "Comma", "Assigment", 
			"ID", "Int", "Real", "WS", "LineComment", "MultiLineComment"
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
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				funDeclaration();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Fucntion );
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
			setState(35);
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
			setState(37);
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
		enterRule(_localctx, 6, RULE_command);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				varDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(40);
				varAssigment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(41);
				functionCall();
				setState(42);
				match(CommandTerminator);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				returnStatement();
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
		enterRule(_localctx, 8, RULE_codeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			match(LCurly);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Variable) | (1L << LCurly) | (1L << Return) | (1L << ID))) != 0)) {
				{
				setState(50);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Variable:
				case Return:
				case ID:
					{
					setState(48);
					command();
					}
					break;
				case LCurly:
					{
					setState(49);
					codeBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
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
		enterRule(_localctx, 10, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(Return);
			setState(58);
			value();
			setState(59);
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
		enterRule(_localctx, 12, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(Variable);
			setState(62);
			type();
			setState(63);
			match(ID);
			setState(64);
			match(Assigment);
			setState(65);
			value();
			setState(66);
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
		enterRule(_localctx, 14, RULE_varAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(ID);
			setState(69);
			match(Assigment);
			setState(70);
			value();
			setState(71);
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
		enterRule(_localctx, 16, RULE_simpleValue);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(Int);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
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
		enterRule(_localctx, 18, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			simpleValue();
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Plus) | (1L << Minus) | (1L << Div) | (1L << Mod) | (1L << Mult) | (1L << ID) | (1L << Int) | (1L << Real))) != 0)) {
				{
				setState(82);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID:
				case Int:
				case Real:
					{
					setState(80);
					simpleValue();
					}
					break;
				case Plus:
				case Minus:
				case Div:
				case Mod:
				case Mult:
					{
					setState(81);
					arithmeticOperator();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(86);
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
		enterRule(_localctx, 20, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(ID);
			setState(88);
			match(LBracket);
			setState(89);
			functionArguments();
			setState(90);
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
		enterRule(_localctx, 22, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << Int) | (1L << Real))) != 0)) {
				{
				setState(92);
				value();
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(93);
					match(Comma);
					setState(94);
					value();
					}
					}
					setState(99);
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
		enterRule(_localctx, 24, RULE_funParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			funParameter();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(103);
				match(Comma);
				setState(104);
				funParameter();
				}
				}
				setState(109);
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
		enterRule(_localctx, 26, RULE_funParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			type();
			setState(111);
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
		enterRule(_localctx, 28, RULE_funDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(Fucntion);
			setState(114);
			type();
			setState(115);
			match(ID);
			setState(116);
			match(LBracket);
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IntType || _la==RealType) {
				{
				setState(117);
				funParameters();
				}
			}

			setState(120);
			match(RBracket);
			setState(121);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35~\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\6\2\"\n\2\r\2\16\2#\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5\60\n\5\3\6\3\6\3\6\7\6\65\n"+
		"\6\f\6\16\68\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\nP\n\n\3\13\3\13\3\13\7\13U\n\13"+
		"\f\13\16\13X\13\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\rb\n\r\f\r\16\re"+
		"\13\r\5\rg\n\r\3\16\3\16\3\16\7\16l\n\16\f\16\16\16o\13\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\5\20y\n\20\3\20\3\20\3\20\3\20\2\2\21\2\4"+
		"\6\b\n\f\16\20\22\24\26\30\32\34\36\2\4\3\2\f\r\3\2\21\25\2}\2!\3\2\2"+
		"\2\4%\3\2\2\2\6\'\3\2\2\2\b/\3\2\2\2\n\61\3\2\2\2\f;\3\2\2\2\16?\3\2\2"+
		"\2\20F\3\2\2\2\22O\3\2\2\2\24Q\3\2\2\2\26Y\3\2\2\2\30f\3\2\2\2\32h\3\2"+
		"\2\2\34p\3\2\2\2\36s\3\2\2\2 \"\5\36\20\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2"+
		"\2#$\3\2\2\2$\3\3\2\2\2%&\t\2\2\2&\5\3\2\2\2\'(\t\3\2\2(\7\3\2\2\2)\60"+
		"\5\16\b\2*\60\5\20\t\2+,\5\26\f\2,-\7\16\2\2-\60\3\2\2\2.\60\5\f\7\2/"+
		")\3\2\2\2/*\3\2\2\2/+\3\2\2\2/.\3\2\2\2\60\t\3\2\2\2\61\66\7\b\2\2\62"+
		"\65\5\b\5\2\63\65\5\n\6\2\64\62\3\2\2\2\64\63\3\2\2\2\658\3\2\2\2\66\64"+
		"\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\29:\7\t\2\2:\13\3\2\2\2;"+
		"<\7\20\2\2<=\5\24\13\2=>\7\16\2\2>\r\3\2\2\2?@\7\7\2\2@A\5\4\3\2AB\7\30"+
		"\2\2BC\7\27\2\2CD\5\24\13\2DE\7\16\2\2E\17\3\2\2\2FG\7\30\2\2GH\7\27\2"+
		"\2HI\5\24\13\2IJ\7\16\2\2J\21\3\2\2\2KP\7\30\2\2LP\5\26\f\2MP\7\31\2\2"+
		"NP\7\32\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2ON\3\2\2\2P\23\3\2\2\2QV\5\22"+
		"\n\2RU\5\22\n\2SU\5\6\4\2TR\3\2\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3"+
		"\2\2\2W\25\3\2\2\2XV\3\2\2\2YZ\7\30\2\2Z[\7\n\2\2[\\\5\30\r\2\\]\7\13"+
		"\2\2]\27\3\2\2\2^c\5\24\13\2_`\7\26\2\2`b\5\24\13\2a_\3\2\2\2be\3\2\2"+
		"\2ca\3\2\2\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2f^\3\2\2\2fg\3\2\2\2g\31\3\2"+
		"\2\2hm\5\34\17\2ij\7\26\2\2jl\5\34\17\2ki\3\2\2\2lo\3\2\2\2mk\3\2\2\2"+
		"mn\3\2\2\2n\33\3\2\2\2om\3\2\2\2pq\5\4\3\2qr\7\30\2\2r\35\3\2\2\2st\7"+
		"\6\2\2tu\5\4\3\2uv\7\30\2\2vx\7\n\2\2wy\5\32\16\2xw\3\2\2\2xy\3\2\2\2"+
		"yz\3\2\2\2z{\7\13\2\2{|\5\n\6\2|\37\3\2\2\2\r#/\64\66OTVcfmx";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}