package com.mycontactsapp.ui;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.repository.ContactRepository;
import com.mycontactsapp.service.ContactTagService;

import java.util.Scanner;

public class TagAssignmentUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {

        ContactTagService service = new ContactTagService();

        System.out.print("Enter contact ID: ");
        String id = scanner.nextLine();

        Contact contact =
            ContactRepository.findById(id).orElse(null);

        if(contact == null) {

            System.out.println("Contact not found.");
            return;
        }

        System.out.println("1 Add Tag");
        System.out.println("2 Remove Tag");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter tag name: ");
        String tag = scanner.nextLine();

        if(choice == 1) {

            service.assignTag(contact, tag);

        } else {

            service.removeTag(contact, tag);
        }
    }
}