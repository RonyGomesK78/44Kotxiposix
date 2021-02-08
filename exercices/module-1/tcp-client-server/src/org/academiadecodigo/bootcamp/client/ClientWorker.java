package org.academiadecodigo.bootcamp.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWorker implements Runnable{

    private Socket clientSocket;

    private BufferedReader serverReader;

    public ClientWorker(Socket clientSocket){

        this.clientSocket = clientSocket;
        initBuffer();
    }

    private void initBuffer(){

        try {
            this.serverReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void receive() throws IOException {

        System.out.println("From Server: " + serverReader.readLine());
    }

    @Override
    public void run() {

        try {
            receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
