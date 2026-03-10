package com.mycontactsapp.ui;

import com.mycontactsapp.composite.ContactGroup;
import com.mycontactsapp.composite.ContactLeaf;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.repository.ContactRepository;
import com.mycontactsapp.service.BulkOperationService;
import com.mycontactsapp.tag.Tag;
import com.mycontactsapp.tag.TagFactory;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BulkOperationUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {

        BulkOperationService service = new BulkOperationService();

        // get all active contacts
        List<Contact> contacts =
                ContactRepository.getAll()
                        .stream()
                        .filter(c -> !c.isDeleted())
                        .collect(Collectors.toList());

        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.println("Select contacts (enter numbers separated by space)");

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i).getName());
        }

        String input = scanner.nextLine();
        String[] tokens = input.split(" ");

        ContactGroup selectedGroup = new ContactGroup("SelectedContacts");

        // build composite group from selected contacts
        for (String token : tokens) {

            int index = Integer.parseInt(token) - 1;

            if (index >= 0 && index < contacts.size()) {

                selectedGroup.add(
                        new ContactLeaf(contacts.get(index))
                );
            }
        }

        System.out.println("\n1 Bulk Delete");
        System.out.println("2 Tag Contacts");
        System.out.println("3 Export Contacts");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                service.deleteContacts(selectedGroup);
                System.out.println("Selected contacts deleted.");
                break;

            case 2:
                System.out.print("Enter tag name: ");
                String tagName = scanner.nextLine();

                Tag tag = TagFactory.getTag(tagName);

                service.tagContacts(selectedGroup, tag);

                System.out.println("Tag applied to selected contacts.");
                break;

            case 3:
                System.out.println(service.exportContacts(selectedGroup));
                break;

            default:
                System.out.println("Invalid option");
        }
    }
}