package org.academiadecodigo.kotxiposix.prompt_view_login;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerRangeInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.util.Set;

public class SignUp {

    public SignUp(){
    }

    public void signUp() throws InterruptedException {

        System.out.println("CREATE NEW ACCOUNT.");

        Prompt prompt = new Prompt(System.in, System.out);

        StringInputScanner username = new StringInputScanner();
        username.setMessage("Create a username: ");

        String name = prompt.getUserInput(username);
        while (Accounts.containUserName(name)){

            System.out.println("The user that you've have entered is already exists");
            name = prompt.getUserInput(username);
        }

        StringInputScanner pass = new StringInputScanner();
        pass.setMessage("Create a password: ");
        String passcode = prompt.getUserInput(pass);

        Accounts.add(name, passcode);

        System.out.println("Registration Successful!");
        System.out.println("Welcome your new home " + name);
        Thread.sleep(2000);
        System.out.println("Exiting...");
        Thread.sleep(2000);
    }
}
