package org.academiadecodigo.kotxiposix.arabianNights;

public class Main {

    public static void main(String[] args) {

        int numberOfGenies = 3;

        MagicLamp lamp = new MagicLamp(numberOfGenies);

        System.out.println("THIS LAMP HAS " + lamp.getNumberOfGenies());
        System.out.println();

        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        //lamp.recharge();
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
        lamp.rub(RandomNumberGenerator.generateNumber(100) + 1);
    }
}
