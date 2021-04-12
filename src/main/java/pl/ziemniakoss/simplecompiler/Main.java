package pl.ziemniakoss.simplecompiler;

import org.antlr.v4.runtime.ANTLRFileStream;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarLexer;
import pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions.SemanticException;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		SimpleGrammarLexer lexer = new SimpleGrammarLexer(new ANTLRFileStream(args[0]));
		try {
			new Compiler(args[0]).compile();
		} catch (SemanticException e) {
			System.err.println("Error occurred while analyzing code");
			System.err.println(e.toString());
		}
	}
}