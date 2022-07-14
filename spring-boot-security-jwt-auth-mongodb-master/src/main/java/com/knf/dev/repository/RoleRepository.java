package com.knf.dev.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.knf.dev.models.ERole;
import com.knf.dev.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Optional<Role> findByName(ERole name);
}
