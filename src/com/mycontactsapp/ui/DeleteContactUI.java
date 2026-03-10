package com.mycontactsapp.ui;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.repository.ContactRepository;
import com.mycontactsapp.service.ContactDeleteService;

import java.util.Scanner;

public class DeleteContactUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {

        System.out.print("Enter contact ID to delete: ");
        String id = scanner.nextLine();

        Contact contact =
                ContactRepository.findById(id).orElse(null);

        if(contact == null) {

            System.out.println("Contact not found.");
            return;
        }

        System.out.println("Are you sure you want to delete " +
                contact.getName() + "? (yes/no)");

        String confirm = scanner.nextLine();

        if(!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Deletion cancelled.");
            return;
        }

        ContactDeleteService service = new ContactDeleteService();

        System.out.println("1 Soft Delete");
        System.out.println("2 Hard Delete");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if(choice == 1) {

            service.softDelete(contact);

            System.out.println("Contact soft deleted.");

        } else {

            service.hardDelete(contact);

            System.out.println("Contact permanently deleted.");
        }
    }
}