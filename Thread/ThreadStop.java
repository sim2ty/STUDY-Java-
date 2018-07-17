package day20;

public class ThreadStop {
	public static void main(String[] args)  {
		PrintThread1 printThread = new PrintThread1();
		printThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		
		printThread.setStop(true);
	}
}

class PrintThread1 extends Thread {
	private boolean stop;
	
	public void setStop(boolean stop) {
	  this.stop = stop;
	}
	
	public void run() {	
		while(!stop) {
			System.out.println("실행 중");
		}	
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}