package com.knf.dev.demo.springbootmysqlrestcrud.repository;

import org.springframework.data.repository.CrudRepository;
import com.knf.dev.demo.springbootmysqlrestcrud.entity.User;

public interface UserRepository 
   extends CrudRepository<User, Long> {

}
