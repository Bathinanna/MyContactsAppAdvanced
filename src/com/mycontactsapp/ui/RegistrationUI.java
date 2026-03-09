package com.mycontactsapp.ui;
import com.mycontactsapp.model.*;
import com.mycontactsapp.service.*;

import java.util.Scanner;

public class RegistrationUI {

    // Scanner to read console input
    private static Scanner scanner = new Scanner(System.in);

    // Method called from Main menu
    public static void start() {

        RegistrationService service = new RegistrationService();

        try {

            // Ask user for registration details
            System.out.println("\n===== User Registration =====");

            System.out.print("Enter name: ");
            String name = scanner.nextLine();

            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            System.out.print("Enter type (FREE / PREMIUM): ");
            String type = scanner.nextLine();

            // Call registration service
            User user = service.registerUser(name, email, password, type);

            // Show success message
            System.out.println("\nUser registered successfully!");
            System.out.println("User ID: " + user.getUserId());
            System.out.println("User Type: " + user.getUserType());

        } catch (Exception e) {

            // Handle registration errors
            System.out.println("Registration failed: " + e.getMessage());

        }
    }
}