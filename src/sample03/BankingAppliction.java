package sample03;

import util.KeyboardReader;

public class BankingAppliction {
	
	// 적절한 예외를 발생시켜서 최종 호출에서 일괄처리하는 게 목적
	private KeyboardReader reader = new KeyboardReader();
	private BankingService service = new BankingService();
	
	public void menu() {
		System.out.println("--------------------------------------------");
		System.out.println("1.조회   2.입금   3.출금   0.종료");
		System.out.println("--------------------------------------------");
		System.out.println();
		
		// BankingException류 예외 일괄 처리
		System.out.print("### 메뉴선택> ");
		int menuNo = reader.readInt();
		System.out.println();
		try {
			if(menuNo == 1) {
				조회하기();
			} else if (menuNo == 2) {
				입금하기();
			} else if (menuNo == 3) {
				출금하기();
			} else if (menuNo == 0) {
				종료하기();
			}
			// menu(); 오류 발생과 상관없이 계속 실행되어야 하기 때문에  try문 밖으로 적는다.
		} catch (BankingException ex) {
			System.out.println("### 오류 발생: " + ex.toString());
//			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("### 오류 발생: 알 수 없는 오류가 발생하였습니다.");
//			ex.printStackTrace();
		}
		System.out.println();
		System.out.println();
		System.out.println();

		menu();
	}
	
	private void 조회하기() {
		System.out.println("<< 계좌정보 조회하기 >>");
		System.out.println("### 계좌번호와 비밀번호를 입력하세요.");
		
		System.out.print("### 계좌번호: ");
		int no = reader.readInt();
		System.out.print("### 비밀번호: ");
		int password = reader.readInt();
		System.out.println();
		
		Account account = service.getAccountDetail(no, password);
		System.out.println("### 계좌상세 정보 출력");
		System.out.println("-------------------------------------");
		System.out.println("계좌번호: " + account.getNo());
		System.out.println("예금주: " + account.getOwner());
		System.out.println("현재잔액: " + account.getBalance());
		System.out.println("-------------------------------------");
		
		
	}
	
	private void 입금하기() {
		System.out.println("<< 입금하기 >>");
		System.out.println("### 계좌번호와 입금액을 입력하세요.");
		
		System.out.print("### 계좌번호: ");
		int no = reader.readInt();
		System.out.print("### 입금액: ");
		long amount = reader.readLong();
		System.out.println();
		
		service.deposit(no, amount);
		System.out.println("### 입금이 완료되었습니다.");
	}
	
	private void 출금하기() {
		System.out.println("<< 출금하기 >>");
		System.out.println("### 계좌번호, 비밀번호, 출금액을 입력하세요.");
		
		System.out.print("### 계좌번호: ");
		int no = reader.readInt();
		System.out.print("### 비밀번호: ");
		int password = reader.readInt();
		System.out.print("### 출금액: ");
		long amount = reader.readLong();
		System.out.println();
		
		service.withdraw(no, password, amount);
		System.out.println("### 출금이 완료되었습니다.");
	}
	
	private void 종료하기() {
		System.out.println("<< 프로그램 종료 >>");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		BankingAppliction app = new BankingAppliction();
		app.menu();
	}
	
}
