package org.academiadecodigo.kotxiposix.hibernate.inheritance.mapped_superclass;

import org.academiadecodigo.kotxiposix.hibernate.transaction.AbstractTransaction;

public class TestMappedSuperClass {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setName("Carlos");

        Account account = new Account();
        account.setBalance(2220.5);

        AbstractTransaction abstractTransaction = new AbstractTransaction("mappedInheritance");
        abstractTransaction.saveOrUpdate(customer);
        abstractTransaction.saveOrUpdate(account);
    }
}
