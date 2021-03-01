package org.academiadecodigo.kotxiposix.hibernate.inheritance.single_table;

import org.academiadecodigo.kotxiposix.hibernate.inheritance.mapped_superclass.AbstractTransaction;

public class SingleTableTest {

    public static void main(String[] args) {

        Boat boat = new Boat();
        boat.setMaxSpeed(50000);
        boat.setEngines(2);

        Car car = new Car();
        car.setGears(1);
        car.setMaxSpeed(240);

        AbstractTransaction abstractTransaction = new AbstractTransaction();

        abstractTransaction.saveOrUpdate(boat);

        abstractTransaction.saveOrUpdate(car);
    }
}
