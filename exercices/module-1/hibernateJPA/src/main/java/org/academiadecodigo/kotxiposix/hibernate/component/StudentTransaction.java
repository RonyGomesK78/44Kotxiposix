package org.academiadecodigo.kotxiposix.hibernate.component;

import org.academiadecodigo.kotxiposix.hibernate.entity.Transaction;
import org.academiadecodigo.kotxiposix.hibernate.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

public class StudentTransaction implements Transaction<Student> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("addressComponent");


    @Override
    public Student saveOrUpdate(Student student) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            Student savedStudent = em.merge(student);
            em.getTransaction().commit();

            return savedStudent;
        }catch(RollbackException ex){
            em.getTransaction().rollback();
            return null;
        }finally {
            if (em != null){
                em.close();
            }
        }
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }
}
