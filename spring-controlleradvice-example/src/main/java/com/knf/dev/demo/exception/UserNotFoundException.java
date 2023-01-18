package com.knf.dev.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class UserNotFoundException extends RuntimeException{

   private static final long serialVersionUID = 1L;
   
   public UserNotFoundException(String message) {
      super(message);
   }
}
