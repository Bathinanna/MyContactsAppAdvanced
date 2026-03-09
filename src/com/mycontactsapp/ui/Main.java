package com.mycontactsapp.ui;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== MyContacts App =====");
            System.out.println("1. Register User");
            System.out.println("2. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch(choice) {

                case 1:
                    RegistrationUI.start();
                    break;

                case 2:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option");
            }
            
            scanner.close();
        }
    }
}