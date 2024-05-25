package com.knf.dev.demo.entity;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Set;
import java.util.UUID;

@Table
public class Student {

    @PrimaryKey
    private UUID id;
    private String name;
    private String email;
    private Set<String> qualifications;

    public Student() {
    }

    public Student(UUID id, String name,
                   String email, Set<String> qualifications) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.qualifications = qualifications;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(Set<String> qualifications) {
        this.qualifications = qualifications;
    }
}