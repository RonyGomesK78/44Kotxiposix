package org.academiadecodigo.kotxiposix.sniperElite;

public class Game {

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle;
    private int shotsFire;

    public Game(SniperRifle sniperRifle, int numberOfObjects){

        this.sniperRifle = sniperRifle;
        this.shotsFire = 0;
        gameObjects = createObjects(numberOfObjects);
    }

    private GameObject[] createObjects(int numberOfObjects){

        GameObject[] gameObjects = new GameObject[numberOfObjects];

        for (int i = 0; i < numberOfObjects; i++){

            int decide = Utils.getTreeOrEnemies();

            if (decide >= 0 && decide <= 39){

                gameObjects[i] = new ArmouredEnemy(10, 14);
            }
            else if(decide >= 40 && decide <= 79){

                gameObjects[i] = new SoldierEnemy(15);
            }

            else {

                gameObjects[i] = new Tree();
            }

        }

        return gameObjects;
    }

    public void start(){

        for (int i = 0; i < gameObjects.length; i++){

            if(gameObjects[i] instanceof Enemy){

                Enemy enemy = (Enemy)gameObjects[i];

                while(!enemy.isDead()){

                    sniperRifle.shoot((Enemy) gameObjects[i]);
                    shotsFire++;
                    System.out.println(gameObjects[i].getMessage());
                }

                System.out.println("#############################################");
                System.out.println();
            }

            else {

                System.out.println(gameObjects[i].getMessage());
            }
        }

        System.out.println("Total number of shots : " + shotsFire);
    }

}
