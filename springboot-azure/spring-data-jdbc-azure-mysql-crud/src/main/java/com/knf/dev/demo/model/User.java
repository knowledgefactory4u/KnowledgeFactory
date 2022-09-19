package com.knf.dev.demo.model;

import org.springframework.data.annotation.Id;

public class User {
   @Id
   private Long id;

   private String firstName;

   private String lastName;

   private String email;

   public User() {
      super();
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public User(String firstName, String lastName, String email) {
      super();
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }
}