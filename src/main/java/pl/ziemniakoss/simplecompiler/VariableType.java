package pl.ziemniakoss.simplecompiler;

public enum VariableType {
	INTEGER,
	REAL;

	@Override
	public String toString() {
		return this == INTEGER ? "i32" : "double";
	}
}
