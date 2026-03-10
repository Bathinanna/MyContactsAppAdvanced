package com.mycontactsapp.ui;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.model.EmailAddress;
import com.mycontactsapp.model.PhoneNumber;
import com.mycontactsapp.repository.ContactRepository;
import com.mycontactsapp.service.ContactEditService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditContactUI {

    private static Scanner scanner = new Scanner(System.in);

    private static ContactEditService service = new ContactEditService();

    public static void start() {

        System.out.print("Enter contact ID to edit: ");
        String id = scanner.nextLine();

        Contact contact = ContactRepository.findById(id).orElse(null);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        while (true) {

            System.out.println("\n===== Edit Contact =====");
            System.out.println("1. Edit Name");
            System.out.println("2. Replace Phone Numbers");
            System.out.println("3. Replace Emails");
            System.out.println("4. Undo Last Edit");
            System.out.println("5. Redo Last Edit");
            System.out.println("6. Back");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1: {

                    System.out.print("Enter new name: ");
                    String name = scanner.nextLine();

                    service.editContact(contact, name, null, null);

                    System.out.println("Name updated.");
                    break;
                }

                case 2: {

                    List<PhoneNumber> phones = new ArrayList<>();

                    System.out.print("How many phone numbers? ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < count; i++) {

                        System.out.print("Enter phone: ");
                        phones.add(new PhoneNumber(scanner.nextLine()));
                    }

                    service.editContact(contact, null, phones, null);

                    System.out.println("Phone numbers updated.");
                    break;
                }

                case 3: {

                    List<EmailAddress> emails = new ArrayList<>();

                    System.out.print("How many emails? ");
                    int count = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < count; i++) {

                        System.out.print("Enter email: ");
                        emails.add(new EmailAddress(scanner.nextLine()));
                    }

                    service.editContact(contact, null, null, emails);

                    System.out.println("Emails updated.");
                    break;
                }

                case 4:

                    service.undo();
                    System.out.println("Undo successful.");
                    break;

                case 5:

                    service.redo();
                    System.out.println("Redo successful.");
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}