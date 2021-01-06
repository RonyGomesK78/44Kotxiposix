package org.academiadecodigo.kotxiposix.sniperElite;

public class ArmouredEnemy extends Enemy{

    private int armour;

    public ArmouredEnemy(int health, int armour) {

        super(health);
        this.armour = armour;
    }

    @Override
    public String getMessage() {

        return getClass().getSimpleName() + " -> Armour : " + armour + " - Health : " + getHealth() ;
    }

    @Override
    public void hit(int damage) {


        if (armour > 0){

            armour -= damage;

            if (armour < 0){

                super.hit(damage - armour); //if damage = 3 and armour = 1 -> armour = 0 and health = health - 2
                armour = 0;
            }
        }
        else{

            super.hit(damage);
        }
    }

}
