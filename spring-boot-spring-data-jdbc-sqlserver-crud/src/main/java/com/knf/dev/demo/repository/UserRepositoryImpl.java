package com.knf.dev.demo.repository;

import com.knf.dev.demo.exception.ResourceNotFoundException;
import com.knf.dev.demo.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findById(Long id) {

        String sqlQuery = Query.FIND_ONE;
        User user = null;
        try {
             user = jdbcTemplate.
                    queryForObject(sqlQuery,
                            this::mapRowToUser, id);
        }catch(EmptyResultDataAccessException e)
        {
           throw new ResourceNotFoundException
                   ("User not exist with id :" + id);
        }
        return user;
    }

    @Override
    public List<User> findAll() {

        String sqlQuery = Query.FIND_ALL;

        return jdbcTemplate.
                query(sqlQuery, this::mapRowToUser);
    }

    @Override
    public int insert(User user) {

        String sqlQuery = Query.SAVE;

        return jdbcTemplate.update(sqlQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
    }

    @Override
    public int update(User user) {

        String sqlQuery = Query.UPDATE;

        return jdbcTemplate.update(sqlQuery,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getId());
    }

    @Override
    public int deleteById(Long id) {

        String sqlQuery = Query.DELETE;

        return jdbcTemplate.update(sqlQuery, id);
    }

    private User mapRowToUser(ResultSet resultSet, int rowNum)
            throws SQLException {

        User user = new User(resultSet.getLong("id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"));

        return user;
    }
}
