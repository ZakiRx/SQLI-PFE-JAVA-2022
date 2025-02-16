package org.sqli.authentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sqli.authentification.entitie.Group;

public interface GroupRepository extends JpaRepository<Group,Integer> {

    Group findGroupByName(String name);
}
