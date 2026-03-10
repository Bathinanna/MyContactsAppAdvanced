package com.mycontactsapp.ui;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.search.*;
import com.mycontactsapp.service.ContactSearchService;

import java.util.List;
import java.util.Scanner;

public class SearchContactUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {

        ContactSearchService service = new ContactSearchService();

        System.out.println("Search by:");
        System.out.println("1 Name");
        System.out.println("2 Phone");
        System.out.println("3 Email");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter search value: ");
        String value = scanner.nextLine();

        SearchCriteria criteria = null;

        switch (choice) {

            case 1:
                criteria = new NameSpecification(value);
                break;

            case 2:
                criteria = new PhoneSpecification(value);
                break;

            case 3:
                criteria = new EmailSpecification(value);
                break;
        }

        List<Contact> results = service.search(criteria);

        results.forEach(c ->
                System.out.println("Found: " + c.getName())
        );
    }
}