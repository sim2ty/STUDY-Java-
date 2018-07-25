package day21;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 아래의 기능을 가진 프로그램을, 두 개의 스레드 클래스를 Anonymous Inner Local Class 로 변경.

 메인 스레드외에 두 개의 스레드를 더 기동하는 자바 프로그램을 구현해 본다.

 메인 스레드 기능 : 두 개의 스레드를 기동한 다음에 3초에 한번씩 "number of milliseconds since 
                 January 1, 1970, 00:00:00 GMT" 시간을 10번 화면에 출력 

 스레드 1 :  10초에 한 번씩 : "오늘은 XX월 XX일입니다." 를 3번 화면에 출력

 스레드 2 :  5초에 한 번씩 : "X시 X분 X초"를 화면에 5번 출력
*/

public class AnonyThreadLab {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 3 ; i++) {
					Calendar c = Calendar.getInstance();
					System.out.println("오늘은 " + (c.get(Calendar.MONTH)+1) + "월 " + c.get(Calendar.DATE) + "일 입니다.");
					try {
						Thread.sleep(10000);
					} catch(Exception e) {}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 5 ; i++) {
					Date today = new Date();
					SimpleDateFormat time = new SimpleDateFormat("hh시 mm분 ss초");
					System.out.println(time.format(today));
					try {
						Thread.sleep(5000);
					} catch(Exception e) {}
				}
				
			}
		}).start();
		
		for(int i = 0 ; i <10; i++) {
			Date today = new Date();
			System.out.println(today.getTime() + "ms since January 1, 1970, 00:00:00 GMT");
			try {
				Thread.sleep(3000);
			} catch(Exception e) {}
		} 
	}
}


	
