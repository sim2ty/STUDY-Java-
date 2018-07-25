package day21;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

interface ThrLab2 extends Runnable{
}

public class AnonyThreadLab2 {
	void start(ThrLab2 thl2) {
		Thread th = new Thread(thl2);
		th.start();
	}
	
	public static void main(String[] args) {
		AnonyThreadLab2 anony = new AnonyThreadLab2();
		anony.start(new ThrLab2() {
			public void run() {
				for (int i = 0; i < 3 ; i++) {
					Calendar c = Calendar.getInstance();
					System.out.println("오늘은 " + (c.get(Calendar.MONTH)+1) + "월 " + c.get(Calendar.DATE) + "일 입니다.");
					try {
						Thread.sleep(10000);
					} catch(Exception e) {}
				}
			}
		});
				
		
		
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


	
