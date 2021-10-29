package com.knf.dev.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.knf.dev.demo.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
