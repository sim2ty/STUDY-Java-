package day19;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;

class Student implements java.io.Serializable{
	String name;
	String subject;
	int age;
	public Student(){
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

public class SerialTest4 {
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream("c:/iotest/test2.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Date value1 = (Date)ois.readObject();
		Date value2 = (Date)ois.readObject();
		Student st = (Student)ois.readObject();
		System.out.println("Date객체 데이터 : " + value1);
		System.out.println("Date객체 데이터 : " + value2);
		System.out.println("Student객체 데이터 : ");
		System.out.println("Student객체정보 : " + st.getStudentInfo());
		ois.close();
		fis.close();
	}

}
