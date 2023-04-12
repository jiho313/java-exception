package sample03;

public class NotEnoughBalanceException extends BankingException {
	
	public NotEnoughBalanceException (String message) {
		super(message);
	}

}
