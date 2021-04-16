package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.LinkedList;

public class LlvmCodeGenerationUtils {
	public static int genererateLlvmCodeForFunctionCall(LlvmCodeGeneratorState state, SimpleGrammarParser.FunctionCallContext ctx) {
		String calledFunctionName = ctx.ID().toString();
		Function calledFunction = state.getFunctionNameToDefinition().get(calledFunctionName);
		LinkedList<Integer> operationsWithFunctionArgments = new LinkedList<>();
		var passedFunctionArguments = ctx.functionArguments().value();
		for (int i = 0; i < passedFunctionArguments.size(); i++) {
			var functionParameter = calledFunction.getArgumentsTypes()[i];
			var passedArgument = passedFunctionArguments.get(i);
			var operationWithPassedArgument = state.getContextToOperationWithResult().get(passedArgument);
			var passedArgumentType = state.getOperationIndexToStoredValueType().get(operationWithPassedArgument);
			if (passedArgumentType != functionParameter) {
				operationWithPassedArgument = generateCastingLlvmCode(state, operationWithPassedArgument, passedArgumentType, functionParameter);
			}
			operationsWithFunctionArgments.push(operationWithPassedArgument);
		}
		state.getLlvmCode().append('%')
			.append(state.nextOperationIndex)
			.append(" = call ")
			.append(calledFunction.getReturnType())
			.append(" @")
			.append(calledFunction.getName())
			.append('(');
		for (int i = 0; i < calledFunction.getArgumentsTypes().length; i++) {
			if (i != 0) {
				state.getLlvmCode().append(", ");
			}
			state.getLlvmCode().append(calledFunction.getArgumentsTypes()[i])
				.append(" %")
				.append(operationsWithFunctionArgments.get(i));
		}
		state.getLlvmCode().append(")\n")
			.append("\t".repeat(state.indent));
		return state.nextOperationIndex++;
	}

	public static int generateCastingLlvmCode(LlvmCodeGeneratorState state, int operationToCast, VariableType from, VariableType to) {
		var castingInstruction = from == VariableType.INTEGER ? "sitofp" : "fptoui";
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent))
			.append('%')
			.append(state.nextOperationIndex)
			.append(" = ")
			.append(castingInstruction)
			.append(' ')
			.append(from)
			.append(" %")
			.append(operationToCast)
			.append(" to ")
			.append(to)
			.append('\n')
			.append("\t".repeat(state.indent));
		return state.nextOperationIndex++;
	}
}
