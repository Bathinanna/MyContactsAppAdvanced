package com.mycontactsapp.test;

import com.mycontactsapp.builder.ContactBuilder;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.service.ContactDeleteService;
import com.mycontactsapp.service.ContactService;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactDeleteServiceTest {

    @Test
    void testSoftDelete() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Alice")
                .addPhone("9999999999")
                .addEmail("alice@email.com");

        ContactService service = new ContactService();

        Contact contact = service.createContact("PERSON", builder);

        ContactDeleteService deleteService = new ContactDeleteService();

        deleteService.softDelete(contact);

        assertTrue(contact.isDeleted());
    }


    @Test
    void testHardDelete() {

        ContactBuilder builder = new ContactBuilder()
                .setName("Bob")
                .addPhone("8888888888")
                .addEmail("bob@email.com");

        ContactService service = new ContactService();

        Contact contact = service.createContact("PERSON", builder);

        ContactDeleteService deleteService = new ContactDeleteService();

        deleteService.hardDelete(contact);

        assertFalse(
            com.mycontactsapp.repository.ContactRepository
                    .findById(contact.getContactId())
                    .isPresent()
        );
    }
}