package com.knf.dev.mockito.service;

import java.util.List;

import com.knf.dev.mockito.entity.User;

public interface UserService {

    public User getUserByName(String name);
    public User saveUser(User user);
    public List<User> getAllUsers();
}