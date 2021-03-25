package org.academiadecodigo.bootcamp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerWorker implements Runnable{

    private final Socket connection;

    public ServerWorker(Socket connection){

        this.connection = connection;
    }

    private void serveClient() throws IOException {

        PrintWriter printWriter = new PrintWriter(connection.getOutputStream(), true);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String clientMessage = bufferedReader.readLine();

        while (clientMessage != null) {
            System.out.println("Client ip: " + connection.getInetAddress().getHostAddress()
                    + " port: " + connection.getPort()
                    + " message: " + clientMessage);

            printWriter.println(clientMessage);
            clientMessage = bufferedReader.readLine();
        }

        System.out.println("\n --- Connection closed ---");
    }

    @Override
    public void run() {

        try {

            serveClient();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //serveClient();
    }
}
