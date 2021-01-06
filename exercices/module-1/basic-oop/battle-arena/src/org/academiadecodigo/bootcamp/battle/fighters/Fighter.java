package org.academiadecodigo.bootcamp.battle.fighters;

public class Fighter {

    private int attackDamage;
    private int spellDamage;
    private int health;

    private String name;

    private boolean dead = false;

    public Fighter(String name, int attackDamage, int spellDamage, int health) {

        this.name = name;
        this.attackDamage = attackDamage;
        this.spellDamage = spellDamage;
        this.health = health;
    }

    public boolean isDead(){

        if (health <= 0){

            dead = true;
        }

        return dead;
    }

    public void attack(Fighter attackedFighter){

        attackedFighter.suffer(attackDamage);
    }

    public void suffer(int sufferDamage){

        if (isDead()){

            return;
        }
        health -= sufferDamage;
    }

    public void cast(Fighter attackedFighter){

        attackedFighter.suffer(spellDamage);
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "health=" + health +
                ", name='" + name + '\'' +
                ", dead=" + dead +
                '}';
    }
}
