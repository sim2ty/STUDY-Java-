package day22;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class TcpIpClient {
	public static void main(String[] args) {
		String serverIp = "70.12.114.91";
		System.out.println("서버에 연결중입니다. 서버IP : " + serverIp);
		try(Socket socket = new Socket(serverIp, 7777);		// 서버의 7777 포트에 연결한다.
			InputStream in = socket.getInputStream();	// 소켓의 입력스트림을 얻는다
			DataInputStream dis = new DataInputStream(in);){	 // Stream을 생성한다.
			
			System.out.println("서버로부터 받은 메시지 : " + dis.readUTF());		// 전송된 데이터를 읽는다.
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("연결이 종료되었습니다.");
	}
}
