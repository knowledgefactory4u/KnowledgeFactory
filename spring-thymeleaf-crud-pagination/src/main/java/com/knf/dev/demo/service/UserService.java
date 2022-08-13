package com.knf.dev.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.knf.dev.demo.domain.User;
import com.knf.dev.demo.exception.RecordNotFoundException;

public interface UserService {

	Page<User> findAllPageable(Pageable pageable);

	public void deleteUserById(Long id) throws RecordNotFoundException;

	public User createOrUpdateUser(User entity);

	public User getUserById(Long id) throws RecordNotFoundException;

	public List<User> getAllusers();
}
