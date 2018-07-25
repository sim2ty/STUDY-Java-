package day22;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServerThread {
	public static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
	public static void main(String args[]) throws Exception {
		ServerSocket serverSocket = new ServerSocket(7777);
		System.out.println(getTime() + "서버가 준비되었습니다.");

		Thread[] threadArr = new Thread[5];
		for (int i = 0; i < threadArr.length; i++) {
			threadArr[i] = new Thread(new Runnable() {
				public void run() {
					while (true) {
						try {
							Thread t = Thread.currentThread();
							System.out.println(t.getName()+TcpIpServer.getTime() + " 연결요청 대기");
							Socket socket = serverSocket.accept();
							System.out.println(t.getName() + "가 연결요청 받음");
							Thread.sleep(10000);
							OutputStream out = socket.getOutputStream();
							DataOutputStream dos = new DataOutputStream(out);

							dos.writeUTF("["+t.getName()+"] Test Message1 from Server.");
							System.out.println(TcpIpServer.getTime() + "데이터 전송");
							out.close();
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
			});
			threadArr[i].start();
		}		
	}
}
