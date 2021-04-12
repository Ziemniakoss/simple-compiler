package pl.ziemniakoss.simplecompiler;

import pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions.SemanticException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		if (args.length == 0) {
			System.err.println("Please specify input file");
			System.exit(1);
		}
		String inputFileName = args[0];
		if(!inputFileName.endsWith(".simp")) {
			System.err.println("Source files must have .simp extension");
		}

		try {
			new Compiler(inputFileName).compile();
		} catch (SemanticException e) {
			System.err.println("Error occurred while analyzing code");
			System.err.println(e.toString());
		} catch (FileNotFoundException e) {
			System.err.println("File with " + inputFileName + "name does not exist");
		}
	}
}