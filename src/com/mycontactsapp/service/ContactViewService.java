package com.mycontactsapp.service;

import com.mycontactsapp.decorator.BasicContactView;
import com.mycontactsapp.decorator.ContactView;
import com.mycontactsapp.decorator.MaskEmailDecorator;
import com.mycontactsapp.decorator.UpperCaseNameDecorator;
import com.mycontactsapp.model.Contact;

public class ContactViewService {

	public String viewContact(Contact contact, boolean uppercase, boolean maskEmail) {
	    ContactView view = new BasicContactView(contact);
	    if (uppercase)
	        view = new UpperCaseNameDecorator(view, contact);
	    if (maskEmail)
	        view = new MaskEmailDecorator(view);
	    return view.display();
	}
}