package com.knf.dev.demo.repository;

import com.knf.dev.demo.entity.Student;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends CassandraRepository<Student, UUID> {

}
