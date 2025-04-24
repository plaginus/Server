package com.server;

import java.net.*;
import java.io.*;
import java.util.concurrent.Semaphore;

public class Server {
	public Server(int port) throws IOException {
		server = new ServerSocket(port);
	}
	
	private Semaphore sem = new Semaphore(3, true);
	private ServerSocket server;

	public void run() {
	      while(true) {
	         try {
				System.out.println("Ожидание клиента на порт " + server.getLocalPort() + "...");
				Client client = new Client(server.accept(), sem,"Client");
				System.out.println("Подключён " + client.getClient().getRemoteSocketAddress());
				client.start();
	         } catch (IOException e) {
	            e.printStackTrace();
	            break;
	         }
	      }
	}
}
