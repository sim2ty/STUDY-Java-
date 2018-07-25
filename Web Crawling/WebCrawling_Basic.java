package jsoupexam;

import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebCrawling_Basic {
	public static void main(String[] args) throws Exception{
		URL url = new URL("http://70.12.114.98:8000/edu/jsouptest.html");
		Document doc = Jsoup.parse(url.openStream(),"UTF-8","");
		//Document doc = Jsoup.parse(url,5000);
		System.out.println(doc);
		System.out.println();
		
		Elements links = doc.select("a[href]");	//href 속성을 갖고 있는 a태그들을 추출
		for(Element e : links)
			System.out.println(e);
		System.out.println();
		
		Elements gifs = doc.select("img[src$=.gif]");	//src 속성이 gif로 끝나는 img 태그들을 추출
		for(Element e : gifs)
			System.out.println(e);
		System.out.println();
		
		Element masthead = doc.select("div.c1").first();	//c1이라는 클래스 속성을 갖는 div태그들을 추출
		System.out.println(masthead);
		System.out.println();
		
		System.out.println("-----------------------------------");
		
		System.out.println(masthead.html());
		for(Element e : gifs)
			System.out.println(e.attr("src"));
	}
}