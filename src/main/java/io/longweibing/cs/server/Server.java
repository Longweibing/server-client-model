package io.longweibing.cs.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	private final int port = 8888;  // 端口号
	private ServerSocket serverSocket;  // 服务器套接字
	private String name = "Weebing";  // 服务器名字
	
	public Server() throws Exception{
		serverSocket = new ServerSocket(port);  // 初始化服务器套接字
	}

	/**
	 * 核心函数
	 */
	public void sevice() {
		Socket socket = null;  // 套接字
		try {
			while (true) {
				socket = this.serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				byte[] byBuffer = inputStream.readAllBytes();
				String strRead = new String(byBuffer);
				this.response(strRead);
				
				// 关闭连接
				inputStream.close();
				byBuffer = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 对文本的处理
	private void response(String pleaseText) {
		if (pleaseText.equals("现在几点了")) {
			System.out.print("现在时间: ");
			System.err.println(new Date());
			return;
		}
		if (pleaseText.equals("你叫什么名字")) {
			System.err.print(this.name + "---");
			System.out.println(new Date());
			return;
		}
	}
	
//	public static void main(String[] args) throws Exception {
//	System.out.println("服务器启动: ");
//	Server server = new Server();
//	server.sevice();
//			
//}

}
