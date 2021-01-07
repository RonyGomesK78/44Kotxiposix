package org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.barreltype;

import org.academiadecodigo.bootcamp.sniperelite.gameobject.decor.Barrel;

public class BarrelFactory {

    public static Barrel createBarrel(){

        double decide = Math.random();

        if(decide < 0.5){

            return new Barrel(BarrelType.PLASTIC);
        }
        else if(decide >= 0.5 && decide < 0.8){

            return new Barrel(BarrelType.WOOD);
        }

        return new Barrel(BarrelType.METAL);
    }
}
