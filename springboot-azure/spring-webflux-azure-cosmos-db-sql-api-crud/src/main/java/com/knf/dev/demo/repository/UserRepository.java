package com.knf.dev.demo.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.knf.dev.demo.model.User;

public interface UserRepository extends ReactiveCosmosRepository<User, String> {

}
