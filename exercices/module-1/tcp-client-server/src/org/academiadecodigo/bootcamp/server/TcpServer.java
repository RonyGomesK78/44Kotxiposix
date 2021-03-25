package org.academiadecodigo.bootcamp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    private ServerSocket server;

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Missing TcpServer <port>");
            return;
        }

        try {
            TcpServer tcpServer = new TcpServer(Integer.parseInt(args[0]));
            tcpServer.start();

        } catch (NumberFormatException e) {
            System.err.println("Invalid port number: " + args[0] + "\n");

        } catch (IOException e) {
            System.err.println("Unable to start server: " + e.getMessage());

        }
    }

    public TcpServer(int port) throws IOException {
        server = new ServerSocket(port);
    }

    private void start() {

        while (server.isBound()) {

            Socket clientSocket = null;

            try {
                System.out.println("<<< Waiting for connection >>>");
                clientSocket = server.accept();
                System.out.println("\n --- Connection accepted ---");

                Thread thread = new Thread(new ServerWorker(clientSocket));
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void close(Closeable closeable) {
        if (closeable == null) {
            return;
        }

        try {
            closeable.close();
        } catch (IOException e) {
            System.err.println("Error closing stream: " + e.getMessage());
        }
    }
}
