package day18;

import java.io.*;

public class FileReaderTest {
	public static void main(String args[]) {
		try (FileReader reader = new FileReader("c:/iotest/output.txt");){
			int data;
			System.out.println(reader.getEncoding());		//encoding 형식을 읽어들인다.
			while (true) {
				data = reader.read();		//data를 한글자씩 읽어들인다.
				if (data == -1)
					break;               
				System.out.print((char)data);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		} 
	}
}


