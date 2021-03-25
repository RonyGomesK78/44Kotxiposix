package org.academiadecodigo.kotxiposix.hibernate.entity;

import org.academiadecodigo.kotxiposix.hibernate.transaction.AbstractTransaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

public class Entity {

    public static void main(String[] args) {

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        System.out.println("Result id: " + em.createNativeQuery("SELECT 1 + 1").getSingleResult());*/

        AbstractTransaction abstractTransaction = new AbstractTransaction("entity");

        User user1 = new User();

        user1.setEmail("alvinho@email.com");
        user1.setId(1);
        user1.setName("americo");
        user1.setPassword("capitao");

        abstractTransaction.saveOrUpdate(user1);

       User retrieved = (User)abstractTransaction.findById(user1.getId());
        System.out.println(retrieved.getName());
    }
}
