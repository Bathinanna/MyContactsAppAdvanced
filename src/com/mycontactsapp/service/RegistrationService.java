package com.mycontactsapp.service;
import com.mycontactsapp.builder.*;
import com.mycontactsapp.exception.*;
import com.mycontactsapp.factory.*;
import com.mycontactsapp.model.*;
import com.mycontactsapp.util.*;

public class RegistrationService {

    // Registers a new user
    public User registerUser(String name, String email, String password, String type)
            throws InvalidInputException {

        // Validate email format
        if (!ValidationUtil.isValidEmail(email)) {
            throw new InvalidInputException("Invalid email format");
        }

        // Validate password strength
        if (!ValidationUtil.isValidPassword(password)) {
            throw new InvalidInputException("Password must be at least 6 characters");
        }

        // Hash password before storing
        String passwordHash = PasswordUtil.hashPassword(password);

        // Build user object
        UserBuilder builder = new UserBuilder()
                .setName(name)
                .setEmail(email)
                .setPasswordHash(passwordHash);

        // Create user using factory
        return UserFactory.createUser(type, builder);
    }
}