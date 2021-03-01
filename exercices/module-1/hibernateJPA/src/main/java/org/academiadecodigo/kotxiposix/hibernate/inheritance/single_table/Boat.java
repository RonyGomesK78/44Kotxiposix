package org.academiadecodigo.kotxiposix.hibernate.inheritance.single_table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "BoatSingleTable")
@DiscriminatorValue("boat")
public class Boat extends Vehicle{

    private Integer engines;

    public Integer getEngines() {
        return engines;
    }

    public void setEngines(Integer engines) {
        this.engines = engines;
    }
}
