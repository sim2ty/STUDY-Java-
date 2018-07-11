package day18;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;

/*
 제공된 sample.txt 파일을 읽고 sample_yyyy_mm_dd.txt 파일에 그대로 출력하는 프로그램을 구현. 
 이 파일은 append 모드로 오픈하여 여러번 테스트하면 sample.txt 파일의 내용이 sample_yyyy_mm_dd.txt 파일에 
 추가되게 합니다.

 정상적으로 수행되면 화면에 “저장 완료되었습니다.” 
 예외 발생시 화면에 "처리하는 동안 오류가 발생했습니다."를 출력하는 프로그램을 구현하세요.
 */

public class CopyExam {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		int day = c.get(Calendar.DATE);
	
		String filepath = "C:\\Temp";
		try ( FileReader FIS = new FileReader(filepath+"/sample.txt");
			  FileWriter FOS = new FileWriter(filepath+"/sample_"+year+"_"+month+"_"+day+".txt",true);
			  BufferedReader BIS = new BufferedReader(FIS);
			  BufferedWriter BOS = new BufferedWriter(FOS);){

			String data;
			while (true) {
				data = BIS.readLine();		//줄 단위로 read
				if (data == null) {			//줄 단위로 읽어들인 data가 없으면 while문을 빠져나간다.
					break;
				}               
				FOS.write("\r\n"+data);		//파일에 write
				
				}
			System.out.println("저장 완료되었습니다.");
			  
        } catch (Exception e) {
        System.out.println("처리하는 동안 오류가 발생했습니다.");
 		} 
    } 
}
