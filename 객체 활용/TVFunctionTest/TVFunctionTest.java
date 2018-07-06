package day15;

interface Rentable{
	public void rent();
}

class TV{
	private String model;
	private int size;
	private int channel;
	public TV() {}
	public TV(String model, int size, int channel) {
		this.model = model;
		this.size = size;
		this.channel = channel;
	}
	public void channelUp() {
		channel++;
		if(channel>10) {
			channel = 1;
		}
	}
	public void channelDown(){
		channel--;
		if(channel<1) {
			channel = 10;
		}
	}
	public String getModel() {
		return model;
	}
	public int getSize() {
		return size;
	}
	public int getChannel() {
		return channel;
	}
}

class SaleTV extends TV{
	private int price;
	public SaleTV() {}
	public SaleTV(int price, String model, int size, int channel) {
		super(model,size,channel);
		this.price = price;
	}
	public void play() {
		System.out.println("판매 TV 채널 " + getChannel() + "번의 프로를 플레이 합니다.");
	}
	public void sale() {
		System.out.println(getModel() + " 모델의 상품을 판매합니다. " + String.format("%,d", price) + "원 을 지불해 주세요.");
	}
	public String toString() {
		return "판매상품정보 : 모델명(" + getModel() + "), 가격(" + String.format("%,d", price) + "원), 크기(" + getSize() + ")";
	}
}

class RentalTV extends TV implements Rentable{
	private int price;
	public RentalTV() {}
	public RentalTV(int price, String model, int size, int channel) {
		super(model,size,channel);
		this.price = price;
	}
	public void play() {
		System.out.println("대여 TV 채널 " + getChannel() + "번의 프로를 플레이 합니다.");
	}
	public void rent() {
		System.out.println(getModel() + " 모델의 상품을 대여합니다. " + String.format("%,d", price) + "원 을 지불해 주세요.");
	}
	public String toString() {
		return "대여상품정보 : 모델명(" + getModel() + "), 가격(" + String.format("%,d", price) + "원), 크기(" + getSize() + ")";
	}
}

public class TVFunctionTest {
	public static void main(String[] args) {
		//SaleTV, RentalTV 클래스의 객체를 각각 생성한다.
		SaleTV s = new SaleTV(300000,"SALETV-1",40,1);
		RentalTV r = new RentalTV(100000,"RENTALTV-10",42,1);
		//SaleTV 객체는 채널을 두 개 높인다.
		s.channelUp(); s.channelUp();
		//RentalTV 객체는 채널을 세 개 내린다.
		r.channelDown(); r.channelDown(); r.channelDown();
		//각 객체에 대하여 printAllTV()을 호출한다.
		printAllTV(s);
		printAllTV(r);
		//Rentable 타입의 객체인 RentalTV 객체는 printRentalTV() 를 호출한다.
		printRentalTV(r);
	}
	
	static void printAllTV(TV tv) {
		// 아규먼트로 전달된 객체의 toString() 을 호출하여 각 상품의 정보를 출력한다.
		System.out.println(tv.toString());
		// 아규먼트로 전달된 객체의 play() 를 호출한다.
		// tv 변수에 전달된 객체가 SaleTV 타입이면 sale() 메서드를 호출한다.
		if (tv instanceof SaleTV) { 
			((SaleTV) tv).play();
			((SaleTV) tv).sale();
		}
		else if (tv instanceof RentalTV) 
			((RentalTV) tv).play();
	}	
	static void printRentalTV(Rentable tv) {
		// 아규먼트로 전달된 Rentable 객체의 rent() 메서드를 호출한다.
		tv.rent();
	}

}
