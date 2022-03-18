package org.sqli.authentification.service;

import org.sqli.authentification.entitie.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserByUsernameAndPassword(String username,String password);
    boolean checkStateUserAccount();
    void disableUserAccount();
    Optional<User> createUserAccount(User user);
    void deleteAccount(String username);
}
