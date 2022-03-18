package org.sqli.authentification.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.sqli.authentification.dto.response.ResponseMessage;
import org.sqli.authentification.exception.AuthenticationException;

@ControllerAdvice
public class CustomResponseExceptionMessage extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> exceptionHandler(AuthenticationException ex) {
        return new ResponseEntity<>(new ResponseMessage(ex.getMessage(),HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }
}
