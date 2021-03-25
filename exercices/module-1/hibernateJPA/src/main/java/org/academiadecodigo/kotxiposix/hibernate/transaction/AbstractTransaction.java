package org.academiadecodigo.kotxiposix.hibernate.transaction;

import org.academiadecodigo.kotxiposix.hibernate.entity.User;

import javax.persistence.*;

public class AbstractTransaction<T> implements Transaction<T>{


    EntityManagerFactory emf;

    public AbstractTransaction(String persistenceUnit){
        this.emf = Persistence.createEntityManagerFactory(persistenceUnit);
    }


    @Override
    public T saveOrUpdate(T object) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            T savedObject = em.merge(object);
            em.getTransaction().commit();

            return savedObject;
        }catch (RollbackException e){
            em.getTransaction().rollback();
            return null;
        }finally {
            if (em != null){
                em.close();
            }
        }

    }

    @Override
    public Object findById(Integer id) {

       /* EntityManager em = emf.createEntityManager();

        try {
            // fetch a new user using its id
            //return em.find(T.class, id); // always the primary key
            return em.find(Object.class, id); // always the primary key
        } finally {
            // make sure we close the database connection
            if (em != null) {
                em.close();
            }
        }*/

        return null;
    }
}
