package com.mycontactsapp.builder;


import com.mycontactsapp.model.*;

import java.util.ArrayList;
import java.util.List;

public class ContactBuilder {

    private String name;

    private List<PhoneNumber> phones = new ArrayList<>();
    private List<EmailAddress> emails = new ArrayList<>();


    public ContactBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContactBuilder addPhone(String phone) {
        phones.add(new PhoneNumber(phone));
        return this;
    }

    public ContactBuilder addEmail(String email) {
        emails.add(new EmailAddress(email));
        return this;
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