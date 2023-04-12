package sample02;

public class CustomExceptionApp2 {
	
	/**
	 * 고객등급과 구매금액을 전달받아서 적립포인트를 반환하는 메서드
	 * @param grade 고객등급
	 * @param amount 구매금액
	 */
	
	// 예외 객체를 쓰는 대부분의 경우 -> 업무 로직상 오류가 있는 지점에서 발생
	// 더 풍부한 오류 정보를 사용자에게 알리기 위해서
	public static int getDepositPoint(String grade, int amount) {
		if (grade == null || grade.isBlank()) {
			throw new CustomException("고객등급 정보가 없습니다.");
		} // 밑에 있는 수행문을 실행하지 않고 즉시 메서드 종료
		
		double depositRate = 0.0;
		if ("골드".equals(grade)) {
			depositRate = 0.05;
		}else if("실버".equals(grade)) {
			depositRate = 0.02;
			
		}else if("브론즈".equals(grade)) {
			depositRate = 0.01;
		}
		
		return (int)(amount*depositRate);
	}
}
