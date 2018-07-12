package day19;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatExamples2 {
	public static void main(String[] args) {
		LocalDate currentDate = LocalDate.now();    // 컴퓨터의 현재 날짜 정보를 저장한 LocalDate 객체를 리턴한다. 결과 : 2016-04-01 
		LocalDate targetDate = LocalDate.of(2018, 1, 1); 	// 설정 날짜를 yyyy-mm-dd의 형식으로 보여준다.
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd E");	//yyyy MM dd E(요일) 형식 지정
		String text1 = currentDate.format(formatter);	//현재 날짜를 formatter 객체 형식대로 출력한다.
		String text2 = targetDate.format(formatter);	//설정 날짜(2018년1월1일)를 formatter 객체 형식대로 출력한다.
		LocalDate parsedDate = LocalDate.parse("2018 12 25 화", formatter);
		String text3 = parsedDate.format(formatter);	//설정 날짜(2018년12월25일)를 formatter 객체 형식대로 출력한다.
		
		System.out.println(currentDate);
		System.out.println(targetDate);
		System.out.println(text1);
		System.out.println(text2);
		System.out.println(text3);
	}

}
