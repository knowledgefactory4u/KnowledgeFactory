package com.knf.dev.demo.repository;

import com.knf.dev.demo.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    @Select("select * from users")
    public List<User> findAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    public Optional<User> findById(Integer id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    public int deleteById(Integer id);

    @Insert("INSERT INTO users(firstName, lastName,emailId) " +
         " VALUES (#{firstName}, #{lastName}, #{emailId})")
    public int insert(User user);

    @Update("Update users set firstName=#{firstName}, " +
         " lastName=#{lastName}, emailId=#{emailId} where id=#{id}")
    public int update(User user);
}