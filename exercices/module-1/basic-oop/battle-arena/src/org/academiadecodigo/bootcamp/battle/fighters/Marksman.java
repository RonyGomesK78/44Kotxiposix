package org.academiadecodigo.bootcamp.battle.fighters;

import org.academiadecodigo.bootcamp.battle.Utils;

public class Marksman extends Fighter {

    private static final int ATTACK_DAMAGE = 30;
    private static final int SPELL_DAMAGE = 5;
    private static final int INITIAL_HEALTH = 50;

    private static final int CRITICAL_CHANCE = 10;
    private static final int CRITICAL_MULTIPLIER = 2;

    public Marksman(String name) {

        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }

    @Override
    public void attack(Fighter attackedFighter){

        if(Utils.getRandom(100) + 1 <= CRITICAL_CHANCE){

            super.suffer(ATTACK_DAMAGE * CRITICAL_MULTIPLIER);
        }
        else {

            super.attack(attackedFighter);
        }
    }
}
