package com.mycontactsapp.ui;

import com.mycontactsapp.session.SessionManager;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MyContacts App =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Profile Management");
            System.out.println("4. Add Contact");
            System.out.println("5. View Contacts");
            System.out.println("6. Edit Contacts");
            System.out.println("7. Delete Contacts");
            System.out.println("8. Bulk Operatons");
            System.out.println("9. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {

                case 1:
                    RegistrationUI.start();
                    break;

                case 2:
                    LoginUI.start();
                    break;

                case 3:

                    // check if user logged in
                    if (!SessionManager.getInstance().isLoggedIn()) {
                        System.out.println("Please login first.");
                        break;
                    }

                    ProfileUI.start();
                    break;

                case 4:

                    // check login before contact management
                    if (!SessionManager.getInstance().isLoggedIn()) {
                        System.out.println("Please login first.");
                        break;
                    }

                    ContactUI.start();
                    break;
                    
                case 5:
                	// check login before contact management
                	if (!SessionManager.getInstance().isLoggedIn()) {
                        System.out.println("Please login first.");
                        break;
                    }
                	
                	ViewContactUI.start();
                	break;
                
                case 6:
                	// check login before contact management
                	if (!SessionManager.getInstance().isLoggedIn()) {
                        System.out.println("Please login first.");
                        break;
                    }
                	
                	EditContactUI.start();
                	break;
                	
                case 7:
                	// check login before contact management
                	if (!SessionManager.getInstance().isLoggedIn()) {
                        System.out.println("Please login first.");
                        break;
                    }
                	
                	DeleteContactUI.start();
                	break;
                	
                case 8:
                	// check login before contact management
                	if (!SessionManager.getInstance().isLoggedIn()) {
                        System.out.println("Please login first.");
                        break;
                    }
                	
                	BulkOperationUI.start();
                	break;

                case 9:
                    System.out.println("Exiting application...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}