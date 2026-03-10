package com.mycontactsapp.observer;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.tag.Tag;

public interface TagObserver {

    void onTagAdded(Contact contact, Tag tag);

    void onTagRemoved(Contact contact, Tag tag);
}