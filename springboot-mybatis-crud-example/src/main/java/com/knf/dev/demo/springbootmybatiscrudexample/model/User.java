package com.knf.dev.demo.springbootmybatiscrudexample.model;

public class User {

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;

    public User() {
    }

    public User(long id,String firstName, String lastName, String emailId) {
        super();
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
