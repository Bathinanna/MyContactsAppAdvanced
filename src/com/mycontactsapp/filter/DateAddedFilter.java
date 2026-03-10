package com.mycontactsapp.filter;

import com.mycontactsapp.model.Contact;

import java.time.LocalDateTime;

public class DateAddedFilter implements ContactFilter {

    private LocalDateTime after;

    public DateAddedFilter(LocalDateTime after) {
        this.after = after;
    }

    @Override
    public boolean apply(Contact contact) {

        return contact.getCreatedAt().isAfter(after);
    }
}