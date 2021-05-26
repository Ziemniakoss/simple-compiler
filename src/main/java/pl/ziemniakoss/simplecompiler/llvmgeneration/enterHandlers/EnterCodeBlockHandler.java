package pl.ziemniakoss.simplecompiler.llvmgeneration.enterHandlers;

import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;
import pl.ziemniakoss.simplecompiler.llvmgeneration.IEnterContextHandler;
import pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGeneratorState;

import java.util.HashMap;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.*;

public class EnterCodeBlockHandler implements IEnterContextHandler<SimpleGrammarParser.CodeBlockContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.CodeBlockContext ctx) {
		state.indent++;
		state.getVariableContexts().push(new HashMap<>());
		if (ctx.parent instanceof SimpleGrammarParser.IfStatementContext) {
			var castedParent = (SimpleGrammarParser.IfStatementContext) ctx.parent;
			var conditionalStatement = (SimpleGrammarParser.ConditionalStatementContext) castedParent.parent;
			String labelToJumpIfConditionIsFalse;
			if (conditionalStatement.elseIfStatement().size() > 0) {
				labelToJumpIfConditionIsFalse = getContextKey(conditionalStatement.elseIfStatement(0));
			} else if (conditionalStatement.elseStatement() != null) {
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
		} else if(ctx.parent instanceof SimpleGrammarParser.WhileLoopContext) {
			var whileLookContext = ((SimpleGrammarParser.WhileLoopContext) ctx.parent);
			handleBeggingOfIfOrElseIfBlock(state, whileLookContext.valueComparison(), getEndOfWhileLoopLabel(whileLookContext));
		}
	}

	private void handleBeggingOfIfOrElseIfBlock(
		LlvmCodeGeneratorState state, SimpleGrammarParser.ValueComparisonContext valueComparisonContext,
		String labelToJumpIfConditionIsFalse
	) {
		state.newLineAndIdent()
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
