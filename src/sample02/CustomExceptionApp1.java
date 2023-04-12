package sample02;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomExceptionApp1 {

	public static void writeText(String text) {
		try {
			FileWriter writer = new FileWriter("src/sample02/sample.txt");
			writer.write(text);
			writer.close();
		} catch (IOException ex){ // Checked Exception을 가로채서
			throw new CustomException("읽고 쓰기 오류", ex); // Unchecked Exception을 물려받은 객첼 전환함
		}
	}
	
	public static Date toDate(String text) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM=dd");
			Date date = sdf.parse(text);
			return date;
		} catch (ParseException ex) {
			throw new CustomException("파싱 오류", ex);
		}
	}
	
	public static void main(String[] args) {
		try {
			writeText("사용자 정의 예외객체 사용하기");
			Date date = toDate("2023-4-");
			System.out.println(date);
		} catch(CustomException ex) {
			ex.printStackTrace();
		}
		
	}
}
