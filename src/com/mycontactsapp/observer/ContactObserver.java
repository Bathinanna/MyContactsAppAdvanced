package com.mycontactsapp.observer;

import com.mycontactsapp.model.Contact;

public interface ContactObserver {

    void onContactDeleted(Contact contact);
}