package org.academiadecodigo.bootcamp.client;

import java.io.*;
import java.net.Socket;


public class TcpClient {

    private int port;
    private String hostName;
    private Socket clientSocket;
    private BufferedReader clientReader;
    private PrintWriter serverWriter;

    public static void main(String[] args) {
        TcpClient tcpClient = new TcpClient();
        tcpClient.connectToServer();
    }

    private void connectToServer() {

        try {
            getConnectionData();

            clientSocket = new Socket(hostName, port);
            serverWriter = new PrintWriter(clientSocket.getOutputStream(), true);

            Thread thread = new Thread(new ClientWorker(clientSocket));
            thread.start();

            while (true){

                getUserInput();
            }

        } catch (NumberFormatException e) {

            System.err.println("INVALID PORT NUMBER");
            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public void getUserInput() {

        System.out.println("\nmessage: ");
        String message = null;

        try {

            message = clientReader.readLine();

            sendMessage(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (message.equals("/quit")) {
            close();
            return;
        }
    }

    public void sendMessage(String message){

        serverWriter.println(message);
    }

    private void getConnectionData() throws NumberFormatException, IOException {

        clientReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("You want connect to?");
        hostName = clientReader.readLine();

        System.out.println("on port?");
        port = Integer.parseInt(clientReader.readLine());
    }

    private void close() {
       // close(serverReader);
        close(clientReader);
        close(serverWriter);
        close(clientSocket);
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
