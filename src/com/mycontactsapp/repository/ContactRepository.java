package com.mycontactsapp.repository;

import com.mycontactsapp.model.*;

import java.util.*;

public class ContactRepository {
    private static Map<String, Contact> contacts = new HashMap<>();

    public static void save(Contact contact) {
        contacts.put(contact.getContactId(), contact);
    }

    public static Collection<Contact> getAll() {
        return contacts.values();
    }
    
 // find contact by id
    public static Optional<Contact> findById(String id) {
        return Optional.ofNullable(contacts.get(id));
    }
}
