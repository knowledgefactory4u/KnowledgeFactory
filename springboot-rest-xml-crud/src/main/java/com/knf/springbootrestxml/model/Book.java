package com.knf.springbootrestxml.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;


  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "isPublished")
  private boolean published;

  public Book() {
  }

  public Book(String title, String description, boolean published) {
    this.title = title;
    this.description = description;
    this.published = published;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", description='" + description + '\'' +
            ", published=" + published +
            '}';
  }
}