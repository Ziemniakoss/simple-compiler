package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.RpnOperationType;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.Stack;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.generateCastingLlvmCode;

public class ExitValueHandler implements IExitContextHandler<SimpleGrammarParser.ValueContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ValueContext ctx) {
		Stack<Integer> operatorsOfValues = new Stack<>();
		Stack<VariableType> valueType = new Stack<>();

		for (var child : ctx.children) {
			if (child instanceof SimpleGrammarParser.SimpleValueContext) {
				var simpleValue = (SimpleGrammarParser.SimpleValueContext) child;
				int operationWithValue = state.getContextToOperationWithResult().get(simpleValue);
				operatorsOfValues.push(operationWithValue);
				valueType.push(state.getOperationIndexToStoredValueType().get(operationWithValue));
			} else {
				var operator = (SimpleGrammarParser.ArithmeticOperatorContext) child;
				RpnOperationType operationType;
				if (operator.Plus() != null) {
					operationType = RpnOperationType.ADD;
				} else if (operator.Minus() != null) {
					operationType = RpnOperationType.SUB;
				} else if (operator.Div() != null) {
					operationType = RpnOperationType.DIV;
				} else if (operator.Mult() != null) {
					operationType = RpnOperationType.MUL;
				} else {
					operationType = RpnOperationType.MOD;
				}
				generateRpnOperationCode(operatorsOfValues, valueType, operationType, state);
			}
		}
		state.getContextToOperationWithResult().put(ctx, operatorsOfValues.peek());
		state.getOperationIndexToStoredValueType().put(operatorsOfValues.pop(), valueType.pop());
	}

	private void generateRpnOperationCode(Stack<Integer> valuesStack, Stack<VariableType> typesStack, RpnOperationType operationType, LlvmCodeGeneratorState state) {
		int secondOperandIndex = valuesStack.pop();
		var secondOperandType = typesStack.pop();
		int firstOperandIndex = valuesStack.pop();
		var firstOperandType = typesStack.pop();

		VariableType operationExecutedOnType;
		if (operationType == RpnOperationType.MOD) {
			if (firstOperandType == VariableType.REAL) {
				firstOperandIndex = generateCastingLlvmCode(state, firstOperandIndex, VariableType.REAL, VariableType.INTEGER);
			}
			if (secondOperandType == VariableType.REAL) {
				secondOperandIndex = generateCastingLlvmCode(state, secondOperandIndex, VariableType.REAL, VariableType.INTEGER);
			}
			operationExecutedOnType = VariableType.INTEGER;

		} else if (firstOperandType == secondOperandType) {
			operationExecutedOnType = firstOperandType;
		} else {
			// Cast to real needed
			if (firstOperandType != VariableType.REAL) {
				firstOperandIndex = generateCastingLlvmCode(state, firstOperandIndex, firstOperandType, VariableType.REAL);
			} else if (secondOperandType != VariableType.REAL) {
				secondOperandIndex = generateCastingLlvmCode(state, secondOperandIndex, secondOperandType, VariableType.REAL);
			}
			operationExecutedOnType = VariableType.REAL;
		}
		int operationWithResult = generateLlvmCodeForOperation(operationType, operationExecutedOnType, firstOperandIndex, secondOperandIndex, state);
		valuesStack.push(operationWithResult);
		typesStack.push(operationExecutedOnType);
	}

	/**
	 * Generates llvm code for given operation performed on specified operands type
	 *
	 * @param firstOperand  index of operation holding value of first operand
	 * @param secondOperand index of operation holding value of second operand
	 * @return index of operation containing result of operation
	 */
	private int generateLlvmCodeForOperation(RpnOperationType operationType, VariableType typeOfOperands, int firstOperand, int secondOperand, LlvmCodeGeneratorState state) {
		String llvmInstruction;
		if (operationType == RpnOperationType.ADD) {
			llvmInstruction = typeOfOperands == VariableType.INTEGER ? "add i32" : "fadd double";
		} else if (operationType == RpnOperationType.SUB) {
			llvmInstruction = typeOfOperands == VariableType.INTEGER ? "sub i32" : "fsub double";
		} else if (operationType == RpnOperationType.MUL) {
			llvmInstruction = typeOfOperands == VariableType.INTEGER ? "mul i32" : "fmul double";
		} else if (operationType == RpnOperationType.DIV) {
			llvmInstruction = typeOfOperands == VariableType.INTEGER ? "sdiv i32" : "fdiv double";
		} else {
			llvmInstruction = "srem i32";
		}
		state.getLlvmCode().append('%')
			.append(state.nextOperationIndex)
			.append(" = ")
			.append(llvmInstruction)
			.append(" %")
			.append(firstOperand)
			.append(", %")
			.append(secondOperand)
			.append('\n')
			.append("\t".repeat(state.indent));
		return state.nextOperationIndex++;
	}
}
