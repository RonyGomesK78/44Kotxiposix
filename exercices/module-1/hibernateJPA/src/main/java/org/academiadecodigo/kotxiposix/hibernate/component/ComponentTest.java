package org.academiadecodigo.kotxiposix.hibernate.component;

import org.academiadecodigo.kotxiposix.hibernate.transaction.AbstractTransaction;
import org.academiadecodigo.kotxiposix.hibernate.transaction.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComponentTest {

    public static void main(String[] args) {

        Student student = new Student();
        Address address = new Address();
        address.setCity("Praia");
        student.setName("Americo");
        student.setAddress(address);

        AbstractTransaction studentTransaction = new AbstractTransaction("componentMap");
        studentTransaction.saveOrUpdate(student);
    }
}
