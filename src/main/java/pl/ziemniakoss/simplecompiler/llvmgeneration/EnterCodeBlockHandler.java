package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.HashMap;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getContextKey;
import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.getEndOfConditionalBlockKey;

public class EnterCodeBlockHandler implements IEnterContextHandler<SimpleGrammarParser.CodeBlockContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CodeBlockContext ctx) {
		state.getLlvmCode().append("\t".repeat(state.indent++));
		state.getLlvmCode().append('\n');
		state.getVariableContexts().push(new HashMap<>());
		if(ctx.parent instanceof SimpleGrammarParser.IfStatementContext) {
			var castedParent = (SimpleGrammarParser.IfStatementContext) ctx.parent;
			var conditionalStatement = (SimpleGrammarParser.ConditionalStatementContext) castedParent.parent;
			String labelToJumpIfConditionIsFalse;
			if(conditionalStatement.elseIfStatement().size() > 0) {
				labelToJumpIfConditionIsFalse = getContextKey(conditionalStatement.elseIfStatement(0));
			} else if(conditionalStatement.elseStatement() != null) {
				labelToJumpIfConditionIsFalse = getContextKey(conditionalStatement.elseStatement());
			} else {
				labelToJumpIfConditionIsFalse = getEndOfConditionalBlockKey(conditionalStatement);
			}
			handleBeggingOfIfOrElseIfBlock(state, castedParent.valueComparison(), labelToJumpIfConditionIsFalse);
		} else if(ctx.parent instanceof SimpleGrammarParser.ElseIfStatementContext) {
			var castedParent = (SimpleGrammarParser.ElseIfStatementContext) ctx.parent;
			var conditionalStatement = (SimpleGrammarParser.ConditionalStatementContext) castedParent.parent;
			int indexInElseIfsList = conditionalStatement.elseIfStatement().indexOf(castedParent);
			String labelToJumpIfConditionIsFalse;
			if(indexInElseIfsList ==  conditionalStatement.elseIfStatement().size() - 1) {
				labelToJumpIfConditionIsFalse = getEndOfConditionalBlockKey(conditionalStatement);
			} else {
				labelToJumpIfConditionIsFalse = getContextKey(conditionalStatement.elseIfStatement(indexInElseIfsList + 1));
			}
			handleBeggingOfIfOrElseIfBlock(state, castedParent.valueComparison(), labelToJumpIfConditionIsFalse);
		} else if(ctx.parent instanceof  SimpleGrammarParser.ElseStatementContext) {

		}
	}

	private void handleBeggingOfIfOrElseIfBlock(
		LlvmCodeGeneratorState state, SimpleGrammarParser.ValueComparisonContext valueComparisonContext,
		String labelToJumpIfConditionIsFalse
	) {
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent))
			.append("br i1 ")
			.append(getContextKey(valueComparisonContext))
			.append(", label %")
			.append(state.nextOperationIndex)
			.append(", label ")
			.append(labelToJumpIfConditionIsFalse);

		state.getLlvmCode().append('\n')
			.append(state.nextOperationIndex++)
			.append(":\n")
			.append("; begin if or else if block\n");
	}
}
