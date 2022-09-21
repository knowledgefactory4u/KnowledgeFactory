package com.knf.dev.demo.springdatajdbcazurepostgrescrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ErrorMessage> 
    userNotFound(Exception ex, WebRequest request) {
        var errors =
         new ErrorMessage(404, new Date(), 
           ex.getMessage(), "User Not Found");

        return new ResponseEntity<>
            (errors, HttpStatus.NOT_FOUND);
    }
}