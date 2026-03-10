package com.mycontactsapp.test;

import com.mycontactsapp.builder.ContactBuilder;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.search.EmailSpecification;
import com.mycontactsapp.search.NameSpecification;
import com.mycontactsapp.search.PhoneSpecification;
import com.mycontactsapp.service.ContactSearchService;
import com.mycontactsapp.service.ContactService;
import com.mycontactsapp.repository.ContactRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContactSearchServiceTest {

    private ContactService contactService;
    private ContactSearchService searchService;

    private Contact c1;
    private Contact c2;
    private Contact c3;

    @BeforeEach
    void setup() {

        ContactRepository.clear();   // reset repository

        contactService = new ContactService();
        searchService = new ContactSearchService();

        c1 = contactService.createContact(
                "PERSON",
                new ContactBuilder()
                        .setName("Alice")
                        .addPhone("9999999999")
                        .addEmail("alice@gmail.com")
        );

        c2 = contactService.createContact(
                "PERSON",
                new ContactBuilder()
                        .setName("Bob")
                        .addPhone("8888888888")
                        .addEmail("bob@yahoo.com")
        );

        c3 = contactService.createContact(
                "PERSON",
                new ContactBuilder()
                        .setName("Charlie")
                        .addPhone("7777777777")
                        .addEmail("charlie@gmail.com")
        );
    }


    // Test search by name
    @Test
    void testSearchByName() {

        List<Contact> results =
                searchService.search(new NameSpecification("Ali"));

        assertEquals(1, results.size());
        assertEquals("Alice", results.get(0).getName());
    }


    // Test case-insensitive search
    @Test
    void testCaseInsensitiveSearch() {

        List<Contact> results =
                searchService.search(new NameSpecification("alice"));

        assertEquals(1, results.size());
        assertEquals("Alice", results.get(0).getName());
    }


    // Test search by phone
    @Test
    void testSearchByPhone() {

        List<Contact> results =
                searchService.search(new PhoneSpecification("8888"));

        assertEquals(1, results.size());
        assertEquals("Bob", results.get(0).getName());
    }


    // Test search by email
    @Test
    void testSearchByEmail() {

        List<Contact> results =
                searchService.search(new EmailSpecification("gmail"));

        assertEquals(2, results.size());
    }


    // Test no results found
    @Test
    void testNoMatch() {

        List<Contact> results =
                searchService.search(new NameSpecification("David"));

        assertTrue(results.isEmpty());
    }


    // Test partial phone match
    @Test
    void testPartialPhoneMatch() {

        List<Contact> results =
                searchService.search(new PhoneSpecification("999"));

        assertEquals(1, results.size());
        assertEquals("Alice", results.get(0).getName());
    }


    // Test multiple results scenario
    @Test
    void testMultipleResults() {

        List<Contact> results =
                searchService.search(new EmailSpecification("gmail"));

        assertEquals(2, results.size());

        assertTrue(
                results.stream()
                        .anyMatch(c -> c.getName().equals("Alice"))
        );

        assertTrue(
                results.stream()
                        .anyMatch(c -> c.getName().equals("Charlie"))
        );
    }
}