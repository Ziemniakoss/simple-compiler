package pl.ziemniakoss.simplecompiler;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarLexer;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		SimpleGrammarLexer lexer = new SimpleGrammarLexer(new ANTLRFileStream(args[0]));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		SimpleGrammarParser parser = new SimpleGrammarParser(tokens);

		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();

		LLVMCodeGenerator llvmCodeGenerator = new LLVMCodeGenerator();
		walker.walk(llvmCodeGenerator, tree);
		System.out.println(llvmCodeGenerator.getLlvmCode());
	}
}