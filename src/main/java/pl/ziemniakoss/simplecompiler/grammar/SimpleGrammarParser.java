// Generated from SimpleGrammar.g4 by ANTLR 4.9
package pl.ziemniakoss.simplecompiler.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ArithmeticOperator=1, If=2, Else=3, ElseIf=4, Fucntion=5, Variable=6, 
		LCurly=7, RCurly=8, LBracket=9, RBracket=10, IntType=11, RealType=12, 
		CommandTerminator=13, While=14, Return=15, Plus=16, Minus=17, Div=18, 
		Mod=19, Mult=20, Comma=21, Assigment=22, ID=23, Int=24, Real=25, WS=26, 
		LineComment=27, MultiLineComment=28;
	public static final int
		RULE_prog = 0, RULE_type = 1, RULE_command = 2, RULE_codeBlock = 3, RULE_returnStatement = 4, 
		RULE_varDeclaration = 5, RULE_varAssigment = 6, RULE_simpleValue = 7, 
		RULE_value = 8, RULE_functionCall = 9, RULE_functionArguments = 10, RULE_funParameter = 11, 
		RULE_funDeclaration = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "type", "command", "codeBlock", "returnStatement", "varDeclaration", 
			"varAssigment", "simpleValue", "value", "functionCall", "functionArguments", 
			"funParameter", "funDeclaration"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "'if'", "'else'", "'elIf'", "'fun'", "'var'", "'{'", "'}'", 
			"'('", "')'", "'int'", "'real'", "';'", "'while'", "'return'", "'+'", 
			"'-'", "'/'", "'%'", "'*'", "','", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ArithmeticOperator", "If", "Else", "ElseIf", "Fucntion", "Variable", 
			"LCurly", "RCurly", "LBracket", "RBracket", "IntType", "RealType", "CommandTerminator", 
			"While", "Return", "Plus", "Minus", "Div", "Mod", "Mult", "Comma", "Assigment", 
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
			setState(27); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(26);
				funDeclaration();
				}
				}
				setState(29); 
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
			setState(31);
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
		enterRule(_localctx, 4, RULE_command);
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				varDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				varAssigment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				functionCall();
				setState(36);
				match(CommandTerminator);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(38);
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
		enterRule(_localctx, 6, RULE_codeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(LCurly);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Variable) | (1L << LCurly) | (1L << Return) | (1L << ID))) != 0)) {
				{
				setState(44);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Variable:
				case Return:
				case ID:
					{
					setState(42);
					command();
					}
					break;
				case LCurly:
					{
					setState(43);
					codeBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(48);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(49);
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
		enterRule(_localctx, 8, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(Return);
			setState(52);
			value();
			setState(53);
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
		enterRule(_localctx, 10, RULE_varDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(Variable);
			setState(56);
			type();
			setState(57);
			match(ID);
			setState(58);
			match(Assigment);
			setState(59);
			value();
			setState(60);
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
		enterRule(_localctx, 12, RULE_varAssigment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(ID);
			setState(63);
			match(Assigment);
			setState(64);
			value();
			setState(65);
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
		enterRule(_localctx, 14, RULE_simpleValue);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(Int);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
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
		public SimpleValueContext simpleValue() {
			return getRuleContext(SimpleValueContext.class,0);
		}
		public TerminalNode ArithmeticOperator() { return getToken(SimpleGrammarParser.ArithmeticOperator, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
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
		enterRule(_localctx, 16, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			simpleValue();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ArithmeticOperator) {
				{
				setState(74);
				match(ArithmeticOperator);
				setState(75);
				value();
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
		enterRule(_localctx, 18, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(ID);
			setState(79);
			match(LBracket);
			setState(80);
			functionArguments();
			setState(81);
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
		enterRule(_localctx, 20, RULE_functionArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ID) | (1L << Int) | (1L << Real))) != 0)) {
				{
				setState(83);
				value();
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(84);
					match(Comma);
					setState(85);
					value();
					}
					}
					setState(90);
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
		enterRule(_localctx, 22, RULE_funParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			type();
			setState(94);
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
		enterRule(_localctx, 24, RULE_funDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(Fucntion);
			setState(97);
			type();
			setState(98);
			match(ID);
			setState(99);
			match(LBracket);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IntType || _la==RealType) {
				{
				setState(100);
				funParameter();
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(101);
					match(Comma);
					setState(102);
					funParameter();
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(110);
			match(RBracket);
			setState(111);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36t\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\6\2\36\n\2\r\2\16\2\37\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\5\7\5/\n\5\f\5\16\5\62\13\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\5\tJ\n\t\3\n\3\n\3\n\5\nO\n\n\3\13\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\7\fY\n\f\f\f\16\f\\\13\f\5\f^\n\f\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16j\n\16\f\16\16\16m\13\16\5\16o\n\16\3\16\3\16"+
		"\3\16\3\16\2\2\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\3\3\2\r\16\2t\2\35"+
		"\3\2\2\2\4!\3\2\2\2\6)\3\2\2\2\b+\3\2\2\2\n\65\3\2\2\2\f9\3\2\2\2\16@"+
		"\3\2\2\2\20I\3\2\2\2\22K\3\2\2\2\24P\3\2\2\2\26]\3\2\2\2\30_\3\2\2\2\32"+
		"b\3\2\2\2\34\36\5\32\16\2\35\34\3\2\2\2\36\37\3\2\2\2\37\35\3\2\2\2\37"+
		" \3\2\2\2 \3\3\2\2\2!\"\t\2\2\2\"\5\3\2\2\2#*\5\f\7\2$*\5\16\b\2%&\5\24"+
		"\13\2&\'\7\17\2\2\'*\3\2\2\2(*\5\n\6\2)#\3\2\2\2)$\3\2\2\2)%\3\2\2\2)"+
		"(\3\2\2\2*\7\3\2\2\2+\60\7\t\2\2,/\5\6\4\2-/\5\b\5\2.,\3\2\2\2.-\3\2\2"+
		"\2/\62\3\2\2\2\60.\3\2\2\2\60\61\3\2\2\2\61\63\3\2\2\2\62\60\3\2\2\2\63"+
		"\64\7\n\2\2\64\t\3\2\2\2\65\66\7\21\2\2\66\67\5\22\n\2\678\7\17\2\28\13"+
		"\3\2\2\29:\7\b\2\2:;\5\4\3\2;<\7\31\2\2<=\7\30\2\2=>\5\22\n\2>?\7\17\2"+
		"\2?\r\3\2\2\2@A\7\31\2\2AB\7\30\2\2BC\5\22\n\2CD\7\17\2\2D\17\3\2\2\2"+
		"EJ\7\31\2\2FJ\5\24\13\2GJ\7\32\2\2HJ\7\33\2\2IE\3\2\2\2IF\3\2\2\2IG\3"+
		"\2\2\2IH\3\2\2\2J\21\3\2\2\2KN\5\20\t\2LM\7\3\2\2MO\5\22\n\2NL\3\2\2\2"+
		"NO\3\2\2\2O\23\3\2\2\2PQ\7\31\2\2QR\7\13\2\2RS\5\26\f\2ST\7\f\2\2T\25"+
		"\3\2\2\2UZ\5\22\n\2VW\7\27\2\2WY\5\22\n\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2"+
		"\2Z[\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]U\3\2\2\2]^\3\2\2\2^\27\3\2\2\2_`\5"+
		"\4\3\2`a\7\31\2\2a\31\3\2\2\2bc\7\7\2\2cd\5\4\3\2de\7\31\2\2en\7\13\2"+
		"\2fk\5\30\r\2gh\7\27\2\2hj\5\30\r\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3"+
		"\2\2\2lo\3\2\2\2mk\3\2\2\2nf\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\f\2\2qr\5"+
		"\b\5\2r\33\3\2\2\2\f\37).\60INZ]kn";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}