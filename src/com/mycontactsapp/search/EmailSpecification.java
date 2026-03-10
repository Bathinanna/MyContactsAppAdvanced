package com.mycontactsapp.search;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.model.EmailAddress;

public class EmailSpecification implements SearchCriteria {

    private String email;

    public EmailSpecification(String email) {
        this.email = email.toLowerCase();
    }

    @Override
    public boolean isSatisfied(Contact contact) {

        for (EmailAddress e : contact.getEmails()) {

            if (e.getEmail().toLowerCase().contains(email))
                return true;
        }

        return false;
    }
}