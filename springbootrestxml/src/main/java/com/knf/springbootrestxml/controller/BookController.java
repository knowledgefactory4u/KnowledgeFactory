package com.knf.springbootrestxml.controller;


import com.knf.springbootrestxml.model.Book;
import com.knf.springbootrestxml.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class BookController {

  @Autowired
  BookRepository bookRepository;

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title) {
    try {
      List<Book> books = new ArrayList<Book>();

      if (title == null)
        bookRepository.findAll().forEach(books::add);
      else {
        bookRepository.findByTitleContaining(title).forEach(books::add);
      }

      if (books.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(books, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/books/{id}")
  public ResponseEntity<Book> getBookById(@PathVariable("id") long id) {
    Optional<Book> bookData = bookRepository.findById(id);

    if (bookData.isPresent()) {
      return new ResponseEntity<>(bookData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/books")
  public ResponseEntity<Book> createBook(@RequestBody Book _book) {
    try {
      Book book = bookRepository.save(new Book(_book.getTitle(), _book.getDescription(), false));
      return new ResponseEntity<>(book, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
  }

  @PutMapping("/books/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody Book book) {
    Optional<Book> bookData = bookRepository.findById(id);

    if (bookData.isPresent()) {
      Book _book = bookData.get();
      _book.setTitle(book.getTitle());
      _book.setDescription(book.getDescription());
      _book.setPublished(book.isPublished());
      return new ResponseEntity<>(bookRepository.save(_book), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/books/{id}")
  public ResponseEntity<HttpStatus> deleteBook(@PathVariable("id") long id) {
    try {
      bookRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }
  }
}
