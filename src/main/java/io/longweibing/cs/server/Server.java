package io.longweibing.cs.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	private final int port = 8888;  // �������˿ں�
	private ServerSocket serverSocket;  // �������׽���
	private String name = "Weebing";
	
	public Server() throws Exception{
		serverSocket = new ServerSocket(port);  // ��ʼ���������׽��ֶ���
	}

	/**
	 * �������ĺ��ķ�����
	 */
	public void sevice() {
		Socket socket = null;  // �ͻ����׽���
		try {
			while (true) {
				socket = this.serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				byte[] byBuffer = inputStream.readAllBytes();
				String strRead = new String(byBuffer);
				this.response(strRead);
				
				// �ر���Դ
				inputStream.close();
				byBuffer = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// �Կͻ��˵������ı�����������Ӧ
	private void response(String pleaseText) {
		if (pleaseText.equals("���ڼ�����")) {
			System.out.print("����ʱ��Ϊ: ");
			System.err.println(new Date());
			return;
		}
		if (pleaseText.equals("���ʲô����")) {
			System.err.print(this.name + "---");
			System.out.println(new Date());
			return;
		}
	}
	
//	public static void main(String[] args) throws Exception {
//	System.out.println("������������: ");
//	Server server = new Server();
//	server.sevice();
//			
//}

}
