package org.academiadecodigo.kotxiposix.hibernate.inheritance.mapped_superclass;

import org.academiadecodigo.kotxiposix.hibernate.entity.Transaction;

import javax.persistence.*;

public class AbstractTransaction implements Transaction {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("abstractModel");

    @Override
    public Object saveOrUpdate(Object object) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            Object savedObject = em.merge(object);
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
        return null;
    }
}
