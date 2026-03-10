package com.mycontactsapp.ui;

import com.mycontactsapp.filter.*;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.service.ContactFilterService;
import com.mycontactsapp.strategy.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public class AdvancedFilterUI {

    public static void start() {

        ContactFilterService service = new ContactFilterService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("1 Filter by Tag");
        System.out.println("2 Filter by Date Added");

        int choice = scanner.nextInt();
        scanner.nextLine();

        CompositeFilter filter = new CompositeFilter();

        switch(choice) {

            case 1:
                System.out.print("Enter tag: ");
                String tag = scanner.nextLine();
                filter.addFilter(new TagFilter(tag));
                break;

            case 2:
                filter.addFilter(
                    new DateAddedFilter(LocalDateTime.now().minusDays(7))
                );
                break;
        }
    }
}