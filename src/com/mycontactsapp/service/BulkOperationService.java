package com.mycontactsapp.service;

import com.mycontactsapp.composite.ContactComponent;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.tag.*;

import java.util.List;

public class BulkOperationService {

    // bulk delete
    public void deleteContacts(ContactComponent component) {

        component.getContacts()
                .forEach(contact -> contact.setDeleted(true));
    }


    public void tagContacts(ContactComponent component, Tag tag) {

        component.getContacts()
                .forEach(contact -> contact.addTag(tag));
    }


    // export contacts
    public List<String> exportContacts(ContactComponent component) {

        return component.getContacts()
                .stream()
                .map(Contact::getName)
                .toList();
    }
}