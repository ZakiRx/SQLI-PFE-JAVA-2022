package org.sqli.authentification.exception;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
