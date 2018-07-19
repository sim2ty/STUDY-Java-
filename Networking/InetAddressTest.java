package day21;

import java.net.InetAddress;
import java.util.Scanner;

public class InetAddressTest {
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		System.out.print("IP주소를 점검하려는 도메인명을 입력하세요 > ");
		String domain = scan.nextLine();
		InetAddress me = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터 IP 주소 : " + me.getHostAddress());
		InetAddress naver = InetAddress.getByName(domain);
		System.out.println(domain + "의 IP 주소 : " + naver.getHostAddress());
		scan.close();

	}

}
