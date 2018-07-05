package day11;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString()); //날짜 문자열로 표현(표준 날짜,시간 형태)
		System.out.println(d.getTime()); //January 1, 1970, 00:00:00 GMT 이후 시간을 ms 단위로 표현

		GregorianCalendar gc = new GregorianCalendar();
		System.out.println(gc.get(Calendar.DAY_OF_MONTH)); //월
		System.out.println(gc.get(Calendar.DAY_OF_YEAR));  //1월1일부터 몇번째 날인지 리턴
		System.out.println(gc.get(Calendar.DAY_OF_WEEK));  //요일을 숫자로 리턴
		
		GregorianCalendar gc1 = new GregorianCalendar(1987, 6, 23); //실제 월 보다 하나 작은 숫자 써야함
		int day = gc1.get(Calendar.DAY_OF_WEEK);
		String [] str = {"일", "월", "화", "수", "목", "금", "토"};
		System.out.println(str[day-1]);
	}

}
