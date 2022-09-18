package com.knf.dev.demo.model;

public record User
        (Long id,
         String firstName,
         String lastName,
         String email) {
}
