package day21;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionReader {
	public static void main(String[] args) {
		try {
			URL u = new URL("http://html5.clearboth.org/links.html");
			URLConnection uc = u.openConnection();
			// 헤더 정보 추출			
			System.out.println("Content-type : " + uc.getContentType());
			System.out.println("Date : " + new java.util.Date(uc.getDate()));
			System.out.println("Content-length : " + uc.getContentLength());
			//내용 추출
			InputStream is = (InputStream)uc.getContent();
			BufferedReader in = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String inputLine;
			while((inputLine=in.readLine()) != null) {
				System.out.println(inputLine);
			}
		}catch(MalformedURLException e) {
			System.err.println("URL is not a URL I understand");
		}catch(IOException e) {
			System.err.println(e);
		}
	}
}
