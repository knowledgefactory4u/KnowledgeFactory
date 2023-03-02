package com.knf.dev.demo.controller.mysql;

import com.knf.dev.demo.exception.ResourceNotFoundException;
import com.knf.dev.demo.mapper.mysql.StudentMapper;
import com.knf.dev.demo.model.mysql.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    // get all student
    @GetMapping("/students")
    public List<Student> getAllStudent()
    {
        return studentMapper.findAllStudent();
    }
    // create student rest API
    @PostMapping("/students")
    public Map<String, Boolean> createStudent(@RequestBody Student student)  {

        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = studentMapper.insertStudent(student) > 0 ?
                response.put("created", Boolean.TRUE) :
                response.put("created", Boolean.FALSE);

        return response;

    }

    // get student by id rest api
    @GetMapping("/students/{id}")
    public Student findStudentById(@PathVariable Integer id) {

        Student student = studentMapper.findStudentById(id).
                orElseThrow(() -> new ResourceNotFoundException
                        ("Student not exist with id :" + id));
        return student;
    }

    // update student rest api
    @PutMapping("/students/{id}")
    public Map<String, Boolean> updateStudent(@PathVariable Integer id,
                                           @RequestBody Student studentDetails) {

        Student student = studentMapper.findStudentById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Student not exist with id :" + id));
        studentDetails.setId(id);
        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = studentMapper.updateStudent(studentDetails) > 0 ?
                response.put("updated", Boolean.TRUE) :
                response.put("updated", Boolean.FALSE);

        return response;
    }

    // delete student rest api
    @DeleteMapping("/students/{id}")
    public Map<String, Boolean> deleteStudent
         (@PathVariable Integer id) {

        Student student = studentMapper.findStudentById(id)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Student not exist with id :" + id));

        Map<String, Boolean> response = new HashMap<>();

        Boolean bool = studentMapper.deleteStudentById(student.getId()) > 0 ?
                response.put("deleted", Boolean.TRUE) :
                response.put("deleted", Boolean.FALSE);
        return response;
    }
}
