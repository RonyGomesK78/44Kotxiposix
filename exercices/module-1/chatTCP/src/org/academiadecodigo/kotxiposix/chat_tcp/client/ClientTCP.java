package org.academiadecodigo.kotxiposix.chat_tcp.client;

import java.io.*;
import java.net.Socket;

public class ClientTCP {

    private Socket connection;
    private String message;

    public void start() {

        connect();

        while (connection.isConnected()) {

            getUserInput();

            sendMessage();

            if (message.equals("/quit")) {

                try {

                    connection.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return;
            }

            receiveResponse();
        }

        System.out.println("Your connection was closed");
    }

    public void connect() {

        try {

            connection = new Socket("192.168.1.118", 7878);

        } catch (IOException e) {

            System.err.println("Some error occurred when creating the socket");
           // e.printStackTrace();

        } catch (IllegalArgumentException e) {

            System.err.println("Enter a port parameter between 0 and 65535 inclusive");
            e.printStackTrace();
        }
    }

    public void sendMessage() {

        PrintWriter out = null;

        try {

            out = new PrintWriter(connection.getOutputStream(), true);

        } catch (IOException e) {
            System.err.println("Some error occurred  when creating the output stream, " +
                    "verify if you have connection");
            e.printStackTrace();
        }

        out.println(message);
    }

    public void receiveResponse() {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            System.out.println(bufferedReader.readLine());

        } catch (IOException e) {

            System.err.println("Some error occurred");
            e.printStackTrace();
        }
    }

    public void getUserInput() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter your message : ");

        try {

            message = reader.readLine();

        } catch (IOException e) {
            System.err.println("An error occurred when reading from the keyboard");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ClientTCP clientTCP = new ClientTCP();

        clientTCP.start();
    }


}
