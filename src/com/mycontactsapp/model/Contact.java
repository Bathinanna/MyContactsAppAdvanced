package com.mycontactsapp.model;
import com.mycontactsapp.tag.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

public abstract class Contact {

    private String contactId;
    private String name;
    private List<PhoneNumber> phones = new ArrayList<>();
    private List<EmailAddress> emails = new ArrayList<>();
    private LocalDateTime createdAt;
    private boolean deleted = false;
    
    private Set<Tag> tags = new HashSet<>();

   
    

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
    
    public Set<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

}