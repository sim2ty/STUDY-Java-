package day21;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;

public class URLTest_ImageRead {

	public static void main(String[] args) {
		String imageName = "c:/iotest/java.jpg";
		try {
			URL req = new URL("http://post.phinf.naver.net/20150413_141/itdonga_me_1428901939406Euebm_JPEG/mug_obj_142890194132315584.jpg");
			InputStream is = req.openStream();
			FileOutputStream fos = new FileOutputStream(imageName);
			int input=0;
			while(true) {
				input = is.read();
				if(input==-1)
					break;
				fos.write(input);
			}
			fos.close();
			System.out.println(imageName + "파일이 성공적으로 생성되었습니다.");
		}catch(MalformedURLException e) {
			System.out.println("URL문자열 오류 : " + e.getMessage());
		}catch(IOException e) {
			System.out.println("IO 오류 : " + e.getMessage());
		}

	}

}
