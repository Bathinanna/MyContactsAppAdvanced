package com.mycontactsapp.search;

import com.mycontactsapp.model.Contact;

public interface SearchCriteria {

    boolean isSatisfied(Contact contact);
}