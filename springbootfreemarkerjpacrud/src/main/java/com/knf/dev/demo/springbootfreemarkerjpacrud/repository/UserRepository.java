package com.knf.dev.demo.springbootfreemarkerjpacrud.repository;

import com.knf.dev.demo.springbootfreemarkerjpacrud.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

} 