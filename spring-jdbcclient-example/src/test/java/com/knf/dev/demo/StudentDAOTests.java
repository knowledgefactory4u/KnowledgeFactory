package com.knf.dev.demo;

import com.knf.dev.demo.dao.StudentDAOImpl;
import com.knf.dev.demo.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@JdbcTest
@Testcontainers
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Sql({"/test-student-data.sql"})
public class StudentDAOTests {

    @Autowired
    private JdbcClient jdbcClient;

    private StudentDAOImpl studentDAO;

    @Container
    @ServiceConnection
    public static PostgreSQLContainer postgreSQLContainer =

            new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"));


    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAOImpl(jdbcClient);
    }

    @Test
    void saveStudent_ReturnsTheInteger() {

        Integer row = studentDAO.
                insertStudent(
                        new Student(1l,"rahul",
                                "rahul@email.com",19,"Male"));
        assertThat(row).isEqualTo(1);
    }

    @Test
    void updateStudent_ReturnsTheInteger() {

        Integer row = studentDAO.
                updateStudent(
                        new Student(104l,"rahul",
                                "rahulg@email.com",25,"Male"));
        Student student = studentDAO.findStudentById(104l).get();
        assertThat(row).isEqualTo(1);
    }

    @Test
    void deleteStudent_ReturnsTheInteger() {

        Integer row = studentDAO.
                deleteStudent(105l);
        assertThat(row).isEqualTo(1);
    }


    @Test
    void findStudentByGenderAndAgeGreaterThan_ReturnsTheListStudents() {

        List<Student> students = studentDAO.findStudentByGenderAndAgeGreaterThan(31,"Male");

        //Convert list of students to list of id(Integer)
        List<Integer> ids = students.stream()
                .map(o -> o.id().intValue())
                .collect(Collectors.toList());

        assertThat(students.size()).isEqualTo(2);
        assertThat(ids).hasSameElementsAs(Arrays.asList(100,101));
    }

    @Test
    void findStudentByAgeAndGender_ReturnsTheListStudents() {

        List<Student> students = studentDAO.findStudentByAgeAndGender(5,"Male");

        //Convert list of students to list of id(Integer)
        List<Integer> ids = students.stream()
                .map(o -> o.id().intValue())
                .collect(Collectors.toList());

        assertThat(students.size()).isEqualTo(2);
        assertThat(ids).hasSameElementsAs(Arrays.asList(106,107));
    }
    @Test
    void findStudentById_ReturnsTheStudent() {

        Student student = studentDAO.findStudentById(102l).get();
        assertThat(student).isNotNull();
        assertThat(student.email()).isEqualTo("beta@knf.com");
        assertThat(student.name()).isEqualTo("Beta");
        assertThat(student.age()).isEqualTo(40);
        assertThat(student.id()).isEqualTo(102l);
        assertThat(student.gender()).isEqualTo("Female");
    }
}