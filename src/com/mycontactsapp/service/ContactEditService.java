package com.mycontactsapp.service;

import com.mycontactsapp.command.CommandManager;
import com.mycontactsapp.command.EditContactCommand;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.model.EmailAddress;
import com.mycontactsapp.model.PhoneNumber;

import java.util.List;

public class ContactEditService {

    private CommandManager manager = new CommandManager();

    public void editContact(
            Contact contact,
            String newName,
            List<PhoneNumber> phones,
            List<EmailAddress> emails
    )
    {
        EditContactCommand command = new EditContactCommand(contact, newName, phones, emails);
        manager.execute(command);
    }

    public void undo() {
        manager.undo();
    }

    public void redo() {
        manager.redo();
    }
}