package org.academiadecodigo.bootcamp.battle.fighters;

import org.academiadecodigo.bootcamp.battle.Utils;

public class Wizard extends Fighter {

    private static final int ATTACK_DAMAGE = 6;
    private static final int SPELL_DAMAGE = 20;
    private static final int INITIAL_HEALTH = 70;

    private static final int SHIELD_PROBABILITY = 15;

    private boolean shield;

    public Wizard(String name) {

        super(name, ATTACK_DAMAGE, SPELL_DAMAGE, INITIAL_HEALTH);
    }

    @Override
    public void cast(Fighter attackedFighter){

        if (Utils.getRandom(100) + 1 <= SHIELD_PROBABILITY){

            shield = true;
        }
        else {

            shield = false;
            super.cast(attackedFighter);
        }
    }

    @Override
    public void suffer(int attackedDamage){

        if (shield){

            System.out.println();
        }
        else {

            super.suffer(attackedDamage);
        }
    }
}
