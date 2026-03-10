package com.mycontactsapp.filter;

import com.mycontactsapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class CompositeFilter implements ContactFilter {

    private List<ContactFilter> filters = new ArrayList<>();

    public void addFilter(ContactFilter filter) {
        filters.add(filter);
    }

    @Override
    public boolean apply(Contact contact) {

        for (ContactFilter filter : filters) {

            if (!filter.apply(contact))
                return false;
        }

        return true;
    }
}