package org.academiadecodigo.kotxiposix.sniperElite;

public class SoldierEnemy extends Enemy{

    public SoldierEnemy(int health){

        super(health);
    }

    @Override
    public String getMessage() {

        return getClass().getSimpleName() + " -> Health : " + getHealth() ;
    }
}
