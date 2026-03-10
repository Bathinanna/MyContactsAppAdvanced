package com.mycontactsapp.filter;

import com.mycontactsapp.model.Contact;

public class TagFilter implements ContactFilter {

    private String tag;

    public TagFilter(String tag) {
        this.tag = tag.toLowerCase();
    }

    @Override
    public boolean apply(Contact contact) {

        // placeholder until Tag class implemented
    	return contact.getTags()
    	        .stream()
    	        .anyMatch(t -> t.getName().equalsIgnoreCase(tag));    
    }
}