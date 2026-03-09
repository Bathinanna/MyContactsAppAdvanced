package com.mycontactsapp.builder;

public class UserBuilder {

    private String email;
    private String passwordHash;
    private String name;

    // Sets email
    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    // Sets password hash
    public UserBuilder setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
        return this;
    }

    // Sets name
    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

    // Getter methods used by factory
    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getName() {
        return name;
    }
}