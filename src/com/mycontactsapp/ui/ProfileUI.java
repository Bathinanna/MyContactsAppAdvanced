package com.mycontactsapp.ui;

import com.mycontactsapp.command.*;
import com.mycontactsapp.model.*;
import com.mycontactsapp.service.*;
import com.mycontactsapp.session.*;

import java.util.Scanner;

public class ProfileUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {

        User user = SessionManager.getInstance().getLoggedInUser();
        if (user == null) {
            System.out.println("No user logged in.");
            return;
        }
        ProfileService service = new ProfileService();

        System.out.println("\n===== Profile Menu =====");
        System.out.println("1 Update Name");
        System.out.println("2 Change Password");
        System.out.println("3 Update Preference");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:

                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                service.executeCommand(
                        new UpdateNameCommand(user, name)
                );
                System.out.println("Name updated successfully.");
                break;

            case 2:

                System.out.print("Enter new password: ");
                String password = scanner.nextLine();
                service.executeCommand(
                        new ChangePasswordCommand(user, password)
                );
                System.out.println("Password changed successfully.");
                break;

            case 3:

                System.out.print("Preference key: ");
                String key = scanner.nextLine();
                System.out.print("Preference value: ");
                String value = scanner.nextLine();
                service.executeCommand(
                        new UpdatePreferenceCommand(user, key, value)
                );
                System.out.println("Preference updated.");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}