package com.mycontactsapp.pipeline;

import com.mycontactsapp.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class SearchPipeline {

    private List<SearchFilter> filters = new ArrayList<>();

    public void addFilter(SearchFilter filter) {
        filters.add(filter);
    }

    public List<Contact> execute(List<Contact> contacts) {

        List<Contact> result = contacts;

        for (SearchFilter filter : filters) {
            result = filter.apply(result);
        }

        return result;
    }
}