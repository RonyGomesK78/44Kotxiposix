package org.academiadecodigo.kotxiposix.prompt_view_login;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.integer.IntegerInputScanner;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;

public class Menu {

    public int menu(){

        String[] options;
        options = new String[]{"LOGIN", "SIGN OUT"};

        Prompt prompt = new Prompt(System.in, System.out);
        MenuInputScanner menu = new MenuInputScanner(options);
        menu.setMessage("Hello...login or sign out?");
        return prompt.getUserInput(menu);
    }
}
