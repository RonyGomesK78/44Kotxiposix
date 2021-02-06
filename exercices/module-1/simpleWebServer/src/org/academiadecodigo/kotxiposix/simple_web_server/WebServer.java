package org.academiadecodigo.kotxiposix.simple_web_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    private ServerSocket serverSocket;
    private Socket connection;

    private File file;
    private String statusCode;

    private String requestLine;
    private String content_type = "Content-Type: ";

    private void init() {

        try {

            serverSocket = new ServerSocket(7887);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void establishConnection() {

        try {

            System.out.println("Listening for connection request on " +
                    serverSocket.getLocalSocketAddress() + "...");
            connection = serverSocket.accept();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {

        establishConnection();

        while (!connection.isClosed()) {

            receiveRequest();
            sendResponse();
            establishConnection();
        }
    }

    private void receiveRequest() {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";

            requestLine = "";

            while ((line = bufferedReader.readLine()) != null && !(line.isEmpty())) {

                requestLine += line + "\n";
            }

            System.out.println(requestLine);

            analiseRequest();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private void analiseRequest() {


        if (requestLine == null || requestLine.isEmpty()) {

            statusCode = "HTTP/1.0 400 Bad Request\r\n";
            content_type += " ";
            file = new File("www/notValid.html");

            return;
        }

        String[] splitter = requestLine.split("/");
        String verb = splitter[0];
        String url = splitter[1].split(" ")[0];

        if (!verb.equals("GET ")) {

            statusCode = "HTTP/1.0 405 Method Not Allowed\r\n";
            content_type += url;
            file = new File("www/unsupportedVerb.html");

            return;
        }

        System.out.println(url);

        file = inspectUrl(url);


    }

    private File inspectUrl(String url) {

        if (!url.contains(".")) {

            statusCode = "HTTP/1.0 415 Unsupported Media Type\r\n";
            content_type += "unknown";

            System.out.println("not contain .");

            return new File("www/html/notValid.html");

        } else {

            String mimeType = url.substring(url.indexOf(".") + 1);

            System.out.println(mimeType);

            File file = new File("www/" + mimeType + "/" + url);
            content_type += "text/" + mimeType + ";" + " charset=UTF-8\r\n";

            if (file.exists()) {

                System.out.println("File exists");

                statusCode = "HTTP/1.0 200 OK\r\n";
                return file;

            } else {

                statusCode = "HTTP/1.0 Not Found";
                System.out.println("not exists");
                return new File("www/html/notFound.html");
            }

        }
    }

    private void sendResponse() {

        try {

            PrintWriter out = new PrintWriter(connection.getOutputStream(), true);

            FileReader fileReader;

            BufferedReader bufferedReader;

            fileReader = new FileReader(file);

            bufferedReader = new BufferedReader(fileReader);

            out.println(statusCode +
                    content_type +
                    "Content-Length: 300 \r\n\r\n");

            String line;

            while ((line = bufferedReader.readLine()) != null) {

                out.println(line);
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
