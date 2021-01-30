package org.academiadecodigo.kotxiposix.client_udp_uppercase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ClientUDP {


    private DatagramSocket socket = null;
    private DatagramPacket packetToSend;
    private DatagramPacket receivePacket;

    private BufferedReader reader;

    private String message;

    private ClientUDP() {

        initClient();
    }

    private void initClient() {

        try {

            socket = new DatagramSocket();

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private void getUserInput() {

        System.out.print("Enter a message to be sent : ");

        try {

            reader = new BufferedReader(new InputStreamReader(System.in));
            message = reader.readLine();

        } catch (IOException e) {
            System.out.println("An I/O error was occurred");
            e.printStackTrace();
        }
    }

    private void sendMessage(){

        try {

            packetToSend = new DatagramPacket(new byte[1024], 1024, InetAddress.getByName("192.168.1.118"), 7878);

            packetToSend.setData(message.getBytes());

            socket.send(packetToSend);

            receiveResponse();

        } catch (UnknownHostException e) {
            System.out.println("Can't resolve the host provider on the specific port");
            e.printStackTrace();

        } catch (IOException e) {
            System.out.println("An error occurred while sending");
            e.printStackTrace();
        }
    }

    private void receiveResponse(){

        receivePacket = new DatagramPacket(new byte[1024], 1024);

        try {

            socket.receive(receivePacket);

            System.out.println("Receiving this message from server : " + new String(receivePacket.getData()));

        } catch (IOException e) {
            System.out.println("An error occurred while sending");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ClientUDP clientUDP = new ClientUDP();
        clientUDP.getUserInput();
        clientUDP.sendMessage();
    }
}
