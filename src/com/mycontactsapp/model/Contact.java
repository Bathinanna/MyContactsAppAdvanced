package com.mycontactsapp.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Contact {

    private String contactId;
    private String name;
    private List<PhoneNumber> phones = new ArrayList<>();
    private List<EmailAddress> emails = new ArrayList<>();
    private LocalDateTime createdAt;
    private boolean deleted = false;

    

    public Contact(String name) {
        // generate unique id
        this.contactId = UUID.randomUUID().toString();
        this.name = name;
        // record creation time
        this.createdAt = LocalDateTime.now();
    }

    public String getContactId() {
        return contactId;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

	public List<PhoneNumber> getPhones() {
        return phones;
    }

    public List<EmailAddress> getEmails() {
        return emails;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // add phone
    public void addPhone(PhoneNumber phone) {
        phones.add(phone);
    }

    // add email
    public void addEmail(EmailAddress email) {
        emails.add(email);
    }

    public abstract String getContactType();
    
    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}