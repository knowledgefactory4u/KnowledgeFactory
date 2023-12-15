package com.knf.dev.demo.dao;

import com.knf.dev.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {

    Integer insertStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Long id);

    List<Student> getAllStudents();

    Optional<Student> findStudentById(Long id);

}