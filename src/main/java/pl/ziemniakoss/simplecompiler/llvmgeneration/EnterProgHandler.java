package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class EnterProgHandler implements IEnterContextHandler<SimpleGrammarParser.ProgContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ProgContext ctx) {
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream ioLibraryStream = classloader.getResourceAsStream("ioLibrary.ll");
		if (ioLibraryStream == null) {
			throw new RuntimeException("Could not load simple language IO library");
		}

		BufferedReader ioLibraryReader = new BufferedReader(new InputStreamReader(ioLibraryStream));
		try {
			for (String line; (line = ioLibraryReader.readLine()) != null; ) {
				state.getLlvmCode().append(line)
					.append('\n');
			}
		} catch (IOException e) {
			throw new RuntimeException("Could't load IO library");
		}
	}
}
