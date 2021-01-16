package com.knf.reactivestack.dev.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private String name;
    private String emailId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * @param id
     * @param name
     * @param emailId
     */
    public User(String id, String name, String emailId) {
        super();
        this.id = id;
        this.name = name;
        this.emailId = emailId;
    }

    /**
     *
     */
    public User() {
        super();
    }
}
