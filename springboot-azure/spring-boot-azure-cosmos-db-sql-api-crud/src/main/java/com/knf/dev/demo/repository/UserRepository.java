package com.knf.dev.demo.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.knf.dev.demo.entity.User;

public interface UserRepository extends CosmosRepository<User, String> {

}
