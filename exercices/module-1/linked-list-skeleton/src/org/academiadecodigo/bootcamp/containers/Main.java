package org.academiadecodigo.bootcamp.containers;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> cadetNames = new LinkedList<>();

        /*cadetNames.add("Rony");
        cadetNames.add("Edmilson");
        cadetNames.add("Cifra");
        cadetNames.add("Sandro");
        cadetNames.add("Aldino");*/

        cadetNames.add("Samuel");
        String[] names = {"Cifra", "Edmilson", "Romilton", "Sandro", "Aldino"};
        cadetNames.add(names);

        cadetNames.add("Elvin", 3);

        //System.out.println(cadetNames.get(0) + " : " + cadetNames.size());

        //cadetNames.remove("Rony");
        cadetNames.remove("Sandro");


        for (String name : cadetNames) {

            System.out.println(name);
        }

        cadetNames.undoLastRemoved();
        cadetNames.add("PP", 7);
        cadetNames.remove("PP");
        cadetNames.undoLastRemoved();
        System.out.println("...................");
        for (int i = 0; i < cadetNames.size(); i++) {

            System.out.println(cadetNames.get(i) + " : " + i);
        }


    }
}
