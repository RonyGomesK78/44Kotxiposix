package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Mustang extends Car{

    private static final int VELOCITY= 2;

    public Mustang(CarType carType, Position position){

        super(carType, position, VELOCITY);
    }


}
