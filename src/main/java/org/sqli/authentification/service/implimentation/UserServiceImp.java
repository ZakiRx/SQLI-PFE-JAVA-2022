package org.sqli.authentification.service.implimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.UserRepository;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    private UserRepository userRepository;
    @Autowired
    public  UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Override
    public Optional<User> findUserByUsernameAndPassword(String username, String password) {
        return Optional.empty();
    }

    @Override
    public boolean checkStateUserAccount() {
        return false;
    }

    @Override
    public void disableUserAccount() {

    }

    @Override
    public Optional<User> createUserAccount(User user) {
        return Optional.empty();
    }

    @Override
    public void deleteAccount(String username) {

    }
}
