package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Fiat extends Car{

    private static final int VELOCITY = 1;

    public Fiat(CarType carType ,Position pos){

        super(carType ,pos, VELOCITY);
    }

}
