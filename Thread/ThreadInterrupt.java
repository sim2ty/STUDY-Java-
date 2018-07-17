package day20;

public class ThreadInterrupt {
	public static void main(String[] args)  {
		Thread thread = new PrintThread2();
		thread.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		
		thread.interrupt(); // 해당 Thread에게 인터럽트execption을 발생시킨다.
	}
}

class PrintThread2 extends Thread {
	public void run() {	
		// 방법 1
		try {
			while(true) {
				System.out.println("실행 중");
				Thread.sleep(10000); 			//이 코드가 없으면 인터럽트를 못받는다. (sleep 상태여야 인터럽트를 받을 수 있다.)
			}	
		} catch(InterruptedException e) {	
			
		}
		
		// 방법 2
		/*while(true) {
			System.out.println("실행 중");
			if(Thread.interrupted()) {			
				System.out.println("인터럽트!!!");
				break;
			}
		}*/
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
	}
}

