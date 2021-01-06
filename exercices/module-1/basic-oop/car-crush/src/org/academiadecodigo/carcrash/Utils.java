package org.academiadecodigo.carcrash;

import java.util.Random;

public class Utils {

    public static int getRandom(int maxNumber){

        Random random = new Random();
        return random.nextInt(maxNumber);
    }
}
