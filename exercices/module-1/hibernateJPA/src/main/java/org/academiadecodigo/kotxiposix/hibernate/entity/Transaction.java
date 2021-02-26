package org.academiadecodigo.kotxiposix.hibernate.entity;

public interface Transaction {

    public User saveOrUpdate(User user);
    public User findById(Integer id);
}
