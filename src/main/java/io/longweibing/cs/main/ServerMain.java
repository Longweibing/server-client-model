package io.longweibing.cs.main;

import java.util.Date;

import io.longweibing.cs.server.Server;

public class ServerMain {

	public static void main(String[] args) throws Exception {
		System.out.println("服务器已启动: ---" + new Date());
		Server server = new Server();
		server.sevice();
	}

}
