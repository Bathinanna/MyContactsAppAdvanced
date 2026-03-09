package com.mycontactsapp.model;

public class PremiumUser extends User {

    // Constructor for premium user
    public PremiumUser(String email, String passwordHash, String name) {
        super(email, passwordHash, name);
    }

    // Returns user type
    @Override
    public String getUserType() {
        return "PREMIUM";
    }
}