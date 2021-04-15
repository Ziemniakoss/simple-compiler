package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class InvalidFunctionCallException extends SemanticException{
	public InvalidFunctionCallException(int line, int column, String message) {
		super(line, column, message);
	}
}
