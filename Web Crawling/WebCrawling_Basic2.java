package jsoupexam;

import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WebCrawling_Basic2 {
	public static void main(String[] args) throws Exception{
		Document doc = Jsoup.connect("http://70.12.114.90:8000/edu/jsouptest.html").get();	//jsouptest.html 내용을 문자열로 받아온다.
		System.out.println(doc);
		System.out.println();
		
		Elements pngs = doc.select("img[src$=.png]");
		Elements gifs = doc.select("img[src$=.gif]");
		Elements jpgs = doc.select("img[src$=.jpg]");
		
		System.out.println(pngs.size());
		System.out.println(gifs.size());
		System.out.println(jpgs.size());
		
		Attributes attrs = pngs.get(0).attributes();
		System.out.println(attrs.size());
		if(attrs.hasKey("src"))
			System.out.println("src : " + attrs.get("src"));
		if(attrs.hasKey("width"))
			System.out.println("width : " + attrs.get("width"));
		if(attrs.hasKey("height"))
			System.out.println("height : " + attrs.get("height"));
		Map<String, String> map = attrs.dataset();
		System.out.println(map);
		
		Elements links = doc.select("a[href=first.html]");
		if(links.size() == 1) {
			String relHref = links.get(0).attr("href");		//상대 URL정보
			String absHref = links.get(0).attr("abs:href");	//절대 URL정보
			System.out.println(relHref + " : " + absHref);
		}
	}
}