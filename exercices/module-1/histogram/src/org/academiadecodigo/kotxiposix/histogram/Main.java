package org.academiadecodigo.kotxiposix.histogram;

public class Main {

    public static void main(String[] args) {

        Histogram histogram = new Histogram("Hello Samuel Samuela Rony Hello Is It Me Me Samuel");

        for (String word : histogram) {

            System.out.println(word + " : " + histogram.getValue(word));
        }
    }
}
