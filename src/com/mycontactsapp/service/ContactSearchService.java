package com.mycontactsapp.service;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.pipeline.SearchFilter;
import com.mycontactsapp.pipeline.SearchPipeline;
import com.mycontactsapp.repository.ContactRepository;
import com.mycontactsapp.search.SearchCriteria;

import java.util.List;

public class ContactSearchService {

    public List<Contact> search(SearchCriteria criteria) {

        SearchPipeline pipeline = new SearchPipeline();

        pipeline.addFilter(new SearchFilter(criteria));

        return pipeline.execute(
                ContactRepository.getAll()
                        .stream()
                        .toList()
        );
    }
}