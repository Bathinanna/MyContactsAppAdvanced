package com.mycontactsapp.test;

import com.mycontactsapp.builder.*;
import com.mycontactsapp.model.*;
import org.junit.jupiter.api.Test;
import com.mycontactsapp.service.*;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    // Test basic contact creation
    @Test
    void testCreatePersonContact() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Sindhur")
                .addPhone("8341485158")
                .addEmail("sindhur@gmail.com");

        ContactService service = new ContactService();

        Contact contact = service.createContact("PERSON", builder);

        assertEquals("Sindhur", contact.getName());
        assertEquals("PERSON", contact.getContactType());
        assertEquals(1, contact.getPhones().size());
        assertEquals(1, contact.getEmails().size());
    }


    // Test organization contact creation
    @Test
    void testCreateOrganizationContact() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Google")
                .addPhone("1234567890")
                .addEmail("support@google.com");

        ContactService service = new ContactService();

        Contact contact = service.createContact("ORG", builder);

        assertEquals("Google", contact.getName());
        assertEquals("ORGANIZATION", contact.getContactType());
    }


    // Test multiple phone numbers
    @Test
    void testMultiplePhoneNumbers() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Amma")
                .addPhone("9491921052")
                .addPhone("9014525514")
                .addEmail("sindhur@gmail.com");

        ContactService service = new ContactService();

        Contact contact = service.createContact("PERSON", builder);

        assertEquals(2, contact.getPhones().size());
    }


    // Test multiple email addresses
    @Test
    void testMultipleEmails() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Nanna")
                .addPhone("8500133193")
                .addEmail("chandramohan@gmail.com")
                .addEmail("mohanchandra@gmail.com");

        ContactService service = new ContactService();

        Contact contact = service.createContact("PERSON", builder);

        assertEquals(2, contact.getEmails().size());
    }


    // Test invalid contact type
    @Test
    void testInvalidContactType() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Test")
                .addPhone("9999999999")
                .addEmail("test@email.com");

        ContactService service = new ContactService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.createContact("INVALID", builder)
        );
    }


    // Test contact ID generation
    @Test
    void testContactIdGenerated() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Alice")
                .addPhone("9999999999")
                .addEmail("alice@email.com");

        ContactService service = new ContactService();

        Contact contact = service.createContact("PERSON", builder);

        assertNotNull(contact.getContactId());
    }


    // Test timestamp generation
    @Test
    void testTimestampGenerated() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Alice")
                .addPhone("9999999999")
                .addEmail("alice@email.com");

        ContactService service = new ContactService();

        Contact contact = service.createContact("PERSON", builder);

        assertNotNull(contact.getCreatedAt());
    }
}