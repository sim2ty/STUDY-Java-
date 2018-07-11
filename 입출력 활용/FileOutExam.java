package day18;

import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 다음과 같은 내용을 추출하여 c:/iotest/today.txt 라는 파일에 저장한다.
 c:/iotest 디렉토리의 존재여부를 채크하고 존재하지 않으면 새로이 생성합니다.  출력 내용은 다음과 같습니다.
 오늘은 2018년 6월 29일입니다. 
 오늘은 금요일입니다.
 XXX는 X요일에 태어났습니다.

 정상적으로 수행되면 화면에 “저장이 완료되었습니다.”
 예외 발생시 화면에 "파일에 저장하는 동안 오류가 발생했습니다."를 출력하는 프로그램을 구현하세요.
*/

public class FileOutExam {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;		//월의 경우 1을 더해줘야 제대로 된 월이 나온다.
		int date = c.get(Calendar.DATE);
		String [] daylist = {"일","월","화","수","목","금","토"};
		int day_today = c.get(Calendar.DAY_OF_WEEK)-1;
		String day = daylist[day_today];
		
		String name = "심태용";
		GregorianCalendar gc = new GregorianCalendar(1987, 6, 23);	//원래 월보다 1 작은 월로 세팅해줘야 한다.
		int day_birthday_int = gc.get(Calendar.DAY_OF_WEEK);
		String day_birthday = daylist[day_birthday_int-1];
		
		String line1 = "오늘은 "+Integer.toString(year)+"년 "+Integer.toString(month)+"월 "+Integer.toString(date)
		+"일입니다.";
		String line2 = "오늘은 "+day+"요일입니다.";
		String line3 = name+"는 "+day_birthday+"요일에 태어났습니다.";
		
		String path = "C:/iotest";
	    File isDir = new File(path);
	    // 해당 디렉토리가 존재하지 않으면 디렉토리 생성
	    if (!isDir.exists()) {
	       	isDir.mkdirs();
	    }
			    
		try (FileWriter FOS = new FileWriter(path+"/today.txt",true);
			 ){
			FOS.write(line1);
			FOS.write("\r\n");
			FOS.write(line2);
			FOS.write("\r\n");
			FOS.write(line3);
			System.out.println("저장이 완료되었습니다.");
		}catch (Exception e) {
	        System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
	 	} 
	}
}
