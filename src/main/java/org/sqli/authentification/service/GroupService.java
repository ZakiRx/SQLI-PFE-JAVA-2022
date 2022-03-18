package org.sqli.authentification.service;

import org.sqli.authentification.entitie.Group;

import java.util.Optional;

public interface GroupService {

   Group getGroupByName(String name);
    Optional<Group> crateNewGroup(Group group);
    boolean checkGroupIfExist(String name);
}
