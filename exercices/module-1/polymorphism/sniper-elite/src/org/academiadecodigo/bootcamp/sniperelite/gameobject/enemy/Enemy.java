package org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObject;
import org.academiadecodigo.bootcamp.sniperelite.interfaces.Destroyable;

/**
 * An enemy class containing generic enemy functionality and meant for subclassing
 */
public abstract class Enemy extends GameObject implements org.academiadecodigo.bootcamp.sniperelite.interfaces.Destroyable {

    private int health;
    private boolean dead;

    /**
     * Generic enemy constructor
     * @param health the initial health
     */
    public Enemy(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public boolean isDestroyed() {
        return dead;
    }

    /**
     * Removes health according to the hit damage
     * @param damage the damage impact
     */


    @Override
    public void hit(int damage) {

        health = health - damage > 0 ? health - damage : 0;

        if (health == 0) {
            dead = true;
        }

    }

    /**
     * @see GameObject#getMessage()
     */
    @Override
    public String getMessage() {
        return "Tango Acquired. Taking it down!";
    }

}
