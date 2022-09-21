package com.knf.dev.demo.springdatajdbcazurepostgrescrud.repository;

import com.knf.dev.demo.springdatajdbcazurepostgrescrud.model.User;
import java.util.List;

public interface UserRepository {

    public User findOne(Long id);

    public List<User> findAll();

    public void save(User user);

    public Long saveAndReturnId(User user);

    public void update(User user);

    public Boolean delete(Long id);

}