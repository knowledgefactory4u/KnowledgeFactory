package com.knf.dev.demo.controller;

import com.knf.dev.demo.entity.Student;
import com.knf.dev.demo.exception.EntityNotFoundException;
import com.knf.dev.demo.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return student;
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        student.setId(UUID.randomUUID());
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@RequestBody Student s, @PathVariable UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        student.setQualifications(s.getQualifications());
        student.setEmail(s.getEmail());
        student.setName(s.getName());
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public boolean removeStudent(@PathVariable UUID id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        studentRepository.delete(student);
        return true;
    }
}
