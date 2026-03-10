package com.mycontactsapp.ui;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.repository.ContactRepository;
import com.mycontactsapp.service.ContactViewService;

import java.util.Scanner;

public class ViewContactUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {

        ContactViewService service = new ContactViewService();

        System.out.print("Enter contact ID: ");
        String id = scanner.nextLine();

        Contact contact = ContactRepository.findById(id).orElse(null);

        if(contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        System.out.print("Uppercase name? (true/false): ");
        boolean upper = scanner.nextBoolean();

        System.out.print("Mask emails? (true/false): ");
        boolean mask = scanner.nextBoolean();

        String result = service.viewContact(contact, upper, mask);

        System.out.println("\nContact Details:\n");
        System.out.println(result);
    }
}