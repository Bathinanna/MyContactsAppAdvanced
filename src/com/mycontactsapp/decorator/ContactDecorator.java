package com.mycontactsapp.decorator;

// abstract decorator
public abstract class ContactDecorator implements ContactView {

    protected ContactView decoratedView;

    public ContactDecorator(ContactView view) {
        this.decoratedView = view;
    }

    @Override
    public String display() {
        return decoratedView.display();
    }
}