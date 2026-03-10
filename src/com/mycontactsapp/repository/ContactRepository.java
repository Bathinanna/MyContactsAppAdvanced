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
    
    // Deletion Logic
    public static void softDelete(String id) {
        Contact contact = contacts.get(id);
        if(contact != null) {
            contact.setDeleted(true);
        }
    }

    public static void hardDelete(String id) {
        contacts.remove(id);
    }
}
