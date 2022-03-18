package org.sqli.authentification.service.implimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.entitie.Group;
import org.sqli.authentification.service.GroupService;

import java.util.Optional;

@Service
public class GroupServiceImp implements GroupService {

    private GroupService groupService;
    @Autowired
    public  GroupServiceImp(GroupService groupService){
        this.groupService=groupService;
    }
    @Override
    public Optional<Group> getGroupByName(String name) {
        return Optional.empty();
    }

    @Override
    public Optional<Group> crateNewGroup(Group group) {
        return Optional.empty();
    }

    @Override
    public boolean checkGroupIfExist(String name) {
        return false;
    }
}
