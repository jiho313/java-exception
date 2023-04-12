package sample02;

/**
 *  사용자 정의 예외 Unchecked클래스다.
 * @author jhta
 *
 */
public class CustomException extends RuntimeException {

	public CustomException (String message) {
		super(message);
	}
	
	public CustomException(String message, Throwable  cause) {
		super(message, cause);
	}
	
	
}
