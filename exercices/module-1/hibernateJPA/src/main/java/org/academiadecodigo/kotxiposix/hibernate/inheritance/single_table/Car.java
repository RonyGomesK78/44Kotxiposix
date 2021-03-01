package org.academiadecodigo.kotxiposix.hibernate.inheritance.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "CarSingleTable")
@DiscriminatorValue("car")
public class Car extends Vehicle{

    private Integer gears;

    public Integer getGears() {
        return gears;
    }

    public void setGears(Integer gears) {
        this.gears = gears;
    }
}
