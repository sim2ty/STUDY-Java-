package day14;

//각 도형 클래스가 상속할 추상클래스 Shape 선언
abstract class Shape{
	String color;
	abstract void draw();
	void setColor(String color) {
		this.color = color;
	}
}

class Circle2 extends Shape{
	void draw() {
		System.out.println(color + " 원을 그리는 기능");
	}
}

class Rectangle2 extends Shape{
	void draw() {
		System.out.println(color + " 사각형을 그리는 기능");
	}
}

class Triangle2 extends Shape{
	void draw() {
		System.out.println(color + " 삼각형을 그리는 기능");
	}
}

public class DrawShape_AbstractClass {
	public static void main(String[] args) {
		Shape s = new Circle2();
		s.setColor("파란색");
		printInfo(s);
		s = new Rectangle2();
		s.setColor("분홍색");
		printInfo(s);
		s = new Triangle2();
		s.setColor("연두색");
		printInfo(s);
	}
	
	static void printInfo(Shape obj) {
		obj.draw();
	}
	

}
