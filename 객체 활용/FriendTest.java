package day12;

class Person1 {
	private String name;
	
	Person1(String name){
		this.name=name;
	}
	public String getInfo() {
		return name;
	}
}

class Friend1 extends Person1{
	private String phoneNum;
	private String email;
	
	Friend1(String name, String phoneNum, String email){
		super(name); //Friend1 객체에서 멤버변수로 선언된 변수들은 super 이용.
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public String getInfo() {
		
		return super.getInfo() + "  " + phoneNum + "  " + email;
	}
}

public class FriendTest {
	public static void main(String[] args) {
		Friend1 [] fr = new Friend1[5];
		fr[0] = new Friend1("홍길동","01012345678","hong@kildong.com");
		fr[1] = new Friend1("고길동","01013572468","ko@kildong.com");
		fr[2] = new Friend1("개길동","01098746523","kae@kildong.com");
		fr[3] = new Friend1("박길동","01074185296","park@kildong.com");
		fr[4] = new Friend1("이길동","01075395162","lee@kildong.com");
		
		System.out.println(" 이름        전화번호               이메일");
		System.out.println("--------------------------------");
		for (Friend1 f : fr) {
			System.out.println(f.getInfo());

		}

	}

}
