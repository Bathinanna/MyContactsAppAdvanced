package com.mycontactsapp.search;

import com.mycontactsapp.model.Contact;

public class NameSpecification implements SearchCriteria {

    private String keyword;

    public NameSpecification(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public boolean isSatisfied(Contact contact) {

        return contact.getName()
                .toLowerCase()
                .contains(keyword);
    }
}