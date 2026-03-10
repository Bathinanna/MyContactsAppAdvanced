package com.mycontactsapp.observer;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.tag.Tag;

public class TagChangeLogger implements TagObserver {

    @Override
    public void onTagAdded(Contact contact, Tag tag) {

        System.out.println(
            "Tag '" + tag.getName() +
            "' added to " + contact.getName()
        );
    }

    @Override
    public void onTagRemoved(Contact contact, Tag tag) {

        System.out.println(
            "Tag '" + tag.getName() +
            "' removed from " + contact.getName()
        );
    }
}