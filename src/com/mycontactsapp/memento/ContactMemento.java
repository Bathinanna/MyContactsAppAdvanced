package com.mycontactsapp.memento;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.model.EmailAddress;
import com.mycontactsapp.model.PhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class ContactMemento {

    private String name;
    private List<PhoneNumber> phones;
    private List<EmailAddress> emails;

    public ContactMemento(Contact contact) {

        this.name = contact.getName();

        // deep copy lists
        this.phones = new ArrayList<>(contact.getPhones());
        this.emails = new ArrayList<>(contact.getEmails());
    }

    public String getName() {
        return name;
    }

    public List<PhoneNumber> getPhones() {
        return phones;
    }

    public List<EmailAddress> getEmails() {
        return emails;
    }
}