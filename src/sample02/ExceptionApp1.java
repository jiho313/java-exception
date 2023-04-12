package sample02;

public class ExceptionApp1 {
	
	/**
	 * 문자열을 전달받아서 정수로 변환해서 반환한다.
	 * @param text 숫자로 구성된 문자열
	 * @return 정수값
	 */
	public static int toInt(String text) {
		int number = Integer.parseInt(text);
		return number;
	}
	
	public static void main(String[] args) {
		// Throwable 클래스에서 정의된 메서드들
		try {
			int value = toInt("1234가");
			System.out.println(value);
		} catch (NumberFormatException ex) { //main에서 예외를 가로채서 jvm까지 전해지지 않아 에러 메세지를 출력하지 않는다.
			String errorMessage = ex.getMessage();
			System.out.println("오류 메세지 -> " + errorMessage);
			
			String text = ex.toString();
			System.out.println("toString() -> " + text); //예외가 발생한 메세지와 오류메세지 출력
			
			ex.printStackTrace(); // 모두 출력 실제 개발 단계의 try ~ catch에서 이 메서드를 실행하는 게 좋음.
		}
	
	}

}
