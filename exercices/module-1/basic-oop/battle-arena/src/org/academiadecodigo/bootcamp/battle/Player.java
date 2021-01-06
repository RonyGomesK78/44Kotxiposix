package org.academiadecodigo.bootcamp.battle;

import org.academiadecodigo.bootcamp.battle.fighters.Fighter;

import java.util.Arrays;
import java.util.Random;

public class Player {

    private String name;
    private final Fighter[] fighters;

    public Player(String name, Fighter[] fighters){

        this.name = name;
        this.fighters = fighters;
    }

    public void pAttack(Player attackedPlayer){

        if (Utils.getRandom(2) % 2 == 0){

            chooseFighter().attack(attackedPlayer.chooseFighter());
        }
        else {

            chooseFighter().cast(attackedPlayer.chooseFighter());
        }
    }

    private Fighter chooseFighter(){

        int chooseFighter = -1;
        for (int i = 0; i < fighters.length; i++) {

            chooseFighter = Utils.getRandom(3);

            if (!(fighters[chooseFighter].isDead())){

                break;
            }
        }

        return fighters[chooseFighter];
    }

    public boolean lost(){

        for (int i = 0; i < fighters.length; i++){

            if (fighters[i].isDead()){

                continue;
            }
            else{

                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", fighters=" + Arrays.toString(fighters) +
                '}';
    }
}



