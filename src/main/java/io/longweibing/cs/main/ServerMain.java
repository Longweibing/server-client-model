package io.longweibing.cs.main;

import java.util.Date;

import io.longweibing.cs.server.Server;

public class ServerMain {

	public static void main(String[] args) throws Exception {
		System.out.println("������������: ---" + new Date());
		Server server = new Server();
		server.sevice();
	}

}
