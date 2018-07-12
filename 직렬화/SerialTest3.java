package day19;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

class Student implements java.io.Serializable{
	String name;
	String subject;
	int age;
	public Student(){
//		name = "고길동";
//		subject = "HTML5";
//		age = 50;
		this("고길동", "HTML5", 50);
	}
	public Student(String name, String subject, int age){
		this.name = name;
		this.subject = subject;
		this.age = age;
	}
	public String getStudentInfo() {
		return name + "학생이 " + subject + "를 학습해요!";
	}
	int getAge() {
		return age;
	}
}

public class SerialTest3 {
	public static void main(String[] args) throws Exception{
		FileOutputStream fos = new FileOutputStream("c:/iotest/test2.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Date());
		Thread.sleep(3000);
		oos.writeObject(new Date());
		Student st = new Student("duke", "java프로그래밍",23);
		oos.writeObject(st);
		oos.close();
		fos.close();
		System.out.println("직렬화 출력 완료");
	}

}
