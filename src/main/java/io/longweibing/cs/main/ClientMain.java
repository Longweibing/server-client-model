package io.longweibing.cs.main;

import java.util.Date;

import io.longweibing.cs.client.Client;

public class ClientMain {

	public static void main(String[] args) throws Exception {
		System.out.println("�ͻ���������: ---" + new Date());
		Client client = new Client();
		client.run();
	}

}
