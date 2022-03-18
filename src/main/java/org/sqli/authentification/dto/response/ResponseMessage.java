package org.sqli.authentification.dto.response;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ResponseMessage {

    private String message;
    private LocalDateTime dateTime;
    private  int code;

    public ResponseMessage(String message, HttpStatus httpStatus) {
        this.message = message;
        this.dateTime = LocalDateTime.now();
        this.code = httpStatus.value();
    }
}
