package work;

abstract class Plane{
	private String planeName;
	private int fuelSize;
	public Plane() {}
	public Plane(String planeName, int fuelSize) {
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public int getFuelSize() {
		return fuelSize;
	}
	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}
	public void refuel(int fuel) {
		fuelSize += fuel;
	}
	public abstract void flight(int distance);
}

class Airplane extends Plane{
	public Airplane(){}
	public Airplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	public void flight(int distance) {
		setFuelSize(getFuelSize()-distance*3);
	}
}

class Cargoplane extends Plane{
	public Cargoplane(){}
	public Cargoplane(String planeName, int fuelSize){
		super(planeName, fuelSize);
	}
	public void flight(int distance) {
		setFuelSize(getFuelSize()-distance*5);
	}
}

public class PlaneTest {
	public static void main(String[] args) {
		// Airplane과 Cargoplane 객체 생성
		Airplane air = new Airplane("L747", 1000);
		Cargoplane cargo = new Cargoplane("C40", 1000);
		// 생성된 객체의 정보 출력
		printTitle();
		printInfo(air);
		printInfo(cargo);
		System.out.println();
		// Airplane과 Cargoplane 객체에 100씩 운항 후 객체 정보 출력
		air.flight(100);
		cargo.flight(100);
		System.out.println("[100 운항]");
		printTitle();
		printInfo(air);
		printInfo(cargo);
		System.out.println();
		// Airplane과 Cargoplane 객체에 200 주유 후 객체 정보 출력
		air.refuel(200);
		cargo.refuel(200);
		System.out.println("[200 주유]");
		printTitle();
		printInfo(air);
		printInfo(cargo);
	}
	
	public static void printInfo(Plane list) {
		// Plane 객체의 데이터 출력(출력 결과 참조)
		System.out.println(list.getPlaneName() + "\t " + list.getFuelSize());
		}
	public static void printTitle() {
		// 타이틀 출력
		System.out.println("Plane \t fuelSize");
		System.out.println("-----------------");
		}

}
