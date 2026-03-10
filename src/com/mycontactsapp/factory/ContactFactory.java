package com.mycontactsapp.factory;

import com.mycontactsapp.builder.*;
import com.mycontactsapp.model.*;

public class ContactFactory {

    public static Contact createContact(String type, ContactBuilder builder) {

        Contact contact;

        if(type.equalsIgnoreCase("PERSON")) {
            contact = new PersonContact(builder.getName());
        } else if(type.equalsIgnoreCase("ORG")) {
            contact = new OrganizationContact(builder.getName());
        } else {
            throw new IllegalArgumentException("Invalid contact type");
        }

        // attach phones
        for(PhoneNumber p : builder.getPhones()) {
            contact.addPhone(p);
        }

        // attach emails
        for(EmailAddress e : builder.getEmails()) {
            contact.addEmail(e);
        }

        return contact;
    }
}
