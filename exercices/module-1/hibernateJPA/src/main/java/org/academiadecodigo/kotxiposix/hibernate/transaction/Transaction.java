package org.academiadecodigo.kotxiposix.hibernate.entity;

public interface Transaction<T> {

    public T saveOrUpdate(T object);
    public T findById(Integer id);
}
