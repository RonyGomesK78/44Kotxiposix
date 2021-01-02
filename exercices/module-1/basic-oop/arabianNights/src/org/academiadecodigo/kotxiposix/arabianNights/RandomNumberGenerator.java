package org.academiadecodigo.kotxiposix.arabianNights;

import java.util.Random;

public class RandomNumberGenerator {

    static int generateNumber(int maxNumber){

        Random random = new Random();

        return random.nextInt(maxNumber);
    }
}
