package pl.ziemniakoss.simplecompiler;

import org.antlr.v4.runtime.ParserRuleContext;
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
		System.out.println(tree);
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new Test(), tree);

	}
}

class Test implements ParseTreeListener{

	@Override
	public void visitTerminal(TerminalNode terminalNode) {
		System.out.println("Terminal");
		System.out.println(terminalNode);
		System.out.println(terminalNode.getClass().getName());
		System.out.println(terminalNode.getSymbol());


	}

	@Override
	public void visitErrorNode(ErrorNode errorNode) {
		System.out.println("Error");
		System.out.println(errorNode.toString());

	}

	@Override
	public void enterEveryRule(ParserRuleContext parserRuleContext) {
		System.out.println("Entry every rule");
		System.out.println(parserRuleContext);
	}

	@Override
	public void exitEveryRule(ParserRuleContext parserRuleContext) {
		System.out.println("exit entry");
		System.out.println(parserRuleContext);

	}
}
