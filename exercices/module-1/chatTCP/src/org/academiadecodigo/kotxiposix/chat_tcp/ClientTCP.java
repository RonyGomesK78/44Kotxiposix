package org.academiadecodigo.kotxiposix.chat_tcp;

import java.io.*;
import java.net.Socket;

public class ClientTCP {

    private Socket connection;
    private String message;

    public void start() throws IOException {

        connect();

        while (true) {

            getUserInput();

            sendMessage();

            if (message.equals("/quit")){

                connection.close();
                return;
            }

            receiveResponse();
        }
    }

    public void connect() throws IOException {

        connection = new Socket("192.168.1.118", 7878);
    }

    public void sendMessage() throws IOException {

        PrintWriter out = new PrintWriter(connection.getOutputStream(), true);

        out.println(message);
    }

    public void receiveResponse() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        System.out.println(bufferedReader.readLine());

    }

    public void getUserInput() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your message : ");
        message = reader.readLine();
    }

    public static void main(String[] args) throws IOException {

        ClientTCP clientTCP = new ClientTCP();

        clientTCP.start();
    }
}
