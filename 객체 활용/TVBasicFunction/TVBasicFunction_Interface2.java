package day14.case3;

interface TV2 {
	public void powerOn();
	public void powerOff();
	public void volumnUp();
	public void volumnDown();

}

//TV제조사에 따라 생성하는 객체가 달라지도록 코드 작성
class TVFactory2 {
	public static TV2 getTV(String beanName){
		TV2 obj = null;
		if(beanName.equals("samsung")){
			obj = new SamsungTV2();
		} else if(beanName.equals("lg")){
			obj = new LgTV2();
		}
		return obj;
	}

}

class LgTV2 implements TV2 {
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

class SamsungTV2 implements TV2{
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

public class TVBasicFunction_Interface2 {
	public static void main(String[] args) {	
		TV2 tv = TVFactory2.getTV(args[0]);
		if(tv != null) {
			tv.powerOn();
			tv.volumnUp();
			tv.volumnDown();
			tv.powerOff();
		} else {
			System.out.println("프로그램 아규먼트로 samsung 또는 lg 를 입력해 주세요..");
		}
	}
}
