package day11;
import java.util.*;
public class KoreanDay {
		public static String day;
		static String korDayName[] = {"", "일", "월", "화", "수", "목", "금", "토"};
		static {
			GregorianCalendar cal = new GregorianCalendar();
			int numDay = cal.get(Calendar.DAY_OF_WEEK);
			day = korDayName[numDay];
		}

}
