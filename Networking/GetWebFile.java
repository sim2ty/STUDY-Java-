package day21;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Scanner;

/*
 표준입력으로 URL 문자열을 입력받아 입력된 URL 문자열에 알맞는 파일을 서버에 요청한 후에 c:/iotest/web 디렉토리에 
 저장하는 프로그램을 만듭니다.(클래스명 : GetWebFile)
 [ 추가 요구 사항 ]
 1. 응답되는 컨텐트의 타입정보를 읽고
    text/
    image/
    부분을 채크하여
    text 로 시작하면 문자 스트림을 사용하고
    image 로 시작하면 바이트 스트림을 사용해서
    파일에 저장한다.
 2. 파일에 저장할 때 파일명은 타임스탬프시간.xxx 로 하는데
    xxx 는 응답되는 컨텐트의 타입에서 
    /png
    /html
    /jpg
    등을 채크하여 붙인다.
 3. 사용자가 원할 때까지 반복처리한다.
 4. 잘못된 URL 문자열과 IO 오류를 분리하여 예외처리한다.
*/

public class GetWebFile {
	public static void main(String[] args) {
		while(true) {		
		String path = "C:/iotest/web/";							//경로설정
		Scanner scan = new Scanner(System.in);
		System.out.print("URL을 입력하세요 (종료는 x 입력) > ");
		String input_url = scan.nextLine();
		if(input_url.equals("x")) {
			System.out.println("종료되었습니다.");
			break;
		}
		Date d = new Date();
		try {
			URL u = new URL(input_url);
			URLConnection uc = u.openConnection();
			String [] type = uc.getContentType().split("/");
			System.out.println("content-type : " + uc.getContentType());
			String name = path + d.getTime() + "." + type[1];
			InputStream is = u.openStream();
			if(type[0].equals("text")) {			//content타입이 "text"이면
				InputStreamReader isr = new InputStreamReader(is,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				FileWriter out = new FileWriter(name);	
				while(true) {
					String data = br.readLine();
					if(data==null)
						break;
					out.write(data + "\r\n");
					}
				out.close();
				System.out.println("결과 : text 저장이 완료되었습니다.");
			}else if(type[0].equals("image")) {		//content타입이 "image"이면
				FileOutputStream fos = new FileOutputStream(name);
				int input=0;
				while(true) {
					input = is.read();
					if(input==-1)
						break;
					fos.write(input);
				}
				fos.close();
				System.out.println("결과 : image 저장이 완료되었습니다.");
			}
		}catch(MalformedURLException e) {
			System.err.println("URL is not a URL I understand");
		}catch(IOException e) {
			System.err.println(e);
		}
		}
	}
}
