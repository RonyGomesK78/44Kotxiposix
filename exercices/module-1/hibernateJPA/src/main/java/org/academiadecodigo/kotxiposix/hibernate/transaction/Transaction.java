package org.academiadecodigo.kotxiposix.hibernate.transaction;

public interface Transaction<T> {

    public T saveOrUpdate(T object);
    //public T findById(Integer id);
    public Object findById(Integer id);
}
