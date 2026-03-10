package com.mycontactsapp.service;

import com.mycontactsapp.builder.*;
import com.mycontactsapp.factory.*;
import com.mycontactsapp.model.*;
import com.mycontactsapp.repository.*;

public class ContactService {

    public Contact createContact(String type, ContactBuilder builder) {
        Contact contact = ContactFactory.createContact(type, builder);
        ContactRepository.save(contact);
        return contact;
    }
}