package org.academiadecodigo.kotxiposix.hibernate.component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComponentTest {

    public static void main(String[] args) {

        Student student = new Student();
        Address address = new Address();
        address.setCity("Praia");
        student.setName("Americo");

        StudentTransaction studentTransaction = new StudentTransaction();
        studentTransaction.saveOrUpdate(student);
    }
}
