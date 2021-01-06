package org.academiadecodigo.kotxiposix.sniperElite;

import java.util.Random;

public class Utils {

    public static int getRandom(int bounds){

        Random random = new Random();

        return random.nextInt(bounds);
    }

    public static int getTreeOrEnemies(){

        Random random = new Random();

        return random.nextInt(100);
    }
}
