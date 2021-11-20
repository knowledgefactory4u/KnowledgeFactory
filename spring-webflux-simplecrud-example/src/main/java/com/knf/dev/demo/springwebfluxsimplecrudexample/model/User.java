package com.knf.dev.demo.springwebfluxsimplecrudexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
@Getter
@Setter
@AllArgsConstructor
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
