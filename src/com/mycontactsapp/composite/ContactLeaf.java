package com.mycontactsapp.composite;

import com.mycontactsapp.model.Contact;

import java.util.Collections;
import java.util.List;

public class ContactLeaf implements ContactComponent {
    private Contact contact;

    public ContactLeaf(Contact contact) {
        this.contact = contact;
    }

    @Override
    public List<Contact> getContacts() {
        return Collections.singletonList(contact);
    }
}