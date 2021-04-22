package pl.ziemniakoss.simplecompiler.llvmgeneration;

import pl.ziemniakoss.simplecompiler.RpnOperationType;
import pl.ziemniakoss.simplecompiler.Variable;
import pl.ziemniakoss.simplecompiler.VariableType;
import pl.ziemniakoss.simplecompiler.grammar.SimpleGrammarParser;

import java.util.Stack;

import static pl.ziemniakoss.simplecompiler.llvmgeneration.LlvmCodeGenerationUtils.generateCastingLlvmCode;

public class ExitValueHandler implements IExitContextHandler<SimpleGrammarParser.ValueContext> {
	@Override
	public void handle(LlvmCodeGeneratorState state, SimpleGrammarParser.ValueContext ctx) {
		Stack<RpnOperand> operandsStack = new Stack<>();

		for (var child : ctx.children) {
			if (child instanceof SimpleGrammarParser.ArithmeticOperatorContext) {
				var arithmeticCtx = (SimpleGrammarParser.ArithmeticOperatorContext) child;
				if (arithmeticCtx.Mod() != null) {
					handleRpnModuloOperation(operandsStack, state);
				} else {
					//TODO
					//handleRpnNonModuloOperation(operandsStack, state, getRpnOperationForContext(arithmeticCtx));
				}
			} else {
				var simpleValueContext = (SimpleGrammarParser.SimpleValueContext) child;
				operandsStack.push(convertSimpleValueContextToRpnOperand(simpleValueContext, state));
			}
		}
		RpnOperand result = operandsStack.pop();
		if(result instanceof NumberOperand) {
			state.getValueContextToPrecalculatedValue().put(ctx, ((NumberOperand) result).getValue());
		} else {
			state.getContextToOperationWithResult().put(ctx, result.getValueStoredInOperation());
			state.getOperationIndexToStoredValueType().put(result.getValueStoredInOperation(), result.getOperandType());
		}
	/*Stack<Integer> operatorsOfValues = new Stack<>();
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
		state.getOperationIndexToStoredValueType().put(operatorsOfValues.pop(), valueType.pop());*/

	}

	private RpnOperand convertSimpleValueContextToRpnOperand(SimpleGrammarParser.SimpleValueContext ctx, LlvmCodeGeneratorState state) {
		if (ctx.ID() != null) {
			var variable = state.getVariable(ctx.ID().toString());
			return new VariableOperand(variable.getType(), ctx, variable);
		} else if (ctx.functionCall() != null) {
			var function = state.getFunctionNameToDefinition().get(ctx.functionCall().ID().toString());
			return new RpnOperand(function.getReturnType(), ctx, state.getContextToOperationWithResult().get(ctx));
		} else if (ctx.Int() != null) {
			return new IntegerNumberOperand(ctx);
		} else {
			return new RealNumberOperand(ctx);
		}
	}

	private RpnOperationType getRpnOperationForContext(SimpleGrammarParser.ArithmeticOperatorContext ctx) {
		if (ctx.Plus() != null) {
			return RpnOperationType.ADD;
		} else if (ctx.Minus() != null) {
			return RpnOperationType.SUB;
		} else if (ctx.Div() != null) {
			return RpnOperationType.DIV;
		} else if (ctx.Mult() != null) {
			return RpnOperationType.MUL;
		} else {
			return RpnOperationType.MOD;
		}
	}

	private void handleRpnModuloOperation(Stack<RpnOperand> operandsStack, LlvmCodeGeneratorState state) {
		RpnOperand secondOperand = operandsStack.pop();
		RpnOperand firstOperand = operandsStack.pop();
		if (firstOperand instanceof NumberOperand && secondOperand instanceof NumberOperand) {
			int firstOperandValue = (int) ((NumberOperand) firstOperand).getValue();
			int secondOperandValue = (int) ((NumberOperand) secondOperand).getValue();
			int result = firstOperandValue % secondOperandValue;
			operandsStack.push(new IntegerNumberOperand(result));
			return;
		}
		String operationWithFirstOperandValueAsString;
		String operationWithSecondOperandValueAsString;
		if (firstOperand instanceof NumberOperand) {
			int operationWithSecondOperandValue = secondOperand.getValueStoredInOperation();
			if (secondOperand.getOperandType() != VariableType.INTEGER) {
				operationWithSecondOperandValue = generateCastingLlvmCode(state, operationWithSecondOperandValue, VariableType.REAL, VariableType.INTEGER);
			}
			operationWithSecondOperandValueAsString = "%" + operationWithSecondOperandValue;
			operationWithFirstOperandValueAsString = "" + ((int) ((NumberOperand) firstOperand).getValue());
		} else if (secondOperand instanceof NumberOperand) {
			int operationWitFirstOperandValue = firstOperand.getValueStoredInOperation();
			if(firstOperand.getOperandType() != VariableType.INTEGER) {
				operationWitFirstOperandValue = generateCastingLlvmCode(state, operationWitFirstOperandValue, VariableType.REAL, VariableType.INTEGER);
			}
			operationWithFirstOperandValueAsString = "%" + operationWitFirstOperandValue;
			operationWithSecondOperandValueAsString = "" + ((int) ((NumberOperand) secondOperand).getValue());
		} else {
			int operationWithFirstOperandValue = firstOperand.getValueStoredInOperation();
			if(firstOperand.getOperandType() != VariableType.INTEGER) {
				operationWithFirstOperandValue = generateCastingLlvmCode(state, operationWithFirstOperandValue, VariableType.REAL, VariableType.INTEGER);
			}
			int operationWithSecondOperandValue = secondOperand.getValueStoredInOperation();
			if(secondOperand.getOperandType() != VariableType.INTEGER) {
				operationWithSecondOperandValue = generateCastingLlvmCode(state, operationWithSecondOperandValue, VariableType.REAL, VariableType.INTEGER);
			}
			operationWithFirstOperandValueAsString = "%" + operationWithFirstOperandValue;
			operationWithSecondOperandValueAsString = "%" + operationWithSecondOperandValue;
		}
		state.getLlvmCode().append('\n')
			.append("\t".repeat(state.indent))
			.append('%')
			.append(state.nextOperationIndex)
			.append(" = srem i32 ")
			.append(operationWithFirstOperandValueAsString)
			.append(", ")
			.append(operationWithSecondOperandValueAsString);
	}

	private double getParsedDouble(SimpleGrammarParser.SimpleValueContext ctx) {
		if (ctx.Int() != null) {
			return Double.parseDouble(ctx.Int().toString());
		} else if (ctx.Real() != null) {
			return Double.parseDouble(ctx.Real().toString());
		}
		throw new IllegalArgumentException("ctx should have int or real");
	}
	//TODO remove

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

class RpnOperand {
	private final VariableType operandType;

	private final int valueStoredInOperation;

	private final SimpleGrammarParser.SimpleValueContext ctx;

	RpnOperand(VariableType operandType, SimpleGrammarParser.SimpleValueContext ctx) {
		this(operandType, ctx, -1);
	}

	RpnOperand(VariableType operandType, SimpleGrammarParser.SimpleValueContext ctx, int valueStoredInOperation) {
		this.operandType = operandType;
		this.ctx = ctx;
		this.valueStoredInOperation = valueStoredInOperation;
	}

	public VariableType getOperandType() {
		return operandType;
	}

	public int getValueStoredInOperation() {
		return valueStoredInOperation;
	}

	public SimpleGrammarParser.SimpleValueContext getCtx() {
		return ctx;
	}
}

class VariableOperand extends RpnOperand {
	private final Variable variable;

	public VariableOperand(VariableType operandType, SimpleGrammarParser.SimpleValueContext ctx, Variable variable) {
		super(operandType, ctx, variable.getRegisterWithValue());
		this.variable = variable;
	}

	public Variable getVariable() {
		return variable;
	}
}

abstract class NumberOperand extends RpnOperand {
	private final double value;

	public double getValue() {
		return value;
	}

	NumberOperand(VariableType operandType, SimpleGrammarParser.SimpleValueContext ctx, double value) {
		super(operandType, ctx);
		this.value = value;
	}
}

class RealNumberOperand extends NumberOperand {
	RealNumberOperand(SimpleGrammarParser.SimpleValueContext ctx) {
		super(VariableType.REAL, ctx, Double.parseDouble(ctx.Real().toString()));
	}

	RealNumberOperand(double value) {
		super(VariableType.REAL, null, value);
	}
}

class IntegerNumberOperand extends NumberOperand {
	IntegerNumberOperand(SimpleGrammarParser.SimpleValueContext ctx) {
		super(VariableType.INTEGER, ctx, Double.parseDouble(ctx.Int().toString()));
	}

	IntegerNumberOperand(int value) {
		super(VariableType.INTEGER, null, value);

	}
}
