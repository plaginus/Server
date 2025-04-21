package com.server;

import java.net.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Server extends Thread {
	public Server(int port) throws IOException {
		server = new ServerSocket(port);
	}
	
	private ServerSocket server;
	
	ComputerEquipment ce1 = new ComputerEquipment("intel i3", 2048);
	Laptop l1 = new Laptop("AMD", 4096, "Laptop");
	Desktop d1 = new Desktop("intel i5", 8192, "Desktop");
	PDA pda1 = new PDA("intel pentium", 1024, "PDA");

	public void run() {
	      while(true) {
	         try {
	            System.out.println("Ожидание клиента на порт " + 
	               server.getLocalPort() + "...");
	            Socket client = server.accept();
	            
	            System.out.println("Просто подключается к " + client.getRemoteSocketAddress());
	            
				DataInputStream in = new DataInputStream(client.getInputStream());
	            System.out.println(in.readUTF());

				System.out.println("Передача данных");
				DataOutputStream out = new DataOutputStream(client.getOutputStream());

				ObjectMapper ow = new ObjectMapper();

				out.writeUTF(ow.writeValueAsString(ce1));
				out.writeUTF(ow.writeValueAsString(l1));
				out.writeUTF(ow.writeValueAsString(d1));
				out.writeUTF(ow.writeValueAsString(pda1));

	            out.writeUTF("Спасибо за подключение к " + client.getLocalSocketAddress() + "\nПока!");
	            
				client.close();
	         } catch (IOException e) {
	            e.printStackTrace();
	            break;
	         }
	      }
	}
}
