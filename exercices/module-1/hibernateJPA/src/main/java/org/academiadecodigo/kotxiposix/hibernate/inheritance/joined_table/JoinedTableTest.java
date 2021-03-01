package org.academiadecodigo.kotxiposix.hibernate.inheritance.joined_table;

import org.academiadecodigo.kotxiposix.hibernate.inheritance.mapped_superclass.AbstractTransaction;
import org.academiadecodigo.kotxiposix.hibernate.inheritance.joined_table.Boat;
import org.academiadecodigo.kotxiposix.hibernate.inheritance.table_per_class.Car;

public class JoinedTableTest {

    public static void main(String[] args) {

        Boat boat = new Boat();
        boat.setEngines(5);
        boat.setMaxSpeed(20000);
        boat.setId(1);

        Car car = new Car();
        car.setId(2);
        car.setGears(1);
        car.setMaxSpeed(300);

        AbstractTransaction abstractTransaction = new AbstractTransaction();
        abstractTransaction.saveOrUpdate(boat);
        abstractTransaction.saveOrUpdate(car);
    }
}
