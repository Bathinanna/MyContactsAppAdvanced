package com.mycontactsapp.strategy;

import com.mycontactsapp.model.Contact;

import java.util.Comparator;

public interface SortStrategy {

    Comparator<Contact> getComparator();
}