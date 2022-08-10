package com.knf.dev.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.knf.dev.demo.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
