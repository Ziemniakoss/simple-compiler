package pl.ziemniakoss.simplecompiler.llvmgeneration;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import pl.ziemniakoss.simplecompiler.EnterElseIfStatementHandler;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarBaseListener;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

public class LLVMCodeGenerator extends SimpleGrammarBaseListener {
	private final ParseTree parseTree;
	private final LlvmCodeGeneratorState state = new LlvmCodeGeneratorState();

	public LLVMCodeGenerator(ParseTree parseTree) {
		this.parseTree = parseTree;
	}

	public String getLlvmCode() {
		return state.getLlvmCode().toString();
	}

	public void generateLlvmCode() {
		ParseTreeWalker treeWalker = new ParseTreeWalker();
		treeWalker.walk(this, this.parseTree);
	}

	@Override
	public void enterProg(SimpleGrammarParser.ProgContext ctx) {
		new EnterProgHandler().handle(state, ctx);
	}

	@Override
	public void enterCommand(SimpleGrammarParser.CommandContext ctx) {
		new EnterCommandHandler().handle(state, ctx);
	}

	@Override
	public void exitCommand(SimpleGrammarParser.CommandContext ctx) {
		new ExitCommandHandler().handle(state, ctx);
	}

	@Override
	public void exitCodeBlock(SimpleGrammarParser.CodeBlockContext ctx) {
		new ExitCodeBlockHandler().handle(state, ctx);
	}

	@Override
	public void exitReturnStatement(SimpleGrammarParser.ReturnStatementContext ctx) {
		new ExitReturnStatementHandler().handle(state, ctx);
	}

	@Override
	public void enterVarDeclaration(SimpleGrammarParser.VarDeclarationContext ctx) {
		new EnterVarDeclarationHandler().handle(state, ctx);
	}

	@Override
	public void exitVarDeclaration(SimpleGrammarParser.VarDeclarationContext ctx) {
		new ExitVarDeclarationHandler().handle(state, ctx);
	}

	@Override
	public void exitSimpleValue(SimpleGrammarParser.SimpleValueContext ctx) {
		new ExitSimpleValueHandler().handle(state, ctx);
	}

	@Override
	public void enterElseIfStatement(SimpleGrammarParser.ElseIfStatementContext ctx) {
		new EnterElseIfStatementHandler().handle(state, ctx);
	}

	@Override
	public void exitIfStatement(SimpleGrammarParser.IfStatementContext ctx) {
		new ExitIfStatementHandler().handle(state, ctx);
	}

	@Override
	public void exitElseIfStatement(SimpleGrammarParser.ElseIfStatementContext ctx) {
		new ExitElseIfStatementHandler().handle(state, ctx);
	}

	@Override
	public void enterElseStatement(SimpleGrammarParser.ElseStatementContext ctx) {
		new EnterElseStatementHandler().handle(state, ctx);
	}

	@Override
	public void exitElseStatement(SimpleGrammarParser.ElseStatementContext ctx) {
		new ExitElseStatementHandler().handle(state, ctx);
	}

	@Override
	public void enterFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		new EnterFunDeclarationHandler().handle(state, ctx);
	}

	@Override
	public void enterCodeBlock(SimpleGrammarParser.CodeBlockContext ctx) {
		new EnterCodeBlockHandler().handle(state, ctx);
	}

	@Override
	public void exitFunDeclaration(SimpleGrammarParser.FunDeclarationContext ctx) {
		new ExitFunDeclarationHandler().handle(state, ctx);
	}

	@Override
	public void exitValueComparison(SimpleGrammarParser.ValueComparisonContext ctx) {
		new ExitValueComparisonHandler().handle(state, ctx);
	}

	@Override
	public void enterConditionalStatement(SimpleGrammarParser.ConditionalStatementContext ctx) {
		new EnterConditionalStatementHandler().handle(state, ctx);
	}

	@Override
	public void exitConditionalStatement(SimpleGrammarParser.ConditionalStatementContext ctx) {
		new ExitConditionalStatementHandler().handle(state, ctx);
	}

	@Override
	public void exitValue(SimpleGrammarParser.ValueContext ctx) {
		new ExitValueHandler().handle(state, ctx);
	}

	@Override
	public void exitVarAssigment(SimpleGrammarParser.VarAssigmentContext ctx) {
		new ExitVarAssigmentHandler().handle(state, ctx);
	}

	@Override
	public String toString() {
		return getLlvmCode();
	}
}
