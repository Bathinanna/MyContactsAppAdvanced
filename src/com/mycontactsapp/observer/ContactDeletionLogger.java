package com.mycontactsapp.observer;

import com.mycontactsapp.model.Contact;

public class ContactDeletionLogger implements ContactObserver {

    @Override
    public void onContactDeleted(Contact contact) {

        System.out.println(
                "Contact deleted: " + contact.getName()
        );
    }
}