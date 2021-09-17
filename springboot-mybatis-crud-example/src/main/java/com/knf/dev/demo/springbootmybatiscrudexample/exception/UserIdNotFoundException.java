package com.knf.dev.demo.springbootmybatiscrudexample.exception;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException()
    {
        super("User Id Not Found");
    }
}
