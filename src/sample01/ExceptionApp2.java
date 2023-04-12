package sample01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionApp2 {

	public static void main(String[] args) {
	
		try {
			System.out.println("11111");
			FileReader reader = new FileReader("src/sample01/sample01.txt");
			System.out.println("22222");
			BufferedReader br = new BufferedReader(reader);
			System.out.println("33333");
			String text = br.readLine();
			System.out.println("44444");
			System.out.println(text);
			System.out.println("55555");
			br.close();
		} catch (FileNotFoundException ex){	// 예외가 발생하면 다음 문장을 실행하지 않고 캐치 블록으로 넘어감
			System.out.println("지정된 파일을 찾을 수 없습니다.");
		} catch (IOException ex) {	// 부모 클래스 무조건 아래로 자식 클래스는 위로
			System.out.println("읽기 작업 중 오류가 발생하였습니다.");
		}
		}

}
