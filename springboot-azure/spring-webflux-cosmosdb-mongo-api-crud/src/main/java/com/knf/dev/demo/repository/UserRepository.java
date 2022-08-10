package com.knf.dev.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.knf.dev.demo.model.User;

public interface UserRepository 
         extends ReactiveMongoRepository<User, String> {

}