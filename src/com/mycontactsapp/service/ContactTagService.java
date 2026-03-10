package com.mycontactsapp.service;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.observer.TagObserver;
import com.mycontactsapp.tag.Tag;
import com.mycontactsapp.tag.TagFactory;

import java.util.ArrayList;
import java.util.List;

public class ContactTagService {

    private List<TagObserver> observers = new ArrayList<>();

    public void addObserver(TagObserver observer) {
        observers.add(observer);
    }

    public void assignTag(Contact contact, String tagName) {

    	Tag tag = TagFactory.getTag(tagName);

    	contact.addTag(tag);
    }

    public void removeTag(Contact contact, String tagName) {

    	Tag tag = TagFactory.getTag(tagName);

    	contact.removeTag(tag);
    }

    private void notifyTagAdded(Contact contact, Tag tag) {

        for(TagObserver observer : observers) {
            observer.onTagAdded(contact, tag);
        }
    }

    private void notifyTagRemoved(Contact contact, Tag tag) {

        for(TagObserver observer : observers) {
            observer.onTagRemoved(contact, tag);
        }
    }
    
    
}