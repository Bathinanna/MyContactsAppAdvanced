package com.mycontactsapp.filter;

import com.mycontactsapp.model.Contact;

public interface ContactFilter {

    boolean apply(Contact contact);
}