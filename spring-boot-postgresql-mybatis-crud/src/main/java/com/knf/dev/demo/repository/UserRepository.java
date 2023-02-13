package com.knf.dev.demo.repository;

import com.knf.dev.demo.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("select * from users")
    @Results({
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "emailId", column = "email_id")
    })
     List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "emailId", column = "email_id")
    })
     Optional<User> findById(Integer id);

    @Delete("DELETE FROM users WHERE id = #{id}")
     int deleteById(Integer id);

    @Insert("INSERT INTO users(first_name, last_name, email_id) " +
         " VALUES (#{firstName}, #{lastName}, #{emailId})")
     int insert(User user);

    @Update("Update users set first_name=#{firstName}, " +
         " last_name=#{lastName}, email_id=#{emailId} where id=#{id}")
     int update(User user);
}
