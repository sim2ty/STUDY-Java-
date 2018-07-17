package day20;

public class Thread_Sum {
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~1000 합: " + sumThread.getSum());
	}
}

class SumThread extends Thread {	
	private long sum;
	
	public long getSum() {
		return sum;
	}

	public void setSum(long sum) {
		this.sum = sum;
	}

	public void run() {
		for(int i=1; i<=1000; i++) {
			sum+=i;
		}
	}
}