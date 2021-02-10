package org.academiadecodigo.kotxiposix.prompt_view_login;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.util.Set;

public class Login {

    private final Set<String> usernames;

    public Login(){

        usernames = Accounts.getUsernames();
    }

    public void login() throws InterruptedException {

        if (usernames.size() == 0){

            System.out.println("You can't login...you have to register before to login");
            return;
        }

        System.out.println("Insert your login credentials below:");

        Prompt prompt = new Prompt(System.in, System.out);

        StringSetInputScanner username = new StringSetInputScanner(usernames);
        username.setMessage("Username: ");
        username.setError("The username that you've entered doesn't match any account");
        String name = prompt.getUserInput(username);

        PasswordInputScanner passwordInputScanner = new PasswordInputScanner();
        passwordInputScanner.setMessage("Password: ");
        passwordInputScanner.setError("Password is incorrect");

        String password = prompt.getUserInput(passwordInputScanner);
        while (!password.equals(Accounts.getPassword(name))){

            System.out.println("Your password is incorrect");
            password = prompt.getUserInput(passwordInputScanner);
        }

        System.out.println("Login Successful!");
        System.out.println("Welcome home " + name);
        Thread.sleep(2000);
        System.out.println("Exiting...");
        Thread.sleep(2000);
    }
}
