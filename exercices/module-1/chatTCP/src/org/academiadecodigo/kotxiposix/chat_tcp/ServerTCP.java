package org.academiadecodigo.kotxiposix.chat_tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {

    private ServerSocket serverSocket;
    private Socket connection;

    private String message;

    private final int port;

    private boolean close;

    public ServerTCP(int port) {

        this.port = port;
        close = false;
    }

    public void init() throws IOException {

        this.serverSocket = new ServerSocket(port);
    }

    public void listen() throws IOException {

        while (true) {

            start();
            close = false;
        }
    }

    public void start() throws IOException {

        establishConnection();

        while (connection.isBound()) {

            receiveMessage();

            if (close) {

                connection.close();
                return;
            }

            sendMessage();
        }

    }

    public void establishConnection() throws IOException {

        System.out.println("Waiting for connection request ...");

        connection = serverSocket.accept();

        System.out.println("Connection established with : " + connection.getInetAddress());

    }

    public void receiveMessage() throws IOException {

        System.out.println("Waiting for new messages...");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        message = in.readLine();

        if (message == null) {

            close = true;
            System.out.println("Client close the connection \n");
            return;

        } else {

            close = message.equals("/quit");
        }


        System.out.println("Client : " + message);

        System.out.println();
    }

    public void sendMessage() throws IOException {

        PrintWriter out = new PrintWriter(connection.getOutputStream(), true);

        out.println(message);
    }

    public static void main(String[] args) {

        ServerTCP server = new ServerTCP(7878);

        try {

            server.init();
            server.listen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
