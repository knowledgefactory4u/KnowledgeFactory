package com.knf.dev.demo.service;

import com.knf.dev.demo.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User updateUser(User user, Long id);

    User findById(Long id);

    User findByIdWithExchangeMethod(Long id);

    List<User> getAllUsers();

    List<User> getAllUsersAsResponseEntity();

    void deleteUser(Long id);

}
