// Generated from SimpleGrammar.g4 by ANTLR 4.9
package pl.ziemniakoss.simplecompiler.grammar;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		If=1, Else=2, ElseIf=3, Fucntion=4, Variable=5, LCurly=6, RCurly=7, LBracket=8, 
		RBracket=9, IntType=10, RealType=11, CommandTerminator=12, While=13, Return=14, 
		Plus=15, Minus=16, Div=17, Mod=18, Mult=19, Comma=20, Assigment=21, ID=22, 
		Int=23, Real=24, WS=25, LineComment=26, MultiLineComment=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"If", "Else", "ElseIf", "Fucntion", "Variable", "LCurly", "RCurly", "LBracket", 
			"RBracket", "IntType", "RealType", "CommandTerminator", "While", "Return", 
			"Plus", "Minus", "Div", "Mod", "Mult", "Comma", "Assigment", "ID", "Int", 
			"Real", "Digit", "Char", "NewLine", "WS", "LineComment", "MultiLineComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00c6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\6\27\u0084\n\27\r\27\16\27\u0085\3\30\5\30\u0089"+
		"\n\30\3\30\6\30\u008c\n\30\r\30\16\30\u008d\3\31\5\31\u0091\n\31\3\31"+
		"\6\31\u0094\n\31\r\31\16\31\u0095\3\31\3\31\6\31\u009a\n\31\r\31\16\31"+
		"\u009b\3\32\3\32\3\33\3\33\3\34\5\34\u00a3\n\34\3\34\3\34\3\35\6\35\u00a8"+
		"\n\35\r\35\16\35\u00a9\3\35\3\35\3\36\3\36\3\36\3\36\7\36\u00b2\n\36\f"+
		"\36\16\36\u00b5\13\36\3\36\3\36\3\37\3\37\3\37\3\37\7\37\u00bd\n\37\f"+
		"\37\16\37\u00c0\13\37\3\37\3\37\3\37\3\37\3\37\3\u00be\2 \3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\2\65\2\67\29\33;\34=\35\3\2\5\4\2C"+
		"\\c|\4\2\13\f\"\"\4\2\f\f\17\17\2\u00cc\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5B\3\2\2\2\7G\3\2\2\2\tL\3\2\2\2\13P\3\2"+
		"\2\2\rT\3\2\2\2\17V\3\2\2\2\21X\3\2\2\2\23Z\3\2\2\2\25\\\3\2\2\2\27`\3"+
		"\2\2\2\31e\3\2\2\2\33g\3\2\2\2\35m\3\2\2\2\37t\3\2\2\2!v\3\2\2\2#x\3\2"+
		"\2\2%z\3\2\2\2\'|\3\2\2\2)~\3\2\2\2+\u0080\3\2\2\2-\u0083\3\2\2\2/\u0088"+
		"\3\2\2\2\61\u0090\3\2\2\2\63\u009d\3\2\2\2\65\u009f\3\2\2\2\67\u00a2\3"+
		"\2\2\29\u00a7\3\2\2\2;\u00ad\3\2\2\2=\u00b8\3\2\2\2?@\7k\2\2@A\7h\2\2"+
		"A\4\3\2\2\2BC\7g\2\2CD\7n\2\2DE\7u\2\2EF\7g\2\2F\6\3\2\2\2GH\7g\2\2HI"+
		"\7n\2\2IJ\7K\2\2JK\7h\2\2K\b\3\2\2\2LM\7h\2\2MN\7w\2\2NO\7p\2\2O\n\3\2"+
		"\2\2PQ\7x\2\2QR\7c\2\2RS\7t\2\2S\f\3\2\2\2TU\7}\2\2U\16\3\2\2\2VW\7\177"+
		"\2\2W\20\3\2\2\2XY\7*\2\2Y\22\3\2\2\2Z[\7+\2\2[\24\3\2\2\2\\]\7k\2\2]"+
		"^\7p\2\2^_\7v\2\2_\26\3\2\2\2`a\7t\2\2ab\7g\2\2bc\7c\2\2cd\7n\2\2d\30"+
		"\3\2\2\2ef\7=\2\2f\32\3\2\2\2gh\7y\2\2hi\7j\2\2ij\7k\2\2jk\7n\2\2kl\7"+
		"g\2\2l\34\3\2\2\2mn\7t\2\2no\7g\2\2op\7v\2\2pq\7w\2\2qr\7t\2\2rs\7p\2"+
		"\2s\36\3\2\2\2tu\7-\2\2u \3\2\2\2vw\7/\2\2w\"\3\2\2\2xy\7\61\2\2y$\3\2"+
		"\2\2z{\7\'\2\2{&\3\2\2\2|}\7,\2\2}(\3\2\2\2~\177\7.\2\2\177*\3\2\2\2\u0080"+
		"\u0081\7?\2\2\u0081,\3\2\2\2\u0082\u0084\t\2\2\2\u0083\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086.\3\2\2\2"+
		"\u0087\u0089\5!\21\2\u0088\u0087\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b"+
		"\3\2\2\2\u008a\u008c\5\63\32\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2"+
		"\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\60\3\2\2\2\u008f\u0091"+
		"\5!\21\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0094\5\63\32\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3"+
		"\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0099\7\60\2\2\u0098"+
		"\u009a\5\63\32\2\u0099\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u0099\3"+
		"\2\2\2\u009b\u009c\3\2\2\2\u009c\62\3\2\2\2\u009d\u009e\4\62;\2\u009e"+
		"\64\3\2\2\2\u009f\u00a0\t\2\2\2\u00a0\66\3\2\2\2\u00a1\u00a3\7\17\2\2"+
		"\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5"+
		"\7\f\2\2\u00a58\3\2\2\2\u00a6\u00a8\t\3\2\2\u00a7\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2"+
		"\2\2\u00ab\u00ac\b\35\2\2\u00ac:\3\2\2\2\u00ad\u00ae\7\61\2\2\u00ae\u00af"+
		"\7\61\2\2\u00af\u00b3\3\2\2\2\u00b0\u00b2\n\4\2\2\u00b1\u00b0\3\2\2\2"+
		"\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6"+
		"\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\b\36\2\2\u00b7<\3\2\2\2\u00b8"+
		"\u00b9\7\61\2\2\u00b9\u00ba\7,\2\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\13"+
		"\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bf\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7,"+
		"\2\2\u00c2\u00c3\7\61\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\37\2\2\u00c5"+
		">\3\2\2\2\r\2\u0085\u0088\u008d\u0090\u0095\u009b\u00a2\u00a9\u00b3\u00be"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}