package org.academiadecodigo.kotxiposix.hibernate.inheritance.table_per_class;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "boat_table_per_class")
public class Boat extends Vehicle{

    private Integer engines;

    public Integer getEngines() {
        return engines;
    }

    public void setEngines(Integer engines) {
        this.engines = engines;
    }
}
