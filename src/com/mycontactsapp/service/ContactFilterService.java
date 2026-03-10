package com.mycontactsapp.service;

import com.mycontactsapp.filter.ContactFilter;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.repository.ContactRepository;
import com.mycontactsapp.strategy.SortStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class ContactFilterService {

    public List<Contact> filterContacts(
            ContactFilter filter,
            SortStrategy sortStrategy
    ) {

        return ContactRepository.getAll()
                .stream()
                .filter(filter::apply)
                .sorted(sortStrategy.getComparator())
                .collect(Collectors.toList());
    }
}