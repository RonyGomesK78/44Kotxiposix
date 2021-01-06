package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Utils;
import org.academiadecodigo.carcrash.field.Field;
import org.academiadecodigo.carcrash.field.Position;

import java.util.Random;

public class CarFactory {

    public static Car getNewCar() {

        Position position = new Position(Utils.getRandom(Field.getHeight()), Utils.getRandom(Field.getWidth()));

        int chooseCar = Utils.getRandom(2);

        Car car;

        if (chooseCar == 0){

            car = new Fiat(CarType.FIAT ,position);
        }
        else {

            car = new Mustang(CarType.MUSTANG, position);
        }


        return car;
    }
}
