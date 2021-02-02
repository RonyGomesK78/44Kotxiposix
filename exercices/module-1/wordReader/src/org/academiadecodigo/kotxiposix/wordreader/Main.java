package org.academiadecodigo.kotxiposix.wordreader;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        WordReader wordReader;

        try {

          wordReader = new WordReader("/Users/codecadet/44kotxiposix/exercices/module-1/wordReader/files/file.txt");

          String line = "";

            for (String readLine : wordReader) {

                System.out.println(readLine);
            }

        } catch (FileNotFoundException e) {

            System.out.println("File not found");
        } catch (IOException e) {

            System.out.println("Error when read from the file");
        }

    }
}
