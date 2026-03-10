package com.mycontactsapp.service;

import com.mycontactsapp.composite.ContactComponent;
import com.mycontactsapp.model.Contact;

import java.util.List;

public class BulkOperationService {

    // bulk delete
    public void deleteContacts(ContactComponent component) {

        component.getContacts()
                .forEach(contact -> contact.setDeleted(true));
    }


    // bulk tagging
    public void tagContacts(ContactComponent component, String tag) {

        component.getContacts()
                .forEach(contact ->
                        System.out.println("Tagging " +
                                contact.getName() + " with " + tag)
                );
    }


    // export contacts
    public List<String> exportContacts(ContactComponent component) {

        return component.getContacts()
                .stream()
                .map(Contact::getName)
                .toList();
    }
}