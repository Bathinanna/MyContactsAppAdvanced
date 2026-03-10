package com.mycontactsapp.strategy;

import com.mycontactsapp.model.Contact;

import java.util.Comparator;

public class SortByNameStrategy implements SortStrategy {

    @Override
    public Comparator<Contact> getComparator() {

        return Comparator.comparing(Contact::getName);
    }
}