package org.sqli.authentification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AuthenticationException extends  RuntimeException  {

    public  AuthenticationException(String message){
        super(message);
    }


}
