package org.academiadecodigo.kotxiposix.hibernate.associations.many_to_one;

import org.academiadecodigo.kotxiposix.hibernate.transaction.AbstractTransaction;

public class ManyToOnetest {

    public static void main(String[] args) {

        Product product = new Product();
        product.setName("mobile");

        Category category = new Category();
        category.setName("Technology");
        category.addProduct(product);

        AbstractTransaction abstractTransaction = new AbstractTransaction("manyToOne");
        abstractTransaction.saveOrUpdate(category);
        abstractTransaction.saveOrUpdate(product);
    }
}
