package org.academiadecodigo.kotxiposix.hibernate.inheritance.table_per_class;

import org.academiadecodigo.kotxiposix.hibernate.inheritance.mapped_superclass.AbstractTransaction;

public class TablePerClassTest {

    public static void main(String[] args) {

        Boat boat = new Boat();
        boat.setEngines(5);
        boat.setMaxSpeed(20000);

        Car car = new Car();
        car.setGears(1);
        car.setMaxSpeed(300);

        AbstractTransaction abstractTransaction = new AbstractTransaction();
        abstractTransaction.saveOrUpdate(boat);
        abstractTransaction.saveOrUpdate(car);
    }
}
