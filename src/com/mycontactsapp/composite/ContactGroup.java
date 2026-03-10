package com.mycontactsapp.composite;

import com.mycontactsapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactGroup implements ContactComponent {
    private String groupName;
    private List<ContactComponent> children = new ArrayList<>();

    public ContactGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(ContactComponent component) {
        children.add(component);
    }

    public void remove(ContactComponent component) {
        children.remove(component);
    }

    @Override
    public List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        for(ContactComponent child : children) {
            contacts.addAll(child.getContacts());
        }
        return contacts;
    }

    public String getGroupName() {
        return groupName;
    }
}