package day23;

import java.io.*;
import java.util.*;
import java.util.HashMap;

public class WordCount {
	public static void main(String[] args) throws IOException {
		File f = new File("c:/iotest/education.txt");
		FileReader fr;
		try {
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			StringTokenizer st;
			HashMap<String,Integer>map = new HashMap<String,Integer>();
			String line;

			while(true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				String [] strarr = line.split(" ");
				st = new StringTokenizer(line);
							
				if(st.countTokens()==1) continue;					
				else {
					for (int j = 0; j < strarr.length; j++) {
						if(map.containsKey(strarr[j])==false) {
							map.put(strarr[j], 1);
						}else {
							map.replace(strarr[j], map.get(strarr[j]), map.get(strarr[j])+1);
						}
					}
					map.remove("");	//null문자열 제거
					
				}				
			}
			br.close();
			fr.close();
			for(String s:map.keySet()) {
				System.out.println(s + " - " + map.get(s) + "개");
			}			
		}catch (Exception e) {
			System.out.println("오류");
		}
	}
}