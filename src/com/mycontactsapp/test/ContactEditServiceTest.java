package com.mycontactsapp.test;

import com.mycontactsapp.builder.ContactBuilder;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.model.EmailAddress;
import com.mycontactsapp.model.PhoneNumber;
import com.mycontactsapp.service.ContactEditService;
import com.mycontactsapp.service.ContactService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContactEditServiceTest {

    private ContactService contactService;
    private ContactEditService editService;
    private Contact contact;


    @BeforeEach
    void setup() {

        contactService = new ContactService();
        editService = new ContactEditService();

        ContactBuilder builder = new ContactBuilder()
                .setName("Alice")
                .addPhone("9999999999")
                .addEmail("alice@email.com");

        contact = contactService.createContact("PERSON", builder);
    }


    // Test editing only the name
    @Test
    void testEditName() {

        editService.editContact(contact, "AliceUpdated", null, null);

        assertEquals("AliceUpdated", contact.getName());
    }


    // Test editing phone numbers
    @Test
    void testEditPhoneNumbers() {

        List<PhoneNumber> phones = new ArrayList<>();
        phones.add(new PhoneNumber("1111111111"));
        phones.add(new PhoneNumber("2222222222"));

        editService.editContact(contact, null, phones, null);

        assertEquals(2, contact.getPhones().size());
        assertEquals("1111111111", contact.getPhones().get(0).getNumber());
    }


    // Test editing emails
    @Test
    void testEditEmails() {

        List<EmailAddress> emails = new ArrayList<>();
        emails.add(new EmailAddress("new@email.com"));

        editService.editContact(contact, null, null, emails);

        assertEquals(1, contact.getEmails().size());
        assertEquals("new@email.com", contact.getEmails().get(0).getEmail());
    }


    // Test undo functionality
    @Test
    void testUndoEdit() {

        editService.editContact(contact, "AliceUpdated", null, null);

        assertEquals("AliceUpdated", contact.getName());

        editService.undo();

        assertEquals("Alice", contact.getName());
    }


    // Test redo functionality
    @Test
    void testRedoEdit() {

        editService.editContact(contact, "AliceUpdated", null, null);

        editService.undo();

        editService.redo();

        assertEquals("AliceUpdated", contact.getName());
    }


    // Test partial update (only phone change)
    @Test
    void testPartialUpdatePhonesOnly() {

        List<PhoneNumber> phones = new ArrayList<>();
        phones.add(new PhoneNumber("5555555555"));

        editService.editContact(contact, null, phones, null);

        assertEquals(1, contact.getPhones().size());
        assertEquals("5555555555", contact.getPhones().get(0).getNumber());
    }


    // Test partial update (only email change)
    @Test
    void testPartialUpdateEmailsOnly() {

        List<EmailAddress> emails = new ArrayList<>();
        emails.add(new EmailAddress("partial@email.com"));

        editService.editContact(contact, null, null, emails);

        assertEquals(1, contact.getEmails().size());
        assertEquals("partial@email.com", contact.getEmails().get(0).getEmail());
    }
}