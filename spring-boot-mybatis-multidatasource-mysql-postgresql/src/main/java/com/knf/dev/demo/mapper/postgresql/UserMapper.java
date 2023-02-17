package com.knf.dev.demo.mapper.postgresql;

import com.knf.dev.demo.config.postgresql.PostgreSQLConnMapper;
import com.knf.dev.demo.model.postgresql.User;
import java.util.List;
import java.util.Optional;

@PostgreSQLConnMapper("PostgreSQLUserMapper")
public interface UserMapper {

     List<User> findAllUser();

     Optional<User> findUserById(Integer id);

     int deleteUserById(Integer id);

     int insertUser(User user);

     int updateUser(User user);
}