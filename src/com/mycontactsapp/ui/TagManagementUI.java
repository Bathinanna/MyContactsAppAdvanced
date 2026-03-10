package com.mycontactsapp.ui;

import com.mycontactsapp.service.TagService;
import com.mycontactsapp.tag.Tag;

import java.util.Scanner;

public class TagManagementUI {

    private static Scanner scanner = new Scanner(System.in);

    public static void start() {

        TagService service = new TagService();

        while(true) {

            System.out.println("\n===== Tag Management =====");
            System.out.println("1 Create Tag");
            System.out.println("2 View Tags");
            System.out.println("3 Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {

                case 1:

                    System.out.print("Enter tag name: ");
                    String name = scanner.nextLine();

                    try {

                        Tag tag = service.createTag(name);

                        System.out.println("Tag created: " + tag.getName());

                    } catch(Exception e) {

                        System.out.println(e.getMessage());
                    }

                    break;

                case 2:

                    service.getAllTags()
                           .forEach(tag ->
                               System.out.println(tag.getName())
                           );

                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}