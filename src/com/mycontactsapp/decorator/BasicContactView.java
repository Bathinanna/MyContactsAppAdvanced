package com.mycontactsapp.decorator;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.model.PhoneNumber;
import com.mycontactsapp.model.EmailAddress;

public class BasicContactView implements ContactView {

    protected Contact contact;

    public BasicContactView(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String display() {

        StringBuilder builder = new StringBuilder();

        builder.append("Contact ID: ").append(contact.getContactId()).append("\n");
        builder.append("Name: ").append(contact.getName()).append("\n");
        builder.append("Type: ").append(contact.getContactType()).append("\n");

        builder.append("Phones:\n");
        for (PhoneNumber p : contact.getPhones()) {
            builder.append(" - ").append(p.getNumber()).append("\n");
        }

        builder.append("Emails:\n");
        for (EmailAddress e : contact.getEmails()) {
            builder.append(" - ").append(e.getEmail()).append("\n");
        }

        builder.append("Created At: ").append(contact.getCreatedAt()).append("\n");

        return builder.toString();
    }
}