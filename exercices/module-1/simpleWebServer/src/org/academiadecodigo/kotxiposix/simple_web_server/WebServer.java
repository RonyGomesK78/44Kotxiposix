package org.academiadecodigo.kotxiposix.simple_web_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private ServerSocket serverSocket;

    private void init() {

        try {

            serverSocket = new ServerSocket(7887);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void establishConnection() {

        try {

            while (true) {

                System.out.println("****Listening for connection request on " +
                        serverSocket.getLocalSocketAddress() + "...  ****");
                Socket connection = serverSocket.accept();

                Thread newConnection = new Thread(new ClientDispatcher(connection));
                newConnection.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        WebServer webServer = new WebServer();

        webServer.init();
        webServer.establishConnection();
    }
}
