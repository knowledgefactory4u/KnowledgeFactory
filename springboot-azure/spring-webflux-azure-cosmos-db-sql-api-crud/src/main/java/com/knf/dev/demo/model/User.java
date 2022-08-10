package com.knf.dev.demo.model;

import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;

@Container(containerName = "User")
public class User {
   @Id
   @GeneratedValue
   private String id;
   private String firstName;
   private String lastName;
   private String email;

   public User() {

   }

   public User(String firstName, 
                String lastName, String email) {

      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
   }

   public String getId() {
      return id;
   }

   public void setId(String id) {
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
}