package org.academiadecodigo.kotxiposix.rockPaperScissors;

import java.util.Random;

public class Player {

    private String name;
    private int score = 0;

    public Player(String name){

        this.name  = name;
    }

    public RockPaperScissors chooseObject(){

        Random random = new Random();
        return RockPaperScissors.values()[random.nextInt(3)];
    }

    public void score(){

        score++;
    }

    public String getName(){

        return name;
    }

    public int getScore(){

        return score;
    }
}
