package com.mycontactsapp.service;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycontactsapp.exception.*;
import com.mycontactsapp.model.*;

public class RegistrationServiceTest {

    // Create service instance to test
    RegistrationService service = new RegistrationService();


    // Test valid registration
    @Test
    void testValidRegistration() throws InvalidInputException {

        User user = service.registerUser(
                "Sindhur",
                "sindhur@gmail.com",
                "Sindhur@2005",
                "FREE"
        );

        // Check that user object is created
        assertNotNull(user);

        // Check correct user type
        assertEquals("FREE", user.getUserType());

        // Check email stored correctly
        assertEquals("sindhur@gmail.com", user.getEmail());
    }


    // Test invalid email
    @Test
    void testInvalidEmail() {

        assertThrows(
                InvalidInputException.class,
                () -> service.registerUser(
                        "Sindhur",
                        "sindhurgmail",
                        "password123",
                        "FREE"
                )
        );
    }


    // Test weak password
    @Test
    void testWeakPassword() {

        assertThrows(
                InvalidInputException.class,
                () -> service.registerUser(
                        "Sindhur",
                        "sindhur@gmail.com",
                        "123",
                        "FREE"
                )
        );
    }


    // Test premium user creation
    @Test
    void testPremiumUserCreation() throws InvalidInputException {

        User user = service.registerUser(
                "Sindhur",
                "sindhur@gmail.com",
                "Sindhur@2005",
                "PREMIUM"
        );

        assertEquals("PREMIUM", user.getUserType());
    }


    // Test password hashing
    @Test
    void testPasswordHashing() throws InvalidInputException {

        User user = service.registerUser(
                "Sindhur",
                "sindhur@gmail.com",
                "Sindhur@2005",
                "FREE"
        );

        // Stored password should not equal raw password
        assertNotEquals("Sindhur@2005", user.getPasswordHash());
    }
}
