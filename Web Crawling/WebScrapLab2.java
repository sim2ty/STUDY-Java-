package jsoupexam;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 다음 사이트에서(https://www.w3.org/Protocols/rfc2616/rfc2616.html) 
 "Table of Contents" 부분을 추출하여 출력하는 자바 코드를 구현하여 제출하시오. 
 클래스명 : WebScrapLab2
*/

public class WebScrapLab2 {
	public static void main(String[] args) throws Exception{
		URL url = new URL("https://www.w3.org/Protocols/rfc2616/rfc2616.html");
		Document doc = Jsoup.parse(url.openStream(),"UTF-8","");
		Elements ele = doc.select("div>h2");
		System.out.println(ele.text());
	}
}
