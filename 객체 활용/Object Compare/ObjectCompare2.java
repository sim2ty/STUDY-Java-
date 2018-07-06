package day16;

class Member2{
	private int id;
	private String name;
	private String password;
	Member2(int id, String name, String password){
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public boolean equals(Object o) {
		if(o != null && o instanceof Member2) {
			Member2 m = (Member2) o;
			if(id == m.id && name.equals(m.name) && password.equals(m.password))
				return true;
		}
		return false;
	}
}

public class ObjectCompare2 {
	public static void main(String[] args) {
		Member2 obj1 = new Member2(10,"자바","duke");
		Member2 obj2 = new Member2(10,"자바","duke");
		Member2 obj3 = new Member2(20,"자바","duke");

		System.out.println(obj1.equals(obj2));					//true
		System.out.println(obj1==obj2);							//false
		System.out.println(obj1.equals(null));					//false
		System.out.println(obj1.equals(new java.util.Date()));	//false
		System.out.println(obj1.equals(obj3));					//false
	}
}
