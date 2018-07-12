package day19;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.Scanner;

public class ReadWeb {
	public static void main(String[] args) {
		String path = "C:/iotest/output/";
		File isDir = new File(path);
		if(!isDir.exists()) {
			isDir.mkdir();
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("URL문자열을 입력하세요 > ");
		String in = sc.nextLine();
		sc.close();
		String arr[] = in.split("/");		//입력받은 URL을 /단위로 끊어서 arr배열에 저장
		String fullName = path + arr[arr.length-1];	//fullName은 경로(path)와 URL의 마지막 요소를 합쳐서 만든다.
		
		if(in.endsWith("png")||in.endsWith("jpg")) {	//파일명이 png나 jpg로 끝나면(즉, 이미지 파일이면) 이미지파일 저장.
			try {
				URL req = new URL(in);
				InputStream is = req.openStream();
				FileOutputStream fos = new FileOutputStream(fullName);
				int input=0;
				while(true) {
					input = is.read();
					if(input==-1) {
						break;
					}
					fos.write(input);
				}
				fos.close();
				System.out.println(fullName + "가 성공적으로 생성되었습니다.");
			} catch(MalformedInputException e) {
				System.out.println("URL문자열 오류 : " + e.getMessage());
			} catch(IOException e) {
				System.out.println("IO 오류 : " + e.getMessage());
			}
		}else {			// 이미지 파일이 아니면, UTF-8 형식으로 읽어서 저장.
			try {
				PrintWriter out = new PrintWriter(fullName, "UTF-8");
				URL req = new URL(in);
				InputStream is = req.openStream();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String data = br.readLine();
					if(data==null) {
						break;
					}
					out.write(data+"\r\n");
				}
				System.out.println(fullName + "가 성공적으로 생성되었습니다.");
				out.close();
			}catch(MalformedURLException e) {
				System.out.println("URL문자열 오류 : " + e.getMessage());
			} catch(IOException e) {
				System.out.println("IO 오류 : " + e.getMessage());
			}
		}
	}
}