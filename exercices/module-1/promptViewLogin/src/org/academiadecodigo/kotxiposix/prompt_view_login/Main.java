package org.academiadecodigo.kotxiposix.prompt_view_login;

import examples.string.PasswordInputScannerTest;
import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.lang.invoke.SwitchPoint;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        Menu menu = new Menu();

        SignUp signUp = new SignUp();
        Login login = new Login();

        while (true) {

            int chosen = menu.menu();

            switch (chosen) {
                case 1:
                    login.login();
                    break;
                case 2:
                    signUp.signUp();
                    break;
            }
        }

    }
}
