package sample03;

public class BankingException extends RuntimeException {
	/*
	 * BankingException처럼 은행 관련 예외들의 부모가 되는 예외 클래스를 만드는 이유
	 * 예외의 종류를 구분해서 각각 다르게 표시하게 하기 위해
	 */
	public BankingException () {}
	
	public BankingException(String message) {
		super(message);
	}
	
}
