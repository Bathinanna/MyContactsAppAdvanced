package com.mycontactsapp.service;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.observer.ContactObserver;
import com.mycontactsapp.repository.ContactRepository;

import java.util.ArrayList;
import java.util.List;

public class ContactDeleteService {

    private List<ContactObserver> observers = new ArrayList<>();


    public void addObserver(ContactObserver observer) {
        observers.add(observer);
    }


    private void notifyObservers(Contact contact) {
        for(ContactObserver observer : observers) {
            observer.onContactDeleted(contact);
        }
    }


    public void softDelete(Contact contact) {
        contact.setDeleted(true);
        notifyObservers(contact);
    }


    public void hardDelete(Contact contact) {
        ContactRepository.hardDelete(contact.getContactId());
        notifyObservers(contact);
    }
}