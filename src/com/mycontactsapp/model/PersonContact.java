package com.mycontactsapp.model;

public class PersonContact extends Contact {

    public PersonContact(String name) {
        super(name);
    }

    @Override
    public String getContactType() {
        return "PERSON";
    }
}