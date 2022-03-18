package org.sqli.authentification.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseException {

    private String message;
    private LocalDateTime dateTime;
    private  int code;

    public ResponseException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.code = httpStatus.value();
    }
}
