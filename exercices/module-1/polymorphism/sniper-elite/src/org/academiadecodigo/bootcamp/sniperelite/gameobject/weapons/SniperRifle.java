package org.academiadecodigo.bootcamp.sniperelite.gameobject.weapons;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.Barrel;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.sniperelite.interfaces.Destroyable;

/**
 * A sniper rifle used to kill enemies
 */
public class SniperRifle {

    public static final double HIT_PROBABILITY = 0.7;

    private int shotsFired;
    private int bulletDamage;

    /**
     * Constructs a sniper rifle
     * @param bulletDamage the amount of damaged caused by each shot
     */
    public SniperRifle(int bulletDamage) {
        this.shotsFired = 0;
        this.bulletDamage = bulletDamage;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Take a shoot at an enemy
     * @param target the enemy to shoot
     */
    public void shoot(Destroyable target) {

        shotsFired++;

        if(Math.random() < HIT_PROBABILITY) {

            if(target instanceof Enemy){

                Enemy eTarget = (Enemy)target;
                eTarget.hit(bulletDamage);
            }
            else{

                Barrel bTarget = (Barrel)target;
                bTarget.hit(bulletDamage);

            }
            //target.hit(bulletDamage);

            System.out.println("It's a hit!");
        }
        else {
            System.out.println("It's a miss!");
        }

    }
}
