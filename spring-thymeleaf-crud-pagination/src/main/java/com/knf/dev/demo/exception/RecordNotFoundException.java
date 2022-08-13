package com.knf.dev.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {

   private static final long serialVersionUID = 1L;

   public RecordNotFoundException(String message) {
      super(message);
   }

   public RecordNotFoundException
              (String message, Throwable throwable) {
      super(message, throwable);
   }
}
