package pl.ziemniakoss.simplecompiler;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarLexer;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.semanticanalisis.SemanticAnalyzer;

import java.io.IOException;

public class Compiler {
	private final String inputFileName;
	private String llvmCode;

	public Compiler(String inputFileName) {
		this.inputFileName = inputFileName;
	}

	public void compile() throws IOException {
		SimpleGrammarLexer lexer = new SimpleGrammarLexer(new ANTLRFileStream(inputFileName));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		SimpleGrammarParser parser = new SimpleGrammarParser(tokens);
		ParseTree tree = parser.prog();

		analyze(tree);
		compileToLlvm(tree);
		compileToExecutable();
	}

	private void analyze(ParseTree parseTree) {
		new SemanticAnalyzer(parseTree).analyze();
	}

	private void compileToLlvm(ParseTree parseTree) {
		var llvmCodeGenerator = new LLVMCodeGenerator(parseTree);
		llvmCodeGenerator.generateLlvmCode();
		llvmCode = llvmCodeGenerator.getLlvmCode();
		//TODO output to file
		System.out.println(llvmCode);
	}

	private void compileToExecutable() {
		if(llvmCode == null) {
			throw new IllegalStateException("generate llvm code first");
		}
		System.out.println("Compiling");
	}
}
