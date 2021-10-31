package com.knf.dev.demo.springjpagroovycrud.repository;


import com.knf.dev.demo.springjpagroovycrud.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}