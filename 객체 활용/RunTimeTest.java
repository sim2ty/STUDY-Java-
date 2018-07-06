package day13;
public class RunTimeTest {
	public static void main(String[] args) throws Exception{
//		Runtime obj = new Runtime();			               //Runtime객체는 new 이용 X
		Runtime obj = Runtime.getRuntime();                    //다른 프로그램 실행시 Runtime 객체선언
		obj.exec("C:\\Windows\\notepad.exe");	               //(1)notepad 실행
//		Runtime.getRuntime().exec("C:\\Windows\\notepad.exe"); //(2)이렇게 실행해도 됨
		obj.gc();                                              //garbage collector 구동
		Runtime obj2 = Runtime.getRuntime();
		Runtime obj3 = Runtime.getRuntime();
//		System.out.println(obj);
//		System.out.println(obj2);
//		System.out.println(obj3);
	}

}
