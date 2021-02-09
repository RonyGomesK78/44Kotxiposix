package org.academiadecodigo.kotxiposix.prompt_view_login;

import examples.string.PasswordInputScannerTest;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Prompt prompt = new Prompt(System.in, System.out);

        Set<String> user = new HashSet<>();
        user.add("Luis");
        user.add("Rony");

        StringSetInputScanner username = new StringSetInputScanner(user);
        username.setMessage("Username : ");
        username.setError("Username is wrong");
        String name = prompt.getUserInput(username);


        PasswordInputScanner passwordInputScanner = new PasswordInputScanner();
        passwordInputScanner.setMessage("Password");
        passwordInputScanner.setError("Password is incorrect");


        String password = prompt.getUserInput(passwordInputScanner);

        while (!password.equals("marte")){

            password = prompt.getUserInput(passwordInputScanner);
        }
        System.out.println("Login Successfully!");


    }
}
