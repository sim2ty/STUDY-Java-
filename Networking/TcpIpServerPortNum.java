package day22;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
public class TcpIpServerPortNum {
	public static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
	public static void main(String args[]) {
		ServerSocket serverSocket = null;
		int num = 0;
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime()+"서버가 준비되었습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}		
		while(true) {
			try {
				System.out.println(getTime()+"연결요청을 기다립니다.");
				Socket socket = serverSocket.accept();
				System.out.println(getTime()+ socket.getInetAddress() + "로부터 연결요청이 들어왔습니다.");				
				System.out.println("getPort():"+socket.getPort()); //Client 포트번호
                System.out.println("getLocalPort():" +socket.getLocalPort()); //Server 포트번호
                Thread.sleep(10000);
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
   
				dos.writeUTF("[Notice] Test Message"+ ++num +" from Server.");
				System.out.println(getTime()+"데이터를 전송했습니다.");
				dos.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(serverSocket!=null) serverSocket.close();
				}catch(Exception e) {
				}
			}
		}	
	}
} 
