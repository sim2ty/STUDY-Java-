package day21;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class URLTest_HtmlRead {
	public static void main(String[] args) {
		String fileName = "c:/iotest/test1.html";
		try {
			URL req = new URL("http://html5.clearboth.org/links.html");
			InputStream is = req.openStream();
			InputStreamReader isr = new InputStreamReader(is,"UTF-8");
			BufferedReader br = new BufferedReader(isr);
			FileWriter out = new FileWriter(fileName);
			while(true) {
				String data = br.readLine();
				if(data==null)
					break;
				out.write(data + "\r\n");
			}
			out.close();
			System.out.println(fileName + "파일이 성공적으로 저장되었습니다.");
		}catch(MalformedURLException e) {
			System.out.println("URL문자열 오류 : " + e.getMessage());
		}catch(IOException e) {
			System.out.println("IO 오류 : " + e.getMessage());
		}

	}

}
