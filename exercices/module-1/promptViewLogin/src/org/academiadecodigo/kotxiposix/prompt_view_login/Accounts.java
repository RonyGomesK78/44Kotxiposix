package org.academiadecodigo.kotxiposix.prompt_view_login;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Accounts {

    private static Map<String, String> accounts = new HashMap<>();

    private Accounts(){

        accounts = new HashMap<>();
    }

    public static void add(String user,String password){

        accounts.put(user, password);
    }

    public static Set<String> getUsernames(){

        return accounts.keySet();
    }

    public static String getPassword(String userName){

        return accounts.get(userName);
    }

    public static boolean containUserName(String userName){

        return accounts.containsKey(userName);
    }
}
