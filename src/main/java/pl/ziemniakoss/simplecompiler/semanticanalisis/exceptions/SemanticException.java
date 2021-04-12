package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class SemanticException extends RuntimeException {
	private final int line;
	private final int column;

	public SemanticException(int line, int column, String message) {
		super(message);
		this.line= line;
		this.column = column;
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public String toString() {
		return "[" + line + ":" + column + "]: " + getMessage();
	}
}
