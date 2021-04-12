package pl.ziemniakoss.simplecompiler.semanticanalisis.exceptions;

public class MainMethodNotDefinedException extends SemanticException {
	public MainMethodNotDefinedException(String message) {
		super(0, 0, message);
	}
}
