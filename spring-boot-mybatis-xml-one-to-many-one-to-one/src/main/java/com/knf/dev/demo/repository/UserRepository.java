package com.knf.dev.demo.repository;


import com.knf.dev.demo.model.User;

public interface UserRepository {
    User selectUserById(String email);

}