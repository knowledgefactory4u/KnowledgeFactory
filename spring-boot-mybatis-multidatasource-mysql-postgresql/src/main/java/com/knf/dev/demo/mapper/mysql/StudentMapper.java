package com.knf.dev.demo.mapper.mysql;

import com.knf.dev.demo.config.mysql.MySQLConnMapper;
import com.knf.dev.demo.model.mysql.Student;
import java.util.List;
import java.util.Optional;

@MySQLConnMapper("MysqlStudentRepository")
public interface StudentMapper {

    List<Student> findAllStudent();

    Optional<Student> findStudentById(Integer id);

    int deleteStudentById(Integer id);

    int insertStudent(Student student);

    int updateStudent(Student student);
}
