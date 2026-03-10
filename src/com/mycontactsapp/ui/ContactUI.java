package com.mycontactsapp.ui;

import com.mycontactsapp.builder.*;
import com.mycontactsapp.model.*;
import com.mycontactsapp.service.*;

import java.util.Scanner;

public class ContactUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {

        ContactService service = new ContactService();

        System.out.println("\n=== Create Contact ===");

        System.out.print("Contact Type (PERSON / ORG): ");
        String type = scanner.nextLine();

        ContactBuilder builder = new ContactBuilder();

        System.out.print("Name: ");
        builder.setName(scanner.nextLine());

        System.out.print("Phone: ");
        builder.addPhone(scanner.nextLine());

        System.out.print("Email: ");
        builder.addEmail(scanner.nextLine());

        Contact contact = service.createContact(type, builder);

        System.out.println("Contact created with ID: " + contact.getContactId());
    }
}