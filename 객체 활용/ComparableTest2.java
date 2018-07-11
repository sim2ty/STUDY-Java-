package day18;

import java.util.Arrays;
import java.util.Comparator;

class Toy2 {
	private String name;
	private int price;
	private int age;
	public Toy2(String name, int price, int age) {
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
		return "Toy2 [name=" + name + ", price=" + price + ", age=" + age + "]";
	}
	
}

public class ComparableTest2 {
	public static void main(String[] args) {
		Toy2[] ary = new Toy2[5];
		ary[0] = new Toy2("aaa",1000,10);
		ary[1] = new Toy2("ccc",2000,12);
		ary[2] = new Toy2("bbb",3000,8);
		ary[3] = new Toy2("ddd",4000,6);
		ary[4] = new Toy2("eee",500,11);
		
		for (Toy2 t : ary) {
			System.out.println(t);
		}
		System.out.println("---------------------");
		Arrays.sort(ary,new MyComparator());
		for(Toy2 t : ary) {
			System.out.println(t);
		}
	}
}

class MyComparator implements Comparator<Toy2>{
	public int compare(Toy2 o1, Toy2 o2) {
		int price1 = o1.getPrice();
		int price2 = o2.getPrice();
		int result = 0;
		if(price1<price2)
			result = -1;
		else if(price1>price2)
			result=1;
		return result;

	}
}