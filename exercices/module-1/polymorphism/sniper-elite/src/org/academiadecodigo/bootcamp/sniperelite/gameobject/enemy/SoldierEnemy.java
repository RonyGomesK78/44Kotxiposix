package org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy;

import org.academiadecodigo.bootcamp.sniperelite.interfaces.Destroyable;

/**
 * A Soldier enemy without any special behaviour
 */
public class SoldierEnemy extends Enemy implements Destroyable {

    /**
     * @see Enemy#Enemy(int)
     */
    public SoldierEnemy(int health) {

        super(health);
    }

    @Override
    public String getMessage() {

        return getClass().getSimpleName();
    }
}
