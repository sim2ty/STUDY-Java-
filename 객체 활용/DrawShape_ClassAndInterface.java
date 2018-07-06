package day14;

interface Printable {
	public static final int PRINT_TYPE1 = 1;
	static final int PRINT_TYPE2 = 2;
	final int PRINT_TYPE3 = 3;
	int PRINT_TYPE4 = 4;
	
	public abstract void print(int type);
	abstract void setPage(int su);
	boolean isAvailable();
}

abstract class Shape3 {
	String color;
	abstract void draw();
	void setColor(String color) {
		this.color = color;
	}
}

class Circle3 extends Shape3 implements Printable {
	int page;
	void draw() {
		System.out.println(color + " 원을 그리는 기능");
	}
	public void print(int type) {
		System.out.println(type + "번 방식으로 " + page + "페이지를 프린팅한다.");
	}
	public void setPage(int page) {
		this.page = page;
	}
	public boolean isAvailable() {
		if (color.equals("파란색"))
			return true;
		else
			return false;
	}
}

class Rectangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 사각형을 그리는 기능");
	}
}

class Triangle3 extends Shape3 {
	void draw() {
		System.out.println(color + " 삼각형을 그리는 기능");
	}
}

public class DrawShape_ClassAndInterface {
	public static void main(String args[]) {
		printOut(new Circle3());
		// printOut(new Rectangle3()); 			// 컴파일 오류가 발생하는 행
												// (Printable 인터페이스를 상속하고 있지 않으므로)
	}

	static void printOut(Printable prt) {
		prt.setPage(100);
//		prt.setColor("파란색");
		if (prt instanceof Shape3)				// prt가 Shape3 타입이면
			((Shape3) prt).setColor("파란색");	// prt를 Shape3 타입으로 강제 형변환하여 setColor메서드 호출
		if (prt.isAvailable())
			prt.print(Printable.PRINT_TYPE2);
	}
}
