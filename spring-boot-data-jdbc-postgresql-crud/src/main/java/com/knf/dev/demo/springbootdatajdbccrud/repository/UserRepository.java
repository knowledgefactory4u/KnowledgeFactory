package com.knf.dev.demo.springbootdatajdbccrud.repository;

import java.util.List;

import com.knf.dev.demo.springbootdatajdbccrud.model.User;

public interface UserRepository {

	public User findOne(Long id);

	public List<User> findAll();

	public void save(User user);

	public Long saveAndReturnId(User user);

	public void update(User user);

	public Boolean delete(Long id);

}