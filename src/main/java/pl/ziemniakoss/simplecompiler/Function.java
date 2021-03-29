package pl.ziemniakoss.simplecompiler;

public class Function {
	private String name;
	private VariableType returnType;
	private VariableType[] argumentsTypes;

	public Function(String name, VariableType returnType, VariableType[] argumentsTypes) {
		this.name = name;
		this.returnType = returnType;
		this.argumentsTypes = argumentsTypes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VariableType getReturnType() {
		return returnType;
	}

	public void setReturnType(VariableType returnType) {
		this.returnType = returnType;
	}

	public VariableType[] getArgumentsTypes() {
		return argumentsTypes;
	}

	public void setArgumentsTypes(VariableType[] argumentsTypes) {
		this.argumentsTypes = argumentsTypes;
	}
}
