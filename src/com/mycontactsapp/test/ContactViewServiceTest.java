package com.mycontactsapp.test;

import com.mycontactsapp.builder.ContactBuilder;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.service.ContactService;
import com.mycontactsapp.service.ContactViewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactViewServiceTest {

    private ContactService contactService;
    private ContactViewService viewService;
    private Contact contact;

    // Runs before every test
    @BeforeEach
    void setup() {

        contactService = new ContactService();
        viewService = new ContactViewService();

        ContactBuilder builder = new ContactBuilder()
                .setName("Sindhur")
                .addPhone("9999999999")
                .addEmail("sindhur@gmail.com");

        contact = contactService.createContact("PERSON", builder);
    }


    // Test normal contact display
    @Test
    void testBasicContactDisplay() {

        String result = viewService.viewContact(contact, false, false);

        assertTrue(result.contains("Sindhur"));
        assertTrue(result.contains("9999999999"));
        assertTrue(result.contains("sindhur@gmail.com"));
    }


    // Test uppercase name decorator
    @Test
    void testUppercaseDecorator() {

        String result = viewService.viewContact(contact, true, false);

        assertTrue(result.contains("SINDHUR"));
    }


    // Test email masking decorator
    @Test
    void testEmailMaskDecorator() {

        String result = viewService.viewContact(contact, false, true);

        assertTrue(result.contains("***@"));
    }


    // Test both decorators together
    @Test
    void testCombinedDecorators() {

        String result = viewService.viewContact(contact, true, true);

        assertTrue(result.contains("SINDHUR"));
        assertTrue(result.contains("***@"));
    }


    // Ensure contact ID and timestamp exist
    @Test
    void testContactMetadataDisplayed() {

        String result = viewService.viewContact(contact, false, false);

        assertTrue(result.contains(contact.getContactId()));
        assertTrue(result.contains(contact.getCreatedAt().toString()));
    }
}