package day17;

public class AutoBoxingUnBoxing {
	public static void main(String[] args) {
		int num=100;
		Integer obj = new Integer(10);
		obj = num; 				//기본 --> 객체 (AutoBoxing)
		int result = obj + 10; 	//객체 --> 기본 (AutoUnBoxing)
		System.out.println(result);
	}
}
