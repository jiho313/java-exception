package sample01;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionApp4 {
	
	public static void test2(String str) {
		test1(str);
	}
	
	public static void test1(String str) {	// 언체크드 인섹션은 throws키워드 없이도 호출자에게 자동으로 위임
		int number = Integer.parseInt(str);
		System.out.println("number -> " + str);
	}
	
//	public static void test1() throws IOException, ClassNotFoundException {
//		System.out.println("예외처리 위임하기 연습");
//		test2();
//	}
//	
//	public static void test2() throws IOException, ClassNotFoundException {
//		System.out.println("예외처리 위임하기 연습");
//		test3();
//	}
//	
//	public static void test3() throws IOException, ClassNotFoundException {
//		System.out.println("예외처리 위임하기 연습");
//		test4();
//	}
//	
//	public static void test4() throws IOException, ClassNotFoundException {
//		FileWriter writer = new FileWriter("src/sample01/sample04.txt");
//		writer.write("파일쓰기 연습");
//		writer.close();
//	}
	
	public static void main(String[] args) {
		
		try { // 최종으로 메인에서 호출한 곳에서 예외 처리를 한다. 언체크드 인셉션
			test2("1234");
			test2("1234오");
		} catch(NumberFormatException ex) {
			System.out.println("유요한 숫자 형식의 문자열이 아닙니다.");
		}
		
	}

}
