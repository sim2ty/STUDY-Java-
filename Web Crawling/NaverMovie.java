package jsoupexam;

import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 다음에 제시된 내용을 읽고 Java 언어로 구현하여 제출하시오.
 1) 스크래핑할 페이지의 URL은 다음과 같다.
    https://movie.naver.com/movie/point/af/list.nhn?&page=1
 2) 1페이지에 10개의 리뷰글이 올라와 있으며 3개 페이지를 스크래핑한다.
 3) 스크래핑 내용은 영화 제목, 평점 그리고 리뷰내용을 각각 추출하여 다음 형식으로 naver_movie.txt 에 행단위로 저장.

    1,제목,평점,리뷰글
    2,제목,평점,리뷰글
    3,제목,평점,리뷰글
                :
 4) 리뷰글 끝에 있는 신고라는 단어는 제거하고 파일에 저장한다.
 5) 클래스명 : NaverMovie
*/
public class NaverMovie {
	public static void main(String[] args) {
		String filepath = "C:/iotest/";
		
		try(FileWriter FOS = new FileWriter(filepath+"naver_movie.txt");){
			int count=0;
			for (int i = 1; i <= 3; i++) {
				Document doc = Jsoup.connect("https://movie.naver.com/movie/point/af/list.nhn?&page="+i).get();
				Elements title = doc.select("#old_content td.title > a.movie");
				Elements point = doc.select("#old_content td.point");
				Elements comment = doc.select("#old_content td.title");
			
				for (int j = 0; j < point.size(); j++) {					
					count++;		
					FOS.write(count+","+ title.get(j).text() +  "," + point.get(j).text() + "," 
					+ comment.get(j).text().substring(title.get(j).text().length(), comment.get(j).text().length()-2) + "\r\n");					
				}
			}
			System.out.println("저장완료");
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
