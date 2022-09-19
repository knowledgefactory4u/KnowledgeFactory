package com.knf.dev.demo.repository;

import com.knf.dev.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}
