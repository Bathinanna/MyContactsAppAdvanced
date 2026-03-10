package com.mycontactsapp.model;

public class OrganizationContact extends Contact {

    public OrganizationContact(String name) {
        super(name);
    }

    @Override
    public String getContactType() {
        return "ORGANIZATION";
    }
}