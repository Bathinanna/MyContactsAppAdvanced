package com.mycontactsapp.pipeline;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.search.SearchCriteria;

import java.util.List;
import java.util.stream.Collectors;

public class SearchFilter {

    private SearchCriteria criteria;

    public SearchFilter(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    public List<Contact> apply(List<Contact> contacts) {

        return contacts.stream()
                .filter(criteria::isSatisfied)
                .collect(Collectors.toList());
    }
}