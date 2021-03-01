package org.academiadecodigo.kotxiposix.hibernate.inheritance.joined_table;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "CarJoinedTable")
@Table(name = "car_joined_tabled")

public class Car extends Vehicle{

    private Integer  engines;
}
