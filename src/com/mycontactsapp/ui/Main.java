package com.mycontactsapp.ui;
import com.mycontactsapp.session.*;

import java.util.Scanner;

public class Main {

	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {

	        while (true) {

	            System.out.println("\n===== MyContacts App =====");
	            System.out.println("1. Register");
	            System.out.println("2. Login");
	            System.out.println("3. Profile Management");
	            System.out.println("4. Exit");

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

	                    //ProfileUI.start();
	                    break;

	                case 4:
	                    System.out.println("Exiting application...");
	                    return;

	                default:
	                    System.out.println("Invalid option.");
	            }
	        }
	    }
	}