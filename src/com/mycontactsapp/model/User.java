package com.mycontactsapp.model;

import java.util.UUID;
import java.util.*;

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
    
 // update user name
    public void setName(String name) {
        this.name = name;
    }

    // update password hash
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    // store user preferences
    private Map<String, String> preferences = new HashMap<>();

    // update preference
    public void setPreference(String key, String value) {
        preferences.put(key, value);
    }

    // retrieve preference
    public String getPreference(String key) {
        return preferences.get(key);
    }

    // Abstract method implemented by subclasses
    public abstract String getUserType();
}