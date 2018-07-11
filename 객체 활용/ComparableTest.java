package day18;

import java.util.Arrays;

class Toy implements Comparable<Toy>{
	private String name;
	private int price;
	private int age;
	public Toy(String name, int price, int age) {
		super();
		this.name = name;
		this.price = price;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Toy [name=" + name + ", price=" + price + ", age=" + age + "]";
	}
	public int compareTo(Toy o) {
		int targetPrice = o.getPrice();
		int result = 0;
		if(price<targetPrice)
			result = -1;
		else if(price>targetPrice)
			result = 1;
		return result;
	}
}

public class ComparableTest {
	public static void main(String[] args) {
		Toy[] ary = new Toy[5];
		ary[0] = new Toy("aaa",1000,10);
		ary[1] = new Toy("ccc",2000,12);
		ary[2] = new Toy("bbb",3000,8);
		ary[3] = new Toy("ddd",4000,6);
		ary[4] = new Toy("eee",500,11);
		
		for (Toy t : ary) {
			System.out.println(t);
		}
		System.out.println("---------------------");
		Arrays.sort(ary);
		for(Toy t : ary) {
			System.out.println(t);
		}
	}
}
