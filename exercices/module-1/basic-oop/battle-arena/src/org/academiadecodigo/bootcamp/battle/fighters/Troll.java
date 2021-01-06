package org.academiadecodigo.bootcamp.battle.fighters;

import org.academiadecodigo.bootcamp.battle.Utils;

public class Troll extends Fighter {

    private static final int ATTACK_DAMAGE = 8;
    private static final int SPELL_DAMAGE = 2;
    private static final int INITIAL_HEALTH = 300;

    private static final int ATTACK_POSSIBILITY = 50;

    public Troll(String name) {

        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }

    @Override
    public void attack(Fighter attackedFighter){

        if(Utils.getRandom(100) + 1 <= INITIAL_HEALTH ){

            super.attack(attackedFighter);
        }
        else{

            System.out.println("Troll can´t attack now, he is confused");
        }
    }
}
