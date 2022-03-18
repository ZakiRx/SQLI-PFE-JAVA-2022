package org.sqli.authentification.entitie;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_group")
public class Group extends BaseClass{


    private String name;
    @OneToMany(mappedBy = "group")
    private List<User> users;
    public Group(){}
    public Group(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
