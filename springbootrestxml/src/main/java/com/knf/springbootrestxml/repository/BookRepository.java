package com.knf.springbootrestxml.repository;

import java.util.List;

import com.knf.springbootrestxml.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
   List<Book> findByTitleContaining(String title);
}
