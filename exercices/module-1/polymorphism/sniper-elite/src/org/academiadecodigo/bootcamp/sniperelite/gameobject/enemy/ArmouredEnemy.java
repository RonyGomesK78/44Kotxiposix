package org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy;

import org.academiadecodigo.bootcamp.sniperelite.interfaces.Destroyable;

/**
 * An enemy with an armour
 */
public class ArmouredEnemy extends Enemy implements Destroyable {

    private int armour;

    /**
     * Constructs an armoured enemy
     * @param health the initial health
     * @param armour the initial armour
     */
    public ArmouredEnemy(int health, int armour) {
        super(health);
        this.armour = armour;
    }

    /**
     * Damage hits armour, if armour is lost it proceeds to take damage
     * @see Enemy#hit(int)
     */
    @Override
    public void hit(int damage) {

        if (armour > damage) {
            armour -= damage;
            return;
        }

        damage -= armour;
        armour = 0;
        super.hit(damage);
    }

    @Override
    public String getMessage() {

        return getClass().getSimpleName();
    }
}
