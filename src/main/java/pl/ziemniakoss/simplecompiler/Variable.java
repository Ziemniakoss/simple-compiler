package pl.ziemniakoss.simplecompiler;

import java.util.Objects;

public class Variable {
	private final VariableType type;
	private final String name;
	private final int registerWithValue;
	private final boolean pointer;

	public Variable(VariableType type, String name) {
		this(type, name, -1);
	}

	public Variable(VariableType type, String name, int registerWithValue) {
		this(type, name, registerWithValue, true);
	}

	public Variable(VariableType type, String name, int registerWithValue, boolean pointer) {
		this.type = type;
		this.name = name;
		this.registerWithValue = registerWithValue;
		this.pointer = pointer;
	}

	public VariableType getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public int getRegisterWithValue() {
		return registerWithValue;
	}

	public boolean isPointer() {
		return pointer;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Variable variable = (Variable) o;
		return Objects.equals(name, variable.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
