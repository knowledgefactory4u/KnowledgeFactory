package com.knf.dev.demo.controller;

import com.knf.dev.demo.dao.StudentDAOImpl;
import com.knf.dev.demo.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentDAOImpl studentDAO;

    public StudentController(StudentDAOImpl studentDAO) {
        this.studentDAO = studentDAO;
    }

    @PostMapping
    public ResponseEntity<Integer> createStudent(
            @RequestBody Student student) {

        studentDAO.insertStudent(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {

        return studentDAO.findStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(studentDAO.getAllStudents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student student) {

        Student _student = studentDAO.findStudentById(id).orElseThrow();
        _student.setAge(student.getAge());
        _student.setName(student.getName());
        _student.setEmail(student.getEmail());
        _student.setGender(student.getGender());

        return ResponseEntity.ok(studentDAO.updateStudent(_student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {

        studentDAO.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
