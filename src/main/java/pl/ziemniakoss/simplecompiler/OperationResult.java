package pl.ziemniakoss.simplecompiler;

public class OperationResult {
	private final int operationNumber;
	private final VariableType type;

	public OperationResult(int operationNumber, VariableType type) {
		this.operationNumber = operationNumber;
		this.type = type;
	}

	public int getOperationNumber() {
		return operationNumber;
	}

	public VariableType getType() {
		return type;
	}
}
