package org.sqli.authentification.service;

import org.sqli.authentification.entitie.User;
import org.sqli.authentification.exception.AuthenticationException;
import org.sqli.authentification.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    User findUserByUsernameAndPassword(String username, String password)throws AuthenticationException;
    boolean checkStateUserAccount(User user);
    User findUserByUserName(String username);
    void disableUserAccount(User user);
    User createUserAccount(User user);
    void deleteAccount(String username) throws UserNotFoundException;
    List<User> getUsers();
}
