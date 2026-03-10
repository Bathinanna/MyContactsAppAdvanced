package com.mycontactsapp.filter;

import com.mycontactsapp.model.Contact;

public class FrequentContactFilter implements ContactFilter {

    private int threshold;

    public FrequentContactFilter(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean apply(Contact contact) {

        // placeholder logic
        return contact.getName().length() > threshold;
    }
}