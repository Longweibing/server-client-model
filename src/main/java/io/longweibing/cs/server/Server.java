package io.longweibing.cs.server;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
	private final int port = 8888;  // 服务器端口号
	private ServerSocket serverSocket;  // 服务器套接字
	private String name = "Weebing";
	
	public Server() throws Exception{
		serverSocket = new ServerSocket(port);  // 初始化服务器套接字对象
	}

	/**
	 * 服务器的核心服务函数
	 */
	public void sevice() {
		Socket socket = null;  // 客户机套接字
		try {
			while (true) {
				socket = this.serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				byte[] byBuffer = inputStream.readAllBytes();
				String strRead = new String(byBuffer);
				this.response(strRead);
				
				// 关闭资源
				inputStream.close();
				byBuffer = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 对客户端的请求文本做解析并响应
	private void response(String pleaseText) {
		if (pleaseText.equals("现在几点了")) {
			System.out.print("现在时间为: ");
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
//	System.out.println("服务器已启动: ");
//	Server server = new Server();
//	server.sevice();
//			
//}

}
