package com.knf.dev.demo.springbootdatajdbccrud.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.knf.dev.demo.
  springbootdatajdbccrud.exception.InternalServerError;
import com.knf.dev.demo.
  springbootdatajdbccrud.exception.UserNotFound;
import com.knf.dev.demo.
  springbootdatajdbccrud.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findOne(Long id) {
        var sqlQuery = Query.FIND_ONE;

        try {

            return jdbcTemplate.
                    queryForObject(sqlQuery, 
                            this::mapRowToUser, id);
            
        } catch (EmptyResultDataAccessException ex) {
            throw new UserNotFound("Invalid User Id");
        } catch (Exception e) {
            throw new InternalServerError
               ("Internal Server Error");
        }

    }

    @Override
    public List<User> findAll() {

        var sqlQuery = Query.FIND_ALL;

        return jdbcTemplate.
                query(sqlQuery, this::mapRowToUser);
    }

    @Override
    public void save(User user) {

        var sqlQuery = Query.SAVE;

        jdbcTemplate.update(sqlQuery, 
                user.firstName(), 
                  user.lastName(), 
                    user.email());
    }

    @Override
    public Long saveAndReturnId(User user) {

        var sqlQuery = Query.SAVE_AND_RETURN_ID;

        var keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement stmt = connection.
                    prepareStatement(sqlQuery, 
                            new String[] { "id" });
            
            stmt.setString(1, user.firstName());
            stmt.setString(2, user.lastName());
            stmt.setString(3, user.email());
            
            return stmt;
            
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public void update(User user) {

        var sqlQuery = Query.UPDATE;

        jdbcTemplate.update(sqlQuery,
                user.firstName(),
                   user.lastName(),
                     user.email(),
                       user.id());
    }

    @Override
    public Boolean delete(Long id) {

        var sqlQuery = Query.DELETE;

        return jdbcTemplate.update(sqlQuery, id) > 0;
    }

    private User mapRowToUser(ResultSet resultSet, int rowNum)
        throws SQLException {

        var user = new User(resultSet.getLong("id"), 
                resultSet.getString("first_name"),
                 resultSet.getString("last_name"),
                 resultSet.getString("email"));

        return user;
    }

}
