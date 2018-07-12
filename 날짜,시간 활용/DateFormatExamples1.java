package day19;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExamples1 {
	public static String timeToStrDate(long time) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	// Date 표현 형식 지정.
		return formatter.format(time);
	}

	public static Date parseStrDate(String strDate) throws ParseException {	//설정 날짜에서 년,월,일 숫자 요소를 추출하여 표준형식으로 출력.
		DateFormat formatter = new SimpleDateFormat("yyyy년 MM월 dd일");
		return formatter.parse(strDate);
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(timeToStrDate(new Date().getTime()));
		System.out.println(parseStrDate("2018년 01월 01일")); 		
	}
}
