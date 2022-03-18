package org.sqli.authentification.service.implimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.UserRepository;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.exception.AuthenticationException;
import org.sqli.authentification.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    @Autowired
    public  UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user=userRepository.findUserByLoginAndPassword(username,password).orElseThrow(()->new AuthenticationException("Authentication error"));
        if(!checkStateUserAccount(user)){
            throw new AuthenticationException("User disabled");
        }
        return  user;

    }

    @Override
    public boolean checkStateUserAccount(User user) {

        return  user.isEnabled();
    }

    @Override
    public void disableUserAccount(User user) {
        user.setEnabled(false);
        userRepository.save(user);
    }

    @Override
    public Optional<User> createUserAccount(User user) {
        return Optional.empty();
    }

    @Override
    public void deleteAccount(String username) {
        User user = userRepository.findByLogin(username);
        userRepository.delete(user);
    }
    public List<User> getUsers(){
        return  userRepository.findAll();
    }
}
