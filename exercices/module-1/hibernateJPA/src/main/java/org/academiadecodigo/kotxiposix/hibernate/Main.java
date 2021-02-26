package org.academiadecodigo.kotxiposix.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");

        EntityManager  em = emf.createEntityManager();

        System.out.println("Result id: " + em.createNativeQuery("SELECT 1 + 1").getSingleResult());

    }
}
