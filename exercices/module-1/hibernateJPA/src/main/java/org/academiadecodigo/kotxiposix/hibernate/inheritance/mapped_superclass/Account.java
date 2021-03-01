package org.academiadecodigo.kotxiposix.hibernate.inheritance.mapped_superclass;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account extends AbstractModel{

    private Double balance;
}
