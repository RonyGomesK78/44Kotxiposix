package org.academiadecodigo.kotxiposix.sniperElite;

public abstract class Enemy extends GameObject{

    private int health;
    private boolean isDead;

    public Enemy(){

    }

    public Enemy(int health){

        this.health = health;
        isDead = false;
    }

    public int getHealth() {

        return health;
    }

    public boolean isDead(){

        if (health <= 0){

            setDead();
        }

        return isDead;
    }

    public void setDead() {

        isDead = true;
    }

    public void hit(int damage){

        health -= damage;

        if(health < 0){

            health = 0;
        }

        getMessage();
    }
}
