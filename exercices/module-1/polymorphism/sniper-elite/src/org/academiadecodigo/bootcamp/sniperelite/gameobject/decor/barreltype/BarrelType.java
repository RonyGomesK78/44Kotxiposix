package org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.barreltype;

public enum BarrelType {

    PLASTIC(1),
    WOOD(3),
    METAL(10);

    private int maxDamage;

    BarrelType(int damage){

        this.maxDamage = damage;
    }

}
