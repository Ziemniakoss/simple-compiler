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
		If=1, Else=2, ElseIf=3, GreaterOrEqual=4, SmallerOrEqual=5, Smaller=6, 
		Greater=7, Equal=8, Fucntion=9, Variable=10, LCurly=11, RCurly=12, LBracket=13, 
		RBracket=14, IntType=15, RealType=16, CommandTerminator=17, While=18, 
		Return=19, Plus=20, Minus=21, Div=22, Mod=23, Mult=24, Comma=25, Assigment=26, 
		ID=27, Int=28, Real=29, WS=30, LineComment=31, MultiLineComment=32;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"If", "Else", "ElseIf", "GreaterOrEqual", "SmallerOrEqual", "Smaller", 
			"Greater", "Equal", "Fucntion", "Variable", "LCurly", "RCurly", "LBracket", 
			"RBracket", "IntType", "RealType", "CommandTerminator", "While", "Return", 
			"Plus", "Minus", "Div", "Mod", "Mult", "Comma", "Assigment", "ID", "Int", 
			"Real", "Digit", "Char", "NewLine", "WS", "LineComment", "MultiLineComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\"\u00dd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27"+
		"\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\6\34\u009b\n\34\r\34\16"+
		"\34\u009c\3\35\5\35\u00a0\n\35\3\35\6\35\u00a3\n\35\r\35\16\35\u00a4\3"+
		"\36\5\36\u00a8\n\36\3\36\6\36\u00ab\n\36\r\36\16\36\u00ac\3\36\3\36\6"+
		"\36\u00b1\n\36\r\36\16\36\u00b2\3\37\3\37\3 \3 \3!\5!\u00ba\n!\3!\3!\3"+
		"\"\6\"\u00bf\n\"\r\"\16\"\u00c0\3\"\3\"\3#\3#\3#\3#\7#\u00c9\n#\f#\16"+
		"#\u00cc\13#\3#\3#\3$\3$\3$\3$\7$\u00d4\n$\f$\16$\u00d7\13$\3$\3$\3$\3"+
		"$\3$\3\u00d5\2%\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37=\2?\2A\2C E!G\"\3\2\5\4\2C\\c|\4\2\13\f\"\"\4\2\f\f"+
		"\17\17\2\u00e3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2\5L\3"+
		"\2\2\2\7Q\3\2\2\2\tV\3\2\2\2\13Y\3\2\2\2\r\\\3\2\2\2\17^\3\2\2\2\21`\3"+
		"\2\2\2\23c\3\2\2\2\25g\3\2\2\2\27k\3\2\2\2\31m\3\2\2\2\33o\3\2\2\2\35"+
		"q\3\2\2\2\37s\3\2\2\2!w\3\2\2\2#|\3\2\2\2%~\3\2\2\2\'\u0084\3\2\2\2)\u008b"+
		"\3\2\2\2+\u008d\3\2\2\2-\u008f\3\2\2\2/\u0091\3\2\2\2\61\u0093\3\2\2\2"+
		"\63\u0095\3\2\2\2\65\u0097\3\2\2\2\67\u009a\3\2\2\29\u009f\3\2\2\2;\u00a7"+
		"\3\2\2\2=\u00b4\3\2\2\2?\u00b6\3\2\2\2A\u00b9\3\2\2\2C\u00be\3\2\2\2E"+
		"\u00c4\3\2\2\2G\u00cf\3\2\2\2IJ\7k\2\2JK\7h\2\2K\4\3\2\2\2LM\7g\2\2MN"+
		"\7n\2\2NO\7u\2\2OP\7g\2\2P\6\3\2\2\2QR\7g\2\2RS\7n\2\2ST\7k\2\2TU\7h\2"+
		"\2U\b\3\2\2\2VW\7@\2\2WX\7?\2\2X\n\3\2\2\2YZ\7>\2\2Z[\7?\2\2[\f\3\2\2"+
		"\2\\]\7>\2\2]\16\3\2\2\2^_\7@\2\2_\20\3\2\2\2`a\7?\2\2ab\7?\2\2b\22\3"+
		"\2\2\2cd\7h\2\2de\7w\2\2ef\7p\2\2f\24\3\2\2\2gh\7x\2\2hi\7c\2\2ij\7t\2"+
		"\2j\26\3\2\2\2kl\7}\2\2l\30\3\2\2\2mn\7\177\2\2n\32\3\2\2\2op\7*\2\2p"+
		"\34\3\2\2\2qr\7+\2\2r\36\3\2\2\2st\7k\2\2tu\7p\2\2uv\7v\2\2v \3\2\2\2"+
		"wx\7t\2\2xy\7g\2\2yz\7c\2\2z{\7n\2\2{\"\3\2\2\2|}\7=\2\2}$\3\2\2\2~\177"+
		"\7y\2\2\177\u0080\7j\2\2\u0080\u0081\7k\2\2\u0081\u0082\7n\2\2\u0082\u0083"+
		"\7g\2\2\u0083&\3\2\2\2\u0084\u0085\7t\2\2\u0085\u0086\7g\2\2\u0086\u0087"+
		"\7v\2\2\u0087\u0088\7w\2\2\u0088\u0089\7t\2\2\u0089\u008a\7p\2\2\u008a"+
		"(\3\2\2\2\u008b\u008c\7-\2\2\u008c*\3\2\2\2\u008d\u008e\7/\2\2\u008e,"+
		"\3\2\2\2\u008f\u0090\7\61\2\2\u0090.\3\2\2\2\u0091\u0092\7\'\2\2\u0092"+
		"\60\3\2\2\2\u0093\u0094\7,\2\2\u0094\62\3\2\2\2\u0095\u0096\7.\2\2\u0096"+
		"\64\3\2\2\2\u0097\u0098\7?\2\2\u0098\66\3\2\2\2\u0099\u009b\t\2\2\2\u009a"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2"+
		"\2\2\u009d8\3\2\2\2\u009e\u00a0\5+\26\2\u009f\u009e\3\2\2\2\u009f\u00a0"+
		"\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u00a3\5=\37\2\u00a2\u00a1\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5:\3\2\2\2"+
		"\u00a6\u00a8\5+\26\2\u00a7\u00a6\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa"+
		"\3\2\2\2\u00a9\u00ab\5=\37\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b0\7\60"+
		"\2\2\u00af\u00b1\5=\37\2\u00b0\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3<\3\2\2\2\u00b4\u00b5\4\62;\2"+
		"\u00b5>\3\2\2\2\u00b6\u00b7\t\2\2\2\u00b7@\3\2\2\2\u00b8\u00ba\7\17\2"+
		"\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00bc"+
		"\7\f\2\2\u00bcB\3\2\2\2\u00bd\u00bf\t\3\2\2\u00be\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\u00c3\b\"\2\2\u00c3D\3\2\2\2\u00c4\u00c5\7\61\2\2\u00c5\u00c6"+
		"\7\61\2\2\u00c6\u00ca\3\2\2\2\u00c7\u00c9\n\4\2\2\u00c8\u00c7\3\2\2\2"+
		"\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cd"+
		"\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\b#\2\2\u00ceF\3\2\2\2\u00cf\u00d0"+
		"\7\61\2\2\u00d0\u00d1\7,\2\2\u00d1\u00d5\3\2\2\2\u00d2\u00d4\13\2\2\2"+
		"\u00d3\u00d2\3\2\2\2\u00d4\u00d7\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d5\u00d3"+
		"\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\u00d9\7,\2\2\u00d9"+
		"\u00da\7\61\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\b$\2\2\u00dcH\3\2\2\2"+
		"\r\2\u009c\u009f\u00a4\u00a7\u00ac\u00b2\u00b9\u00c0\u00ca\u00d5\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}