package exercise;

import exercise.Human;

class Human{
	private String name;
	private int age;
	private int height;
	private int weight;
	
	Human(){
		super();
	}
	Human (String name, int age, int height, int weight){
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}
	String printInformation() {
		return name + "  " + age + "  " + height + "  " + weight;
	}
}

class Student extends Human{
	private String number;
	private String major;
	
	Student(){
		super();
	}
	Student (String name, int age, int height, int weight, String number, String major){
		super(name,age,height,weight);
		this.number = number;
		this.major = major;
	}
	String printInformation() {//오버라이딩
		return super.printInformation() + "  " + number + "  " + major;
	}
}

public class StudentInfoOut {
	public static void main(String[] args) {
		Student arrays [] = new Student[3];
		arrays[0] = new Student("홍길동", 20, 171, 81, "201101", "영문");
		arrays[1] = new Student("고길동", 21, 183, 72, "201102", "건축");
		arrays[2] = new Student("박길동", 22, 175, 65, "201103", "컴공");

		for (Student s : arrays) {
			System.out.println(s.printInformation());
		}
	}
}
