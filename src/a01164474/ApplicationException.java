package a01164474;

/**
 * Project: Lab3
 * @author Nathan de Souza - A01164474
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	public ApplicationException() {
		super();
	}
	
	public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(Throwable cause) {
		super(cause);
	}
}
