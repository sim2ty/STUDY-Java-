package jsoupexam;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

/*
 주소를 문자열로 받아서 해당 주소의 위도, 경도 출력하는 코드
*/

public class WebCrawling_Address {
	public static void main(String[] args) throws Exception{
		String url = "http://maps.googleapis.com/maps/api/geocode/json?address=";
		// URLEncoder의 encode 메서드 : 문자열을 형식에 맞추어 쿼리 문자열로 변환해준다.
		String addurl = url + java.net.URLEncoder.encode("서울시 강남구 역삼동 718-5", "UTF-8");
		Connection.Response res = Jsoup.connect(addurl).ignoreContentType(true).execute();
		String content = res.body();	

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(content);
		JSONObject jobj = (JSONObject) obj;
		System.out.println("key들 : " +jobj.keySet());
		
		JSONArray jary = (JSONArray)jobj.get("results");        
		System.out.println("results 키의 값 타입 : " + jary.getClass().getName());
		System.out.println("results 키의 값 갯수 : " + jary.size());
		
		JSONObject first = (JSONObject)jary.get(0);
		JSONObject geo = (JSONObject)first.get("geometry");
		JSONObject loc = (JSONObject)geo.get("location");
		Double lat = (Double)loc.get("lat");
		Double lng = (Double)loc.get("lng");
		System.out.println("위도 : "+ lat);
		System.out.println("경도 : "+ lng);
	}		
}
