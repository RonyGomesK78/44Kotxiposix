package org.academiadecodigo.bootcamp.sniperelite;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObjectFactory;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.GameObject;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.Barrel;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.Tree;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.barreltype.BarrelFactory;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.enemy.Enemy;
import org.academiadecodigo.bootcamp.sniperelite.gameobject.weapons.SniperRifle;
import org.academiadecodigo.bootcamp.sniperelite.interfaces.Destroyable;

/**
 * Sniper Elite
 */
public class Game {

    public static final double ENEMY_PROBABILITY = 0.6;
    public static final int BULLET_DAMAGE = 1;

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;

    /**
     * Construct the game
     * @param numberObjects the number of game objects to create
     */
    public Game(int numberObjects) {

        this.gameObjects = createGameObjects(numberObjects);
        this.sniperRifle = new SniperRifle(BULLET_DAMAGE);

    }

    /**
     * Start shooting
     */
    public void start() {

        for (GameObject gameObject : gameObjects) {

            System.out.println(gameObject.getMessage());

            if (gameObject instanceof Destroyable) {


                Destroyable destroyable = (Destroyable) gameObject;
                while (!destroyable.isDestroyed()){

                    System.out.println("Making the shot...");
                    sniperRifle.shoot(destroyable);
                }
                /*if(gameObject instanceof Enemy){ // PARA ISSO QUE SERVE POLIMORFISMO BURROOOOO

                    Enemy eTarget = (Enemy) gameObject;
                    while (!eTarget.isDestroyed()) {

                        sniperRifle.shoot(eTarget);
                    }
                }
                else{

                   Barrel bTarget = (Barrel) gameObject;
                   while (!bTarget.isDestroyed()){

                        sniperRifle.shoot(bTarget);
                   }
                }*/

                System.out.println("Target is neutralized. I repeat, Target is neutralized!");
                System.out.println();
            }
        }

        System.out.println("All targets are down. I repeat all targets are down. " + sniperRifle.getShotsFired() + " shots.");

    }

    private GameObject[] createGameObjects(int numberObjects) {

        GameObject[] gameObjects = new GameObject[numberObjects];

        for (int i = 0; i <gameObjects.length ; i++) {

            //gameObjects[i] = Math.random() < ENEMY_PROBABILITY ? GameObjectFactory.createEnemy() : new Tree();
            double decide = Math.random();

            if(decide < ENEMY_PROBABILITY){

                gameObjects[i] = GameObjectFactory.createEnemy();
            }
            else if(decide >= ENEMY_PROBABILITY && decide < 0.8){

                gameObjects[i] = BarrelFactory.createBarrel();
            }
            else{

                gameObjects[i] = new Tree();
            }
        }

        return gameObjects;

    }

}
