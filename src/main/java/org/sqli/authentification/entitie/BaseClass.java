package org.sqli.authentification.entitie;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseClass {
    @Id
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
