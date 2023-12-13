package com.knf.dev.demo.dao;

import com.knf.dev.demo.model.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private JdbcClient jdbcClient;

    public StudentDAOImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Integer insertStudent(Student student) {

        String sql = "INSERT INTO students (name, email, gender, age)"
                        + "VALUES (:name, :email, :gender, :age)";
       return this.jdbcClient.sql(sql)
                .param("name", student.name(), Types.VARCHAR)
                .param("email", student.email(), Types.VARCHAR)
                .param("gender", student.gender(), Types.VARCHAR)
                .param("age", student.age(), Types.INTEGER)
                .update();
    }

    @Override
    public Integer updateStudent(Student student) {

        String sql = "update students set name = :name, email = :email, " +
                        "gender= :gender, age = :age where id = :id";

        return jdbcClient.sql(sql)
                .param("name", student.name())
                .param("email", student.email())
                .param("gender", student.gender())
                .param("age", student.age())
                .param("id", student.id())
                .update();

    }

    @Override
    public Integer deleteStudent(Long id) {

        String sql = "delete from students where id = :id";
        return jdbcClient.sql(sql).param("id", id).update();
    }

    //Using  Varargs
    @Override
    public List<Student> findStudentByAgeAndGender(Integer age, String gender) {

        String sql = "select id, name, age, email, gender, age from students"
                        + " where age = ? and gender = ?";

        return jdbcClient.sql(sql)
                .params(age, gender)
                .query(new StudentRowMapper()).list();
    }

    @Override
    public Optional<Student> findStudentById(Long id) {

        String sql = "select id, name, age, gender, " +
                       "email from students where id = :id";

        return jdbcClient.sql(sql)
                .param("id", id)
                .query(Student.class)
                .optional();
    }

    //Using Positional Params
    @Override
    public List<Student> findStudentByGenderAndAgeGreaterThan
    (Integer age, String gender) {

        String sql = "select id, name, age, email, gender from students"
                         + " where age > ? and gender = ?";

        return jdbcClient.sql(sql)
                .param(age)
                .param(gender)
                .query(new StudentRowMapper()).list();
    }

    static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Student(
                    rs.getLong("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getInt("age"),
                    rs.getString("gender"));
        }
    }
}