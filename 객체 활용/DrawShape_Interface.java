package day14;

interface IShape{
	public static String color = "빨간색";
	public abstract void draw();
}

class Circle implements IShape{
	private String type;
	public Circle(String type) {
		this.type = type;
	}
	public void draw() {
		System.out.println(getClass().getName() + "에서 " + color + "으로 " + type + "을 그립니다.");
	}
}

class Rect implements IShape{
	private String type;
	public Rect(String type) {
		this.type = type;
	}
	public void draw() {
		System.out.println(getClass().getName() + "에서 " + color + "으로 " + type + "을 그립니다.");
	}
}

public class DrawShape_Interface {
	public static void main(String[] args) {
		IShape[] is = new IShape[2];
		is[0] = new Circle("원");
		is[1] = new Rect("사각형");
		for(IShape r : is) {
			r.draw();
		}
	}
}
