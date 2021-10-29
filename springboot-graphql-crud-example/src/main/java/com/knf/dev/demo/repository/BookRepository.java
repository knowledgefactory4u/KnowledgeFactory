package com.knf.dev.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.knf.dev.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
