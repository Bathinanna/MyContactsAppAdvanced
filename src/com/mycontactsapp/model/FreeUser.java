package com.mycontactsapp.model;

public class FreeUser extends User {

    // Constructor for free user
    public FreeUser(String email, String passwordHash, String name) {
        super(email, passwordHash, name);
    }

    // Returns user type
    @Override
    public String getUserType() {
        return "FREE";
    }
}