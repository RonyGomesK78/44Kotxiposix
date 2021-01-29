package org.academiadecodigo.kotxiposix.server_udp_uppercase;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class ServerUDP {


    private DatagramSocket socket = null;
    private DatagramPacket receivePacket;
    private DatagramPacket sendPacket;

    String message;

    private ServerUDP() {

        initServer();

    }

    private void initServer() {

        try {

            socket = new DatagramSocket(7878);

            listen();

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    private void listen() {

        while (!socket.isClosed()) {

            receivePacket = new DatagramPacket(new byte[1024], 1024);

            System.out.println("Listening on port " + socket.getLocalPort());

            try {

                socket.receive(receivePacket);

                disassemblePacket();

                sendPackage();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void disassemblePacket() {

        message = new String(receivePacket.getData(), StandardCharsets.UTF_8);
        System.out.println("Receiving this message : " + message + " from " + receivePacket.getAddress());
        System.out.println();
    }

    private void sendPackage() {

        byte[] data = message.toUpperCase().getBytes();

        sendPacket = new DatagramPacket(data, data.length, receivePacket.getAddress(), receivePacket.getPort());
        sendPacket.setData((new String(sendPacket.getData(), StandardCharsets.UTF_8).toUpperCase()).getBytes(StandardCharsets.UTF_8));

        try {

            socket.send(sendPacket);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ServerUDP serverUDP = new ServerUDP();
        serverUDP.listen();
    }
}
