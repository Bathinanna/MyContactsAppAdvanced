package com.mycontactsapp.test;

import com.mycontactsapp.command.*;
import com.mycontactsapp.model.*;
import org.junit.jupiter.api.Test;
import com.mycontactsapp.service.*;
import com.mycontactsapp.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

public class ProfileServiceTest {

    private User user;
    private ProfileService profileService;


    // Runs before every test
    @BeforeEach
    void setUp() {

        user = new FreeUser(
                "sindhur@gmail.com",
                PasswordUtil.hashPassword("Sindhur@2005"),
                "Sindhur"
        );

        profileService = new ProfileService();
    }


    // Test updating user name
    @Test
    void testUpdateName() {

        profileService.executeCommand(
                new UpdateNameCommand(user, "Sindhur Marella")
        );

        assertEquals("Sindhur Marella", user.getName());
    }


    // Test password change
    @Test
    void testChangePassword() {

        String newPassword = "Sindhur@1835";

        profileService.executeCommand(
                new ChangePasswordCommand(user, newPassword)
        );

        String expectedHash = PasswordUtil.hashPassword(newPassword);

        assertEquals(expectedHash, user.getPasswordHash());
    }


    // Test invalid password format
    @Test
    void testInvalidPassword() {

        assertThrows(
                RuntimeException.class,
                () -> profileService.executeCommand(
                        new ChangePasswordCommand(user, "123")
                )
        );
    }


    // Test updating preferences
    @Test
    void testUpdatePreference() {

        profileService.executeCommand(
                new UpdatePreferenceCommand(user, "theme", "dark")
        );

        assertEquals("dark", user.getPreference("theme"));
    }
}