package org.academiadecodigo.kotxiposix.histogram;

public class Main {

    public static void main(String[] args) {

        HistogramComposition histogramComposition = new HistogramComposition("Hello Samuel Samuela Rony Hello Is It Me Me Samuel");

        for (String word : histogramComposition) {

            System.out.println(word + " : " + histogramComposition.getValue(word));
        }

        System.out.println("------------------------------------------------------------------------------------------------------");

        HistogramInheritance histogramInheritance = new HistogramInheritance("hello world hello word");

        for (String word : histogramInheritance){

            System.out.println(word + " : " + histogramInheritance.get(word));
        }
    }
}
