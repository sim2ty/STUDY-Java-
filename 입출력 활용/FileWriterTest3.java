package day18;

import java.io.*;

public class FileWriterTest3 {
    public static void main(String args[]) {
        try (FileWriter writer = new FileWriter("c:/iotest/test3.txt", true);
        	 PrintWriter out = new PrintWriter(writer)){         
            char arr[] = { '객', '체', '지', '향', '언', '어', 'J', 'a', 'v', 'a' };          
            for (int cnt = 0; cnt < arr.length; cnt++)
                out.print(arr[cnt]);
            out.println();
            out.println(arr);  
            out.println("OCJP 시험 대비");
            out.println(3.14);
            out.println(true);
            out.printf("ㅋㅋㅋ %d ㅎㅎㅎ%n", 100);
            System.out.println("출력 완료");
        } catch (IOException ioe) {
            System.out.println("파일로 출력할 수 없습니다.");
        } 
    }
}