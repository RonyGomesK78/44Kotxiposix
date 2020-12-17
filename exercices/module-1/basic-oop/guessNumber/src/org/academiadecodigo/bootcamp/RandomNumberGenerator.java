package org.academiadecodigo.bootcamp;

import java.util.Random;

public class RandomNumberGenerator {

    static int generateNumber(int maxNumber){

        Random random = new Random();

        return random.nextInt(maxNumber);
    }
}
