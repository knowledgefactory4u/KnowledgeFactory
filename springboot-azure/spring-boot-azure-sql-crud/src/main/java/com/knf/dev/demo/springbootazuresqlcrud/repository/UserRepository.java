package com.knf.dev.demo.springbootazuresqlcrud.repository;

import org.springframework.data.repository.CrudRepository;

import com.knf.dev.demo.springbootazuresqlcrud.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
