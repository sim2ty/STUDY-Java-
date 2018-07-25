package jsoupexam;

import java.io.File;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawling_text_html {
	public static void main(String[] args) throws Exception{
		File input = new File("c:/Temp/jsouptest.html");
		Document doc = Jsoup.parse(input,"UTF-8");
		System.out.println(doc);
		System.out.println();
		
		Element div = doc.getElementById("java");
		outElement(div);
		Elements links = doc.getElementsByTag("a");
		for (int i = 0; i < links.size(); i++) {
			outElement(links.get(i));
		}
	}
	// e.text()와 e.html()의 차이점
	public static void outElement(Element e) {
		String name = e.tagName();
		if(name.equals("a")) {
			String linkHref = e.attr("href");
			String linkText = e.text();
			System.out.println("태그명 : " + name);
			System.out.println("href속성의 값 : " + linkHref);
			System.out.println("컨텐트 : " + linkText);
			System.out.println("-------------------------------");
			
		}else {
			String linkText = e.text();
			String linkInnerH = e.html();
			System.out.println("태그명 : " + name);
			System.out.println("컨텐트 : [" + linkText + "]");
			System.out.println("내부 HTML : [" + linkInnerH + "]");
			System.out.println("-------------------------------");
		}
		
		
		
		
	}
}