package com.server;

import java.io.*;

public class Main {
    public static void main(String [] args) {

	      int port = 6066;
	      try {
	         Thread t = new Server(port);
	         t.start();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
		
	   }
}