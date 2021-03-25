package org.academiadecodigo.kotxiposix.hibernate.associations.one_to_one;

import org.academiadecodigo.kotxiposix.hibernate.transaction.AbstractTransaction;

public class OneToOneTest {

    public static void main(String[] args) {

       Owner owner = new Owner();
        owner.setName("Ana");

        Car car = new Car();
        car.setMake("Toyota");
        car.setModel("Hilux");
        car.setOwner(owner);
        owner.setCar(car);

        AbstractTransaction abstractTransaction = new AbstractTransaction("oneToOne");
        abstractTransaction.saveOrUpdate(owner);
        abstractTransaction.saveOrUpdate(car);

    }
}
