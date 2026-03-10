package com.mycontactsapp.decorator;

public class MaskEmailDecorator extends ContactDecorator {

    public MaskEmailDecorator(ContactView view) {
        super(view);
    }

    @Override
    public String display() {

        String result = decoratedView.display();

        // simple email masking
        return result.replaceAll(
                "([a-zA-Z0-9._%+-])[a-zA-Z0-9._%+-]*@",
                "$1***@"
        );
    }
}