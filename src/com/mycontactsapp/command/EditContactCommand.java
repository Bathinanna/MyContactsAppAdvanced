package com.mycontactsapp.command;

import com.mycontactsapp.memento.ContactMemento;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.model.EmailAddress;
import com.mycontactsapp.model.PhoneNumber;

import java.util.List;

public class EditContactCommand {

    private Contact contact;
    private ContactMemento backup;

    private String newName;
    private List<PhoneNumber> newPhones;
    private List<EmailAddress> newEmails;

    public EditContactCommand(
            Contact contact,
            String newName,
            List<PhoneNumber> newPhones,
            List<EmailAddress> newEmails
    ) {

        this.contact = contact;
        this.newName = newName;
        this.newPhones = newPhones;
        this.newEmails = newEmails;
    }

    public void execute() {

        // save previous state
        backup = new ContactMemento(contact);

        // update name
        if(newName != null)
            contact.setName(newName);

        // update phones
        if(newPhones != null) {
            contact.getPhones().clear();
            contact.getPhones().addAll(newPhones);
        }

        // update emails
        if(newEmails != null) {
            contact.getEmails().clear();
            contact.getEmails().addAll(newEmails);
        }
    }

    public void undo() {

        if(backup != null) {

            contact.setName(backup.getName());

            contact.getPhones().clear();
            contact.getPhones().addAll(backup.getPhones());

            contact.getEmails().clear();
            contact.getEmails().addAll(backup.getEmails());
        }
    }
}