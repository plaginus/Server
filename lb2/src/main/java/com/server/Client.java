package com.server;

import java.net.*;
import java.io.*;
import java.util.concurrent.Semaphore;

public class Client extends Thread {
    public Client(Socket client, Semaphore sem, String threadName){
        super(threadName);

        this.sem = sem;
        this.client = client;
    }

    private Semaphore sem;
    private Socket client;

    public void run(){
        try {
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true){
                if (!sem.tryAcquire()){
                    out.writeUTF("Сервер заполнен");
                    Thread.sleep(5000);
                } else {break;}
            }

            for(int i = 0; i < 5; i++){
                out.writeUTF("Подключён к " + InetAddress.getLocalHost() + " " + String.valueOf(i));
                Thread.sleep(5000);
            }
            out.writeUTF("close");
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            sem.release();
        }
    }

    public Socket getClient(){return client;}
}
