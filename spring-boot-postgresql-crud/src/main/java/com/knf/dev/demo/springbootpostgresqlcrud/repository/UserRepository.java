package com.knf.dev.demo.springbootpostgresqlcrud.repository;

import org.springframework.data.repository.CrudRepository;
import com.knf.dev.demo.springbootpostgresqlcrud.entity.User;

public interface UserRepository 
   extends CrudRepository<User, Long> {

}