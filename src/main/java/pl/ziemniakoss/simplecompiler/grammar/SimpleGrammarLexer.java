// Generated from SimpleGrammar.g4 by ANTLR 4.9
package pl.ziemniakoss.simplecompiler.grammar;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ArithmeticOperator=1, If=2, Else=3, ElseIf=4, Fucntion=5, Variable=6, 
		LCurly=7, RCurly=8, LBracket=9, RBracket=10, IntType=11, RealType=12, 
		CommandTerminator=13, While=14, Return=15, Plus=16, Minus=17, Div=18, 
		Mod=19, Mult=20, Comma=21, Assigment=22, ID=23, Int=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ArithmeticOperator", "If", "Else", "ElseIf", "Fucntion", "Variable", 
			"LCurly", "RCurly", "LBracket", "RBracket", "IntType", "RealType", "CommandTerminator", 
			"While", "Return", "Plus", "Minus", "Div", "Mod", "Mult", "Comma", "Assigment", 
			"ID", "Int", "Digit", "Char", "NewLine", "WS"
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
			"ID", "Int", "WS"
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


	public SimpleGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleGrammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u009f\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\3\2\5\2"+
		"A\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\6\30\u0087\n\30\r\30\16\30\u0088\3\31\6"+
		"\31\u008c\n\31\r\31\16\31\u008d\3\32\3\32\3\33\3\33\3\34\5\34\u0095\n"+
		"\34\3\34\3\34\3\35\6\35\u009a\n\35\r\35\16\35\u009b\3\35\3\35\2\2\36\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\2\67\29\33\3\2\4\4"+
		"\2C\\c|\4\2\13\f\"\"\2\u00a3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\29\3\2\2\2\3@\3\2\2\2\5B\3\2"+
		"\2\2\7E\3\2\2\2\tJ\3\2\2\2\13O\3\2\2\2\rS\3\2\2\2\17W\3\2\2\2\21Y\3\2"+
		"\2\2\23[\3\2\2\2\25]\3\2\2\2\27_\3\2\2\2\31c\3\2\2\2\33h\3\2\2\2\35j\3"+
		"\2\2\2\37p\3\2\2\2!w\3\2\2\2#y\3\2\2\2%{\3\2\2\2\'}\3\2\2\2)\177\3\2\2"+
		"\2+\u0081\3\2\2\2-\u0083\3\2\2\2/\u0086\3\2\2\2\61\u008b\3\2\2\2\63\u008f"+
		"\3\2\2\2\65\u0091\3\2\2\2\67\u0094\3\2\2\29\u0099\3\2\2\2;A\5!\21\2<A"+
		"\5#\22\2=A\5%\23\2>A\5\'\24\2?A\5)\25\2@;\3\2\2\2@<\3\2\2\2@=\3\2\2\2"+
		"@>\3\2\2\2@?\3\2\2\2A\4\3\2\2\2BC\7k\2\2CD\7h\2\2D\6\3\2\2\2EF\7g\2\2"+
		"FG\7n\2\2GH\7u\2\2HI\7g\2\2I\b\3\2\2\2JK\7g\2\2KL\7n\2\2LM\7K\2\2MN\7"+
		"h\2\2N\n\3\2\2\2OP\7h\2\2PQ\7w\2\2QR\7p\2\2R\f\3\2\2\2ST\7x\2\2TU\7c\2"+
		"\2UV\7t\2\2V\16\3\2\2\2WX\7}\2\2X\20\3\2\2\2YZ\7\177\2\2Z\22\3\2\2\2["+
		"\\\7*\2\2\\\24\3\2\2\2]^\7+\2\2^\26\3\2\2\2_`\7k\2\2`a\7p\2\2ab\7v\2\2"+
		"b\30\3\2\2\2cd\7t\2\2de\7g\2\2ef\7c\2\2fg\7n\2\2g\32\3\2\2\2hi\7=\2\2"+
		"i\34\3\2\2\2jk\7y\2\2kl\7j\2\2lm\7k\2\2mn\7n\2\2no\7g\2\2o\36\3\2\2\2"+
		"pq\7t\2\2qr\7g\2\2rs\7v\2\2st\7w\2\2tu\7t\2\2uv\7p\2\2v \3\2\2\2wx\7-"+
		"\2\2x\"\3\2\2\2yz\7/\2\2z$\3\2\2\2{|\7\61\2\2|&\3\2\2\2}~\7\'\2\2~(\3"+
		"\2\2\2\177\u0080\7,\2\2\u0080*\3\2\2\2\u0081\u0082\7.\2\2\u0082,\3\2\2"+
		"\2\u0083\u0084\7?\2\2\u0084.\3\2\2\2\u0085\u0087\t\2\2\2\u0086\u0085\3"+
		"\2\2\2\u0087\u0088\3\2\2\2\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089"+
		"\60\3\2\2\2\u008a\u008c\5\63\32\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2"+
		"\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\62\3\2\2\2\u008f\u0090"+
		"\4\62;\2\u0090\64\3\2\2\2\u0091\u0092\t\2\2\2\u0092\66\3\2\2\2\u0093\u0095"+
		"\7\17\2\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\3\2\2\2"+
		"\u0096\u0097\7\f\2\2\u00978\3\2\2\2\u0098\u009a\t\3\2\2\u0099\u0098\3"+
		"\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009d\3\2\2\2\u009d\u009e\b\35\2\2\u009e:\3\2\2\2\b\2@\u0088\u008d\u0094"+
		"\u009b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}