package com.mycontactsapp.model;

import java.util.UUID;

public abstract class User {

    private String userId;
    private String email;
    private String passwordHash;
    private String name;

    // Constructor used by subclasses
    public User(String email, String passwordHash, String name) {
        // Generate a unique id for every user
        this.userId = UUID.randomUUID().toString();
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = name;
    }

    // Returns user id
    public String getUserId() {
        return userId;
    }

    // Returns email
    public String getEmail() {
        return email;
    }

    // Returns hashed password
    public String getPasswordHash() {
        return passwordHash;
    }

    // Returns name
    public String getName() {
        return name;
    }

    // Abstract method implemented by subclasses
    public abstract String getUserType();
}