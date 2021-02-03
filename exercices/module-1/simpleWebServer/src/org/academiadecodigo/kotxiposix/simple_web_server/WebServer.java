package org.academiadecodigo.kotxiposix.simple_web_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private ServerSocket serverSocket;
    private Socket connection;

    private FileSystem fileSystem;

    private boolean isValidRequest = true;

    private String url;
    private String requestLine;

    private void init() {


        try {

            serverSocket = new ServerSocket(7887);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void establishConnection() {

        try {

            connection = serverSocket.accept();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {

        establishConnection();

        while (!serverSocket.isClosed()) {

            receiveRequest();

            analiseRequest();

            sendResponse();
        }
    }

    private void receiveRequest() {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            requestLine = bufferedReader.readLine();

            /*while ((requestLine = bufferedReader.readLine()) != null) {

                System.out.println(requestLine);
            }*/

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private void analiseRequest() {

        if (requestLine == null) {

            isValidRequest = false;
            return;
        }

        String[] split = requestLine.split("/");
        String verb = split[0];

        if (!verb.equals("GET ")) {

            isValidRequest = false;
            return;
        }

        url = "/Users/codecadet/44kotxiposix/exercices/module-1" +
                "/simpleWebServer/src/org/academiadecodigo/kotxiposix" +
                "/simple_web_server/www/" + split[1].split(" ")[0];

        System.out.println(requestLine);
    }

    private boolean fetchData(String url) {

        File file = new File(url);

        fileSystem = new FileSystem();

        return fileSystem.compare(file);
    }

    private void sendResponse() {

        try {

            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);

            fileSystem = new FileSystem();

            FileReader fileReader;

            BufferedReader bufferedReader;

            if (fetchData(url)) {

                fileReader = new FileReader(fileSystem.files[0]);
                bufferedReader = new BufferedReader(fileReader);

                String response = "HTTP/1.0 200 OK\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: <file_byte_size> \r\n" +
                        "\r\n";

                out.println(response);

                String line;
                while ((line = bufferedReader.readLine()) != null) {

                    out.println(line);
                }

            } else {

                fileReader = new FileReader(fileSystem.files[1]);
                bufferedReader = new BufferedReader(fileReader);

                out.println("HTTP/1.0 404 Not Found\r\n" +
                        "Content-Type: text/html; charset=UTF-8\r\n" +
                        "Content-Length: <file_byte_size> \r\n" +
                        "\r\n");

                String line;
                while ((line = bufferedReader.readLine()) != null) {

                    out.println(line);
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        WebServer webServer = new WebServer();

        webServer.init();
        webServer.start();
    }
}
