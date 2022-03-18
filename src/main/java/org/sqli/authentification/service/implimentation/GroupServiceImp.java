package org.sqli.authentification.service.implimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.GroupRepository;
import org.sqli.authentification.entitie.Group;
import org.sqli.authentification.service.GroupService;

import java.util.Optional;

@Service
public class GroupServiceImp implements GroupService {

    private GroupRepository groupRepository;
    @Autowired
    public  GroupServiceImp(GroupRepository groupRepository){
        this.groupRepository=groupRepository;
    }
    @Override
    public Group getGroupByName(String name) {
        return groupRepository.findGroupByName(name);
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
