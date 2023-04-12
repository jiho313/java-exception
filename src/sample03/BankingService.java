package sample03;

public class BankingService {
	// 예외들을 최종 호출자에게 던지고 있다.
	/**
	 * 계좌정보에 대한 추가/조회/변경/삭제 기능을 제공하는 객체를 참조한다. 
	 */
	private BankingRepository repo = new BankingRepository();
	
	/**
	 * 계좌번호와 비밀번호를 전달받아서 계좌정보를 반환한다.
	 * @param no 계좌번호
	 * @param password 비밀번호
 	 * @return 계좌정보
	 */
	public Account getAccountDetail(int no, int password) {
		Account account = repo.getAccountByNo(no);
		if(account == null) {
			throw new AccountNotFoundException(String.valueOf(no));
		}	// return문과 같이 빠른 종료 -> 예외 발생
		
		if(account.getPassword() != password) {
			throw new PasswordMismatchException(); // 클래스 이름에서 오류 메세지를 나타냈기 때문에 특별히 메세지를 출력하는 메서드가 필요없는 예외 객체
		}
		
		return account;
	}
	
	/**
	 * 계좌번호, 입금액을 전달받아서 계좌의 현재 잔액을증가시킨다.
	 * @param no 계좌번호
	 * @param amount 입금액
	 */
	public void deposit(int no, long amount) {
		Account account = repo.getAccountByNo(no);
		if (account == null) {
			throw new AccountNotFoundException(String.valueOf(no));
		}
		account.setBalance(account.getBalance() + amount);
	}
	
	/**
	 * 계좌번호, 비밀번호, 출금액을 전달받아서 계좌의 현재 잔액을 감소시킨다.
	 * @param no
	 * @param password
	 * @param amount
	 */
	
	
	public void withdraw(int no, int password, long amount) {
		Account account = repo.getAccountByNo(no);
		if(account == null) {
			throw new AccountNotFoundException(String.valueOf(no));
		}
		if (account.getPassword() != password) {
			throw new PasswordMismatchException();
		}
		if (account.getBalance() < amount) {
			String message = "현재잔액: " + account.getBalance() + ", 출금액: " + amount;
			throw new NotEnoughBalanceException(message);
		}
		account.setBalance(account.getBalance() - amount );
		
		
	}
}
