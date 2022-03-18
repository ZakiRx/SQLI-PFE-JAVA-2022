package org.sqli.authentification.service;

import org.sqli.authentification.entitie.Group;

import java.util.Optional;

public interface GroupService {

    Optional<Group> getGroupByName(String name);
    Optional<Group> crateNewGroup(Group group);
    boolean checkGroupIfExist(String name);
}
