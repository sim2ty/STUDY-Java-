package day13;

public class PolyTest {

	public static void main(String[] args) {
		
		printObjectInfo(new Object());
		printObjectInfo(new String("가나다"));
		printObjectInfo("ABC");
		printObjectInfo(new java.util.Date());
		printObjectInfo(new java.io.File("c:\\"));
		printObjectInfo(new int[10]);
		printObjectInfo(new Integer(100));
		printObjectInfo(new day10.Student());

	}
	
	static void printObjectInfo(Object o) {
		if(o instanceof String) {
			System.out.println("문자열 객체가 전달됨" + o.toString() + "-" + ((String)o).length());
		}else {
			System.out.println("전달된 객체의 클래스명 : " + o.getClass().getName());
		}
	}

}
