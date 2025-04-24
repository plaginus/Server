package com.server;

import java.io.*;

public class Main {
    public static void main(String [] args) {

	      int port = 6066;
	      try {
			Server server = new Server(port);
	         server.run();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		
	   }
}