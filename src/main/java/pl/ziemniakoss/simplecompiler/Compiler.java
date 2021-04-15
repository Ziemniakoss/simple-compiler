package pl.ziemniakoss.simplecompiler;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarLexer;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LLVMCodeGenerator;
import pl.ziemniakoss.simplecompiler.semanticanalisis.SemanticAnalyzer;

import java.io.FileWriter;
import java.io.IOException;

public class Compiler {
	private final String inputFileName;
	private String llvmCode;

	public Compiler(String inputFileName) {
		if (!inputFileName.endsWith(".simp")) {
			throw new IllegalArgumentException("Source code file must have extension .simp");
		}
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

	private void compileToLlvm(ParseTree parseTree) throws IOException {
		var llvmCodeGenerator = new LLVMCodeGenerator(parseTree);
		llvmCodeGenerator.generateLlvmCode();
		llvmCode = llvmCodeGenerator.getLlvmCode();

		try (FileWriter out = new FileWriter(getLlvmOutputFileName())) {
			out.write(llvmCode);
		}
		System.out.println();
	}

	private void compileToExecutable() throws IOException {
		if (llvmCode == null) {
			throw new IllegalStateException("generate llvm code first");
		}

		System.out.println("Compiling llvm...");
		new ProcessBuilder("clang", "-lc",  "-O0","-o", getExecutableFileName(), getLlvmOutputFileName())
				.inheritIO()
				.start();
	}

	private String getLlvmOutputFileName() {
		return inputFileName.substring(0, inputFileName.lastIndexOf(".")) + ".ll";
	}

	private String getExecutableFileName() {
		return inputFileName.substring(0, inputFileName.lastIndexOf(".")) + ".out"; //TODO exe on windows
	}
}
