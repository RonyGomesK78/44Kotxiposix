package org.academiadecodigo.kotxiposix.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Entity {

    public static void main(String[] args) {

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

        EntityManager em = emf.createEntityManager();

        System.out.println("Result id: " + em.createNativeQuery("SELECT 1 + 1").getSingleResult());*/

        UserTransaction userTransaction = new UserTransaction();

      /*  User user1 = new User();

        user1.setEmail("alvinho@email.com");
        user1.setId(1);
        user1.setName("americo");
        user1.setPassword("capitao");

        userTransaction.saveOrUpdate(user1);*/


        User user2;
        user2 = userTransaction.findById(1);

        System.out.println(user2);
    }
}
