package day14.case2;

interface TV1 {
	public void powerOn();
	public void powerOff();
	public void volumnUp();
	public void volumnDown();
}

class LgTV1 implements TV1 {
	public void powerOn(){
		System.out.println("LgTV --- 전원을 켠다.");
	}
	public void powerOff(){
		System.out.println("LgTV --- 전원을 끈다.");
	}
	public void volumnUp(){
		System.out.println("LgTV --- 소리를 높인다.");
	}
	public void volumnDown(){
		System.out.println("LgTV --- 소리를 낮춘다.");
	}
}

class SamsungTV1 implements TV1{
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

public class TVBasicFunction_Interface1 {
	public static void main(String[] args) {
		TV1 tv = new LgTV1();
		tv.powerOn();
		tv.volumnUp();
		tv.volumnDown();
		tv.powerOff();
	}
}
