package org.academiadecodigo.kotxiposix.hibernate.inheritance.mapped_superclass;

public class TestMappedSuperClass {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setName("Carlos");
        AbstractTransaction abstractTransaction = new AbstractTransaction();
        abstractTransaction.saveOrUpdate(customer);
    }
}
