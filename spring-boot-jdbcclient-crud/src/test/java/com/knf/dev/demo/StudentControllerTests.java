package com.knf.dev.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.knf.dev.demo.controller.StudentController;
import com.knf.dev.demo.dao.StudentDAOImpl;
import com.knf.dev.demo.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTests {

        @Autowired
        private MockMvc mockMvc;
        @Autowired
        private ObjectMapper objectMapper;
        @MockBean
        private StudentDAOImpl studentDAO;

        @Test
        void shouldUpdateStudent() throws Exception {

            long id = 1L;

            Student student = new Student(id, "Alpha", "alpha@tmail.com",23,"male");
            Student updatedStudent = new Student(id, "Beta", "alpha@tmail.com",23,"male");

            when(studentDAO.findStudentById(id)).thenReturn(Optional.of(student));
            when(studentDAO.updateStudent(any(Student.class))).thenReturn(updatedStudent);

            mockMvc.perform(put("/api/v1/students/{id}", id).
                            contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(updatedStudent)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value(updatedStudent.getName()))
                    .andExpect(jsonPath("$.email").value(updatedStudent.getEmail()))
                    .andExpect(jsonPath("$.age").value(updatedStudent.getAge()))
                    .andExpect(jsonPath("$.gender").value(updatedStudent.getGender()))
                    .andDo(print());
        }

        @Test
        void shouldReturnListOfStudents() throws Exception {

            List<Student> students = new ArrayList<>(
                    Arrays.asList(new Student(1l, "Alpha", "alpha@tmail.com",12,"male"),
                            new Student(2l, "Beta", "beta@tmail.com",22,"female"),
                            new Student(3l, "Gama", "gama@tmail.com",50,"male")));

            when(studentDAO.getAllStudents()).thenReturn(students);

            mockMvc.perform(get("/api/v1/students"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()").value(students.size()))
                    .andDo(print());
        }

        @Test
        void shouldReturnStudent() throws Exception {

            long id = 1L;
            Student student = new Student(1l, "Alpha", "alpha@tmail.com",23,"male");

            when(studentDAO.findStudentById(id)).thenReturn(Optional.of(student));

            mockMvc.perform(get("/api/v1/students/{id}", id)).andExpect(status().isOk())
                    .andExpect(jsonPath("$.name").value(student.getName()))
                    .andExpect(jsonPath("$.email").value(student.getEmail()))
                    .andExpect(jsonPath("$.age").value(student.getAge()))
                    .andExpect(jsonPath("$.gender").value(student.getGender()))
                    .andDo(print());
        }

        @Test
        void shouldCreateStudent() throws Exception {

            Student student = new Student(1l, "Alpha", "alpha@tmail.com",23,"male");

            mockMvc.perform(post("/api/v1/students").
                            contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(student)))
                    .andExpect(status().isOk())
                    .andDo(print());
        }

        @Test
        void shouldDeleteStudent() throws Exception {

            long id = 1L;

            doNothing().when(studentDAO).deleteStudent(id);
            mockMvc.perform(delete("/api/v1/students/{id}", id))
                    .andExpect(status().isNoContent())
                    .andDo(print());
        }
    }
