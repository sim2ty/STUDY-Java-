package day17;

import java.util.LinkedList;

class Person {
	private String name;
	
	public Person(String name){
		this.name=name;
	}
	public String getInfo() {
		return name;
	}
}

class Friend extends Person{
	private String phoneNum;
	private String email;
	
	public Friend(String name, String phoneNum, String email){
		super(name); //Friend 객체에서 멤버변수로 선언된 변수들은 super 이용.
		this.phoneNum = phoneNum;
		this.email = email;
	}
		
	public String getInfo() {
		return super.getInfo() + "  " + phoneNum + "  " + email;
	}
}

public class FriendTestLinkedList {
	public static void main(String[] args) {
		LinkedList<Friend> lst = new LinkedList<>();
		
		lst.add(new Friend("홍길동", "01012345678", "hong@kildong.com"));
		lst.add(new Friend("고길동", "01013572468", "ko@kildong.com"));
		lst.add(new Friend("개길동", "01098746523", "kae@kildong.com"));
		lst.add(new Friend("박길동", "01074185296", "park@kildong.com"));
		lst.add(new Friend("이길동", "01075395162", "lee@kildong.com"));
		
		System.out.println(" 이름        전화번호               이메일");
		System.out.println("--------------------------------");
		
		//LinkedList를 Inhanced for문 사용하여 꺼내는 방법
		for(Friend f : lst) {
			System.out.println(f.getInfo());
		}
	}
}
