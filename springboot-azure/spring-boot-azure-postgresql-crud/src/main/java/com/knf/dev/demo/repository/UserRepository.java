package com.knf.dev.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.knf.dev.demo.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}