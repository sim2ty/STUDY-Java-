package jsoupexam;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
다음 사이트에서(https://news.naver.com/main/list.nhn?mode=LSD&mid=sec&sid1=001&listType=summary&date=20171225") 
뉴스제목만 추출하는데, 10개 페이지에 대하여 처리하여 "naver_news.txt" 파일에 저장하는 기능 구현. 
*/

public class WebScrapLab3 {
	public static void main(String[] args) {
		String filepath = "C:/iotest/";
		
		try(FileWriter FOS = new FileWriter(filepath+"naver_news.txt");){
			for (int i = 1; i <= 10; i++) {
				Document doc = Jsoup.connect("https://news.naver.com/main/list.nhn?mode=LSD&mid=sec&sid1=001&listType=summary&date=20171225&page="+i).get();
				Elements doms = doc.select("div.list_body a");
				FOS.write("=================================< " + i + " page >==================================\r\n");
				int count=0;
				for (int j = 0; j < doms.size(); j++) {
					// 공백줄 제거 && 9,10페이지에서 '동영상기사' 키워드 때문에 개별 제목으로 인식되는 문제 해결
					if(!doms.get(j).text().equals("") && !doms.get(j).text().equals("동영상기사")) {
						count++;		// if문에 들어왔을 때만 count 증가
						FOS.write(count+". "+doms.get(j).text() + "\r\n");
					}
				}
				FOS.write("\r\n");
			}
			System.out.println("저장완료");
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
