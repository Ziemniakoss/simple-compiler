package pl.ziemniakoss.simplecompiler;

import java.util.Objects;

public class Variable {
	private final VariableType type;
	private final String name;

	public Variable(VariableType type, String name) {
		this.type = type;
		this.name = name;
	}

	public VariableType getType() {
		return type;
	}

	public String getName() {
		return name;
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
