package pl.ziemniakoss.simplecompiler.llvmgeneration;

import org.antlr.v4.runtime.ParserRuleContext;
import pl.ziemniakoss.simplecompiler.Function;
import pl.ziemniakoss.simplecompiler.Variable;
import pl.ziemniakoss.simplecompiler.VariableType;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LlvmCodeGeneratorState {
	private final Map<String, Function> functionNameToDefinition = new HashMap<>();
	private final StringBuilder llvmCode = new StringBuilder();
	private final Stack<Map<String, Variable>> variableContexts = new Stack<>();

	public Stack<Map<String, Integer>> getLabelsStack() {
		return labelsStack;
	}

	private final Stack<Map<String, Integer>> labelsStack = new Stack<>();
	public int nextOperationIndex = 1;
	public int indent = 0;
	private final Map<ParserRuleContext, Integer> contextToOperationWithResult = new HashMap<>();
	private final Map<Integer, VariableType> operationIndexToStoredValueType = new HashMap<>();
	private VariableType currentlyDefinedFunctionReturnType;

	public LlvmCodeGeneratorState() {
		functionNameToDefinition.put("readInt", new Function("readInt", VariableType.INTEGER, new VariableType[0]));
		functionNameToDefinition.put("readReal", new Function("readReal", VariableType.REAL, new VariableType[0]));

		functionNameToDefinition.put("writeInt", new Function("writeInt", VariableType.INTEGER, new VariableType[]{VariableType.INTEGER}));
		functionNameToDefinition.put("writeReal", new Function("writeReal", VariableType.INTEGER, new VariableType[]{VariableType.REAL}));
	}


	public boolean isVariableDefined(String variableName) {
		for (var context : variableContexts) {
			if (context.containsKey(variableName)) {
				return true;
			}
		}
		return false;
	}

	public Variable getVariable(String variableName) {
		for (var context : variableContexts) {
			if (context.containsKey((variableName))) {
				return context.get(variableName);
			}
		}
		return null;
	}

	public boolean isGlobalContext() {
		return variableContexts.size() == 0;
	}
	public Map<String, Function> getFunctionNameToDefinition() {
		return functionNameToDefinition;
	}

	public StringBuilder getLlvmCode() {
		return llvmCode;
	}

	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}

	public Map<Integer, VariableType> getOperationIndexToStoredValueType() {
		return operationIndexToStoredValueType;
	}

	public VariableType getCurrentlyDefinedFunctionReturnType() {
		return currentlyDefinedFunctionReturnType;
	}

	public void setCurrentlyDefinedFunctionReturnType(VariableType currentlyDefinedFunctionReturnType) {
		this.currentlyDefinedFunctionReturnType = currentlyDefinedFunctionReturnType;
	}

	public Stack<Map<String, Variable>> getVariableContexts() {
		return variableContexts;
	}

	public Map<ParserRuleContext, Integer> getContextToOperationWithResult() {
		return contextToOperationWithResult;
	}

	public int getLabel(String labelName) {
		return labelsStack.peek().get(labelName);
	}

	public void setLabel(String labelName, int operationNumber) {
		labelsStack.peek().put(labelName, operationNumber);
	}

	public StringBuilder newLineAndIdent() {
		this.getLlvmCode().append('\n');
		for (int i = 0; i < indent; i++) {
			this.getLlvmCode().append('\t');
		}
		return this.getLlvmCode();
	}
}
