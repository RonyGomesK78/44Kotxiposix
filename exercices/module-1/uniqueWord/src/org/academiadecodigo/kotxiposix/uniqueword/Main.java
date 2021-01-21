package org.academiadecodigo.kotxiposix.uniqueword;

public class Main {

    public static void main(String[] args) {

        UniqueWord uniqueWord = new UniqueWord(" hello word Hello Hello word  foca");

        for (String word : uniqueWord) {

            System.out.println(word);
        }

    }
}
