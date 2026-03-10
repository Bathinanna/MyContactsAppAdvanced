package com.mycontactsapp.decorator;

import com.mycontactsapp.model.Contact;

public class UpperCaseNameDecorator extends ContactDecorator {

    private Contact contact;

    public UpperCaseNameDecorator(ContactView view, Contact contact) {
        super(view);
        this.contact = contact;
    }

    @Override
    public String display() {

        String result = decoratedView.display();

        String original = contact.getName();
        String upper = original.toUpperCase();

        return result.replace(original, upper);
    }
}