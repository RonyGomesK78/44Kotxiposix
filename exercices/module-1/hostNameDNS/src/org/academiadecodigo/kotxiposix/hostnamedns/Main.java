package org.academiadecodigo.kotxiposix.hostnamedns;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    private static String host = "www.abola.pt";

    public static void main(String[] args) {

        System.out.println("Enter a host name: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String hostName = "";

        try {

            hostName = bufferedReader.readLine();

            //System.out.println(hostName);

        } catch (IOException e) {
            e.printStackTrace();

        }

        try {

            InetAddress inetAddress = InetAddress.getByName(hostName);
            System.out.println(inetAddress.getHostAddress() + " : " + (inetAddress.isReachable(10000) ? "OK" : "FAIL"));

        } catch (UnknownHostException e) {
            System.out.println("Unknown host");

        } catch (IOException e) {
            System.out.println("Something went wrong with your network...try again later");

        } catch (IllegalArgumentException e) {
            System.out.println("your argument on the isReachable method can't be negative");
        }
    }
}
