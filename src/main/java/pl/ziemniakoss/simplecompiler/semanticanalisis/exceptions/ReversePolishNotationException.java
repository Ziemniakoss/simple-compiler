package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class ReversePolishNotationException extends SemanticException{
	public ReversePolishNotationException(int line, int column, String message) {
		super(line, column, message);
	}
}
