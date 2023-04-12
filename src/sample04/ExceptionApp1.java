package sample04;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp1 {

	public static void writeText1(String text) {
		
		FileWriter writer = null;
		try {
			writer = new FileWriter("src/sample04/smaple.text");
			writer.write("연습1");
			// 입출력 작업이 모두 완료되면, 자원에 대한 점유를 해제시키는 메서드를 실행한다.
			writer.close();
		} catch (IOException ex) {
			try {
				if (writer != null) {
					// 입출력 작업 중 오류가 발생하면, 자원에 대한 점유를 해제시키는 메서드를 실행한다.
					writer.close();
				}
			} catch (IOException e) {
				
			}
			throw new RuntimeException("입출력오류", ex);
		}
	}
	
	public static void writerText2(String text) {
		
		FileWriter writer = null;
		try {
			writer = new FileWriter("src/sample04/sample.text");
			writer.write("연습2");
		} catch (IOException ex) {
			throw new RuntimeException("입출력오류", ex);
		} finally {
			// finally 블록은 예외 발생 유무와 상관없이 반드시 실행되어야 하는 수행문을 작성하는 블록이다.
			// finally 블록에서 점유했던 자원을 해제시키는 메서드를 작성한다.
			try {
				if(writer != null) {
					writer.close();
				}
			} catch (IOException ex) {}
		}
	}
	
	public static void writeText3(String text) {
		// AutuCloseable 인터페이스를 구현한 클래스는 자동자원해제 방식을 사용할 수 있다.
		/*
		 * try (AutoCloseable 인터페이스를 구현한 객체를 생성하는 코드) {
		 * 		- 위에 괄호에서 객체 생성 후 위의 변수명을 블록에서 사용가능
		 * } catch (예외클래스 변수명){
		 * 		throw new 언체크드 익셉션
		 * }
		 */
		try(FileWriter writer = new FileWriter("src/smaple04/smaple.txt")){
			writer.write("연습2");
			writer.write("연습2");
			writer.write("연습2");
			writer.write("연습2");
		} catch (IOException ex) {
			throw new RuntimeException("입출력오류", ex);
		}
		
	}
}
