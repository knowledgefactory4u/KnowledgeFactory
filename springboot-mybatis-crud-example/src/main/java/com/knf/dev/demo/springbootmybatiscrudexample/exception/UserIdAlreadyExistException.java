package com.knf.dev.demo.springbootmybatiscrudexample.exception;

public class UserIdAlreadyExistException extends RuntimeException{
    public UserIdAlreadyExistException() {
        super("User Id Already Exist");
    }
}
