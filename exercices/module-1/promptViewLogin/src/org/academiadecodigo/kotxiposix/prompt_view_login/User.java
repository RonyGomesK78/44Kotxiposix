package org.academiadecodigo.kotxiposix.prompt_view_login;

import java.util.Map;

public class User {

    private final Map<String, Integer> credential;

    public User(Map<String, Integer> credential) {
        this.credential = credential;
    }
}
