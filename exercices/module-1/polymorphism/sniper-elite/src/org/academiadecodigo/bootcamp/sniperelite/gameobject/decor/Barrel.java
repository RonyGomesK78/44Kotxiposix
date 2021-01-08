package org.academiadecodigo.bootcamp.sniperelite.gameobject.decor;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObject;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.barreltype.BarrelType;
import org.academiadecodigo.bootcamp.sniperelite.interfaces.Destroyable;

public class Barrel extends GameObject implements Destroyable {

    private int currentDamage;
    private boolean destroyed;
    private BarrelType barrelType;

    public Barrel(BarrelType barrelType){

        this.currentDamage = 0;
        this.barrelType = barrelType;
        destroyed = false;
    }

    @Override
    public void hit(int damage) {

        if (!isDestroyed()){

            currentDamage += damage;
            if (currentDamage >= barrelType.getMaxDamage()) {

                currentDamage = barrelType.getMaxDamage();
                destroyed = true;
            }
        }

    }

    @Override
    public boolean isDestroyed() {

        return destroyed;
    }

    @Override
    public String getMessage() {

        return getClass().getSimpleName() + " " + barrelType.name();
    }
}
