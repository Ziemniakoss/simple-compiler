package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.HashMap;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getContextKey;

public class EnterCodeBlockHandler implements IEnterContextHandler<SimpleGrammarParser.CodeBlockContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CodeBlockContext ctx) {
		state.getLlvmCode().append("\t".repeat(state.indent++));
		if (state.isGlobalContext()) {//todo move to exitDunDeclaration
			state.getLlvmCode().append('{');
		}
		state.getLlvmCode().append('\n');
		state.getVariableContexts().push(new HashMap<>());
		if(ctx.parent instanceof SimpleGrammarParser.IfStatementContext) {
			handleBeggingOfIfBlock(state, (SimpleGrammarParser.IfStatementContext) ctx.parent);
		} else if(ctx.parent instanceof  SimpleGrammarParser.ElseIfStatementContext) {

		} else if(ctx.parent instanceof  SimpleGrammarParser.ElseStatementContext) {

		}
	}

	private void handleBeggingOfIfBlock(LlvmCodeGeneratorState state, SimpleGrammarParser.IfStatementContext ctx) {
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent))
			.append("br i1 ")
			.append(getContextKey(ctx.valueComparison()))
			.append(", label %")
			.append(state.nextOperationIndex)
			.append(", label ")
			.append(LlvmCodeGenerationUtils.getEndOfConditionalBlockKey((SimpleGrammarParser.ConditionalStatementContext) ctx.parent));

		state.getLlvmCode().append('\n')
			.append(state.nextOperationIndex++)
			.append(":\n")
			.append("; begin if block\n");
	}
}
