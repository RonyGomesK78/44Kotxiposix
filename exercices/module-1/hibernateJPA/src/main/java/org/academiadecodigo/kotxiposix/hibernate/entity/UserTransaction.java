package org.academiadecodigo.kotxiposix.hibernate.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class UserTransaction implements Transaction{

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("entity");

    @Override
    public User saveOrUpdate(User user) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            User savedUser = em.merge(user);
            em.getTransaction().commit();

            return savedUser;
        }catch (RollbackException ex){

            em.getTransaction().rollback();
            return null;

        }finally {
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public User findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            return em.find(User.class, id); // always the primary key
        }catch (RollbackException ex){

            em.getTransaction().rollback();
            return null;

        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }
    }
}
