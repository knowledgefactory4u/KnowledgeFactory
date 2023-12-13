package com.knf.dev.demo.dao;

import com.knf.dev.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {

    Integer insertStudent(Student student);

    Integer updateStudent(Student student);

    Integer deleteStudent(Long id);

    List<Student> findStudentByAgeAndGender(Integer age, String gender);

    Optional<Student> findStudentById(Long id);

    List<Student> findStudentByGenderAndAgeGreaterThan(Integer age, String gender);


}