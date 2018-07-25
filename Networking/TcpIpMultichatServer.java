package day22;

import java.net.*;
import java.io.*;
import java.util.*;

public class TcpIpMultichatServer {
	HashMap<String, DataOutputStream> clients;
	
	TcpIpMultichatServer() {
		clients = new HashMap<>();
		Collections.synchronizedMap(clients); //멀티스레드 환경에서 필수(thread-safe)
	}

	public void startUp() {
		ServerSocket serverSocket = null;
		Socket socket = null;

		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("멀티채팅 서버가 시작되었습니다.");

			while(true) {				
				socket = serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 접속하였습니다.");
				ReceiverSender thread = new ReceiverSender(socket);
				thread.start();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 

	void sendToAll(String msg) {
		Iterator<String> it = clients.keySet().iterator();
		
		while(it.hasNext()) {
			try {
				DataOutputStream out = clients.get(it.next());
				out.writeUTF(msg);
			} catch(IOException e){}
		} 
	} 

	public static void main(String args[]) {
		new TcpIpMultichatServer().startUp();
	} 
	class ReceiverSender extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		ReceiverSender(Socket socket) {
			this.socket = socket;
			try {
				in  = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch(IOException e) {}
		}

		public void run() {
			String name = "";
			try {
				name = in.readUTF();  //대화명
				sendToAll("#"+name+"님이 들어오셨습니다.");

				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 "+ clients.size()+"입니다.");

				while(in!=null) {
					sendToAll(in.readUTF());
				}
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				sendToAll("#"+name+"님이 나갔습니다.");
				clients.remove(name);
				System.out.println("["+socket.getInetAddress() +":"+socket.getPort()+"]"+"에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는 "+ clients.size()+"입니다.");
			} 
		} 
	} 
}