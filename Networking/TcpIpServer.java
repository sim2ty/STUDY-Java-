package day22;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 Socket : 프로세스간의 통신을 담당, InputStream과 OutputStream을 가지고 있다. 
 		   이 두 스트림을 통해 프로세스간의 통신(입출력)이 이루어진다.
 ServerSocket : 포트와 연결(bind)되어 외부의 연결요청을 기다리다 연결요청이 들어오면 Socket을 생성해서 
 				소켓과 소켓간의 통신이 이루어지도록 한다.
				한 포트당 하나의 ServerSocket만 연결할 수 있다. (프로토콜이 다르면 같은 포트를 공유할 수 있다.)

 1. 서버는 서버소켓을 사용해서 서버 컴퓨터의 특정 포트에서 클라이언트의 연결요청을 처리할 준비를 한다.
 2. 클라이언트는 접속할 서버의 IP주소와 포트정보로 소켓을 생성해서 서버에 연결을 요청한다.
 3. 서버소켓은 클라이언트의 요청을 받으면 서버에 새로운 소켓을 생성해서 클라이언트의 소켓과 연결되도록 한다.
 4. 이제 클라이언트의 소켓과 새로 생성된 서버의 소켓은 서버소켓과 관계없이 1:1통신을 한다.
*/

public class TcpIpServer {
	// 현재시간을 문자열로 반환하는 메서드
	public static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
	public static void main(String[] args) {
		ServerSocket serverSocket = null;	 // 서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
		Socket socket = null;
		OutputStream out = null;
		DataOutputStream dos = null;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"서버가 준비되었습니다.");
			System.out.println(getTime()+"연결요청을 기다립니다.");		// 서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다린다.			
			socket = serverSocket.accept();		// 클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성한다.
			System.out.println(getTime()+socket.getInetAddress()+"로부터 연결요청이 들어왔습니다.");				
			out = socket.getOutputStream();		// 소켓의 출력스트림을 얻는다.
			dos = new DataOutputStream(out);
			String myAddr = InetAddress.getLocalHost().getHostAddress(); //이 컴퓨터의 IP주소를 문자열로 리턴
			dos.writeUTF("어서오세요. " + myAddr + "에 접속한 것을 환영해요.");	// 원격 소켓(remote socket)에 데이터를 보낸다.
			System.out.println(getTime()+"데이터를 전송했습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(dos!=null) dos.close();
				if(out!=null) out.close();
				if(socket!=null) socket.close();
				if(serverSocket!=null) serverSocket.close();
			}catch(Exception e) {
				System.out.println("일어날리 없는 예외를 맨날 처리하래");
			}
		}
		System.out.println("서버를 종료했습니다.");
	}

}
