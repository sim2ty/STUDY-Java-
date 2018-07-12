package day19;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClassLeader {
	public static void main(String[] args) {

		
		try (	FileReader fr = new FileReader("c:/iotest/member.txt");
				BufferedReader br = new BufferedReader(fr);){
			String line;
			ArrayList<String> names = new ArrayList<>();
			while(true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String [] tmp = line.split(":");
				for (int i = 0; i < tmp.length; i++) {
					names.add(tmp[i]);
				}
				
			}
				
			int i = (int)(Math.random()*21)+1;
			String sel = names.get(i); 
			System.out.println("축하합니다. 우리반 반장은 " + sel + "입니다.");
		}catch (FileNotFoundException fe) {
			System.out.println("파일을 읽을 수 없습니다.");
		}catch (IOException ioe) { 
			System.out.println("입출력 오류가 발생했습니다.");
		}
	}
}
