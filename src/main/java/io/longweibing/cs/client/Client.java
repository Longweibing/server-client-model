package io.longweibing.cs.client;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	private Socket socket = null;  // �׽���
	private int port = 8888;  // �ͻ��˶˿ں�
	private String ipadd = "localhost";  // �ͻ���ip��ַ
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
		
	public void run() throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String textLine = null;
		while ((textLine = scanner.nextLine()) != null) {
			this.socket = new Socket(ipadd, port);
			OutputStream outputStream = this.socket.getOutputStream();
			byte[] bytes = null;
			bytes = textLine.getBytes("gbk");
			outputStream.write(bytes);
			outputStream.flush();
			
			outputStream.close();
			socket.close();
		}	
	}
}
