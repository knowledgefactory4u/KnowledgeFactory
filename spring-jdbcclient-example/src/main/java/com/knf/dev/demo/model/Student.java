package com.knf.dev.demo.model;

public record Student
        (Long id,
         String name,
         String email,
         Integer age,
         String gender ) {}