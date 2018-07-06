package day14.case1;

class LgTV {
	public void turnOn(){
		System.out.println("LgTV --- 전원을 켠다.");
	}
	public void turnOff(){
		System.out.println("LgTV --- 전원을 끈다.");
	}
	public void soundUp(){
		System.out.println("LgTV --- 소리를 높인다.");
	}
	public void soundDown(){
		System.out.println("LgTV --- 소리를 낮춘다.");
	}
}

class SamsungTV {
	public void powerOn(){
		System.out.println("SamsungTV --- 전원을 켠다.");
	}
	public void powerOff(){
		System.out.println("SamsungTV --- 전원을 끈다.");
	}
	public void volumnUp(){
		System.out.println("SamsungTV --- 소리를 높인다.");
	}
	public void volumnDown(){
		System.out.println("SamsungTV --- 소리를 낮춘다.");
	}
}

public class TVBasicFunction_Class {
	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}
}

