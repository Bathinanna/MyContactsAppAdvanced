package com.mycontactsapp.search;

import com.mycontactsapp.model.Contact;

public class TagSpecification implements SearchCriteria {

    private String tag;

    public TagSpecification(String tag) {
        this.tag = tag.toLowerCase();
    }

    @Override
    public boolean isSatisfied(Contact contact) {

    	return contact.getTags()
    	        .stream()
    	        .anyMatch(t -> t.getName().equalsIgnoreCase(tag));
    }
}