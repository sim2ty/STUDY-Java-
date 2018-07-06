package mobile;

abstract class Mobile{
	private String mobileName;
	private int batterySize;
	private String osType;
	
	Mobile(){
	}
	Mobile(String mobileName, int batterySize, String osType){
		this.mobileName = mobileName;
		this.batterySize = batterySize;
		this.osType = osType;
	}
	abstract void operate(int time);
	abstract void charge(int time);
	
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public int getBatterySize() {
		return batterySize;
	}
	public void setBatterySize(int batterySize) {
		this.batterySize = batterySize;
	}
	public String getOsType() {
		return osType;
	}
	public void setOsType(String osType) {
		this.osType = osType;
	}
}

class Ltab extends Mobile{
	Ltab(){}
	Ltab(String mobileName, int batterySize, String osType){
		super(mobileName, batterySize, osType);
	}
	void operate(int time) {
		setBatterySize(getBatterySize() - (time*10));
	}
	void charge(int time) {
		setBatterySize(getBatterySize() + (time*10));
	}
}

class Otab extends Mobile{
	Otab(){}
	Otab(String mobileName, int batterySize, String osType){
		super(mobileName, batterySize, osType);
	}
	void operate(int time) {
		setBatterySize(getBatterySize() - (time*12));
	}
	void charge(int time) {
		setBatterySize(getBatterySize() + (time*8));
	}
}

public class MobileTest {
	public static void main(String[] args) {
		// 각각의 Mobile 객체를 생성하여 Mobile 배열에 저장한다.
		Mobile [] mobile = new Mobile[2];
		mobile[0] = new Ltab("LTab", 500, "ABC-01");
		mobile[1] = new Otab("OTab", 1000, "XYZ-20");
		// 생성된 객체의 정보를 출력한다.(printMobile() 호출)
		printTitle();
		printMobile(mobile);
		System.out.println();
		// 각각의 Mobile 객체에 10분씩 충전을 한다.
		for (int i = 0; i < mobile.length; i++) {
			mobile[i].charge(10);
		}
		// 10분 충전 후 객체 정보를 출력한다.(printMobile() 호출)
		System.out.println("[10분 충전]");
		printTitle();
		printMobile(mobile);
		System.out.println();
		// 각각의 Mobile 객체에 5분씩 통화를 한다.
		for (int i = 0; i < mobile.length; i++) {
			mobile[i].operate(5);
		}
		// 5분 통화 후 객체 정보를 출력한다.(printMobile() 호출)
		System.out.println("[5분 통화]");
		printTitle();
		printMobile(mobile);
	}
	public static void printMobile(Mobile[] mobile) {
		for (int i = 0; i < mobile.length; i++) {
			System.out.println(mobile[i].getMobileName()+"\t "+mobile[i].getBatterySize()+"\t\t"+mobile[i].getOsType());
		}
	}
	public static void printTitle() {
		System.out.println("Mobile \t Battery \t OS");
		System.out.println("------------------------------------------");
	}

}
