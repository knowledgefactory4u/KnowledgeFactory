package com.knf.dev.demo.springdatajdbcazurepostgrescrud.repository;


import com.knf.dev.demo.springdatajdbcazurepostgrescrud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}