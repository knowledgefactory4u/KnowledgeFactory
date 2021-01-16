package com.knf.reactivestack.dev.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.knf.reactivestack.dev.domain.User;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    
}
