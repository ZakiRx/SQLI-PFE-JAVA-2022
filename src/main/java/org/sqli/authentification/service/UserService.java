package org.sqli.authentification.service;

import org.sqli.authentification.entitie.User;
import org.sqli.authentification.exception.AuthenticationException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findUserByUsernameAndPassword(String username, String password)throws AuthenticationException;
    boolean checkStateUserAccount(User user);
    void disableUserAccount(User user);
    Optional<User> createUserAccount(User user);
    void deleteAccount(String username);
    List<User> getUsers();
}
