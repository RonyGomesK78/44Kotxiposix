package org.academiadecodigo.kotxiposix.prompt_view_login;

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
