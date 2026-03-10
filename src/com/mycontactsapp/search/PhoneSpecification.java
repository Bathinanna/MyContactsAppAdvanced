package com.mycontactsapp.search;

import com.mycontactsapp.model.Contact;
import com.mycontactsapp.model.PhoneNumber;

public class PhoneSpecification implements SearchCriteria {

    private String phone;

    public PhoneSpecification(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean isSatisfied(Contact contact) {

        for (PhoneNumber p : contact.getPhones()) {

            if (p.getNumber().contains(phone))
                return true;
        }

        return false;
    }
}