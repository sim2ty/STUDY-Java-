package day18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardInput {
	public static void main(String[] args) throws IOException{
		System.out.print("입력 : ");
//		int input = System.in.read(); // 영문을 기준으로 함.
		int input = new InputStreamReader(System.in).read(); 
		System.out.println("입력된 문자 ===> " + (char)input);
		System.out.print("입력 : ");
		String inputLine = new BufferedReader(new InputStreamReader(System.in)).readLine();
		System.out.println("입력된 행 ===> " + inputLine);
	}

}
