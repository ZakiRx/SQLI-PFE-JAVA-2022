package org.sqli.authentification.service.implimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.UserRepository;
import org.sqli.authentification.entitie.Group;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.exception.AuthenticationException;
import org.sqli.authentification.exception.UserNotFoundException;
import org.sqli.authentification.service.GroupService;
import org.sqli.authentification.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    private GroupService groupService;
    @Autowired
    public  UserServiceImp(UserRepository userRepository,GroupService groupService){
        this.userRepository=userRepository;
        this.groupService=groupService;
    }
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user=userRepository.findByLogin(username);

        if(user!=null){ //User found with username
            if(!Objects.equals(user.getPassword(), password)){  //Check Password
                int loginAtt=user.getLoginAttempts();//set LoginAttempts
                user.setLoginAttempts(++loginAtt);
                if(user.getLoginAttempts()>2){
                    this.disableUserAccount(user);
                    userRepository.save(user);
                    throw new AuthenticationException("You have reached 3 failed authentication attempts, your account will be disabled");
                }
                userRepository.save(user);
            }else{
                if(!checkStateUserAccount(user)){
                    throw new AuthenticationException("User disabled");
                }
                return  user;
            }

        }
            throw new AuthenticationException("Authentication error");

    }

    @Override
    public boolean checkStateUserAccount(User user) {

        return  user.isEnabled();
    }

    @Override
    public User findUserByUserName(String username) {
        return userRepository.findByLogin(username);
    }

    @Override
    public void disableUserAccount(User user) {
        user.setEnabled(false);
        userRepository.save(user);
    }

    @Override
    public User createUserAccount(User user) {
        User existUser=userRepository.findByLogin(user.getLogin());
        if(existUser ==null && !Objects.equals(user.getPassword(), "")){
            Group group=groupService.getGroupByName(user.getGroup().getName());
            if(group==null){
                throw new AuthenticationException("Group "+user.getGroup().getName()+" is not valid");
            }
            user.setGroup(group);
            user.setId(new Random().nextInt(1000)*100);
            return  userRepository.save(user);

        }else{
            throw new AuthenticationException("Login "+user.getLogin()+" is not valid");
        }
    }

    @Override
    public void deleteAccount(String username) {
        User user = userRepository.findByLogin(username);
        if(user ==null){
            throw new UserNotFoundException("Login "+username+" is not found");
        }
        userRepository.delete(user);
    }
    public List<User> getUsers(){
        return  userRepository.findAll();
    }
}
