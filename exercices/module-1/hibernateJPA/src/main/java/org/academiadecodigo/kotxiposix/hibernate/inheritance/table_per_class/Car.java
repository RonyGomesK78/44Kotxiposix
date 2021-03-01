package org.academiadecodigo.kotxiposix.hibernate.inheritance.table_per_class;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "car_table_per_class")
public class Car extends Vehicle{

    private Integer gears;

    public Integer getGears() {
        return gears;
    }

    public void setGears(Integer gears) {
        this.gears = gears;
    }
}
