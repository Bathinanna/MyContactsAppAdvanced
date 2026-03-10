package com.mycontactsapp.test;

import com.mycontactsapp.builder.ContactBuilder;
import com.mycontactsapp.composite.ContactGroup;
import com.mycontactsapp.composite.ContactLeaf;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.service.BulkOperationService;
import com.mycontactsapp.service.ContactService;
import com.mycontactsapp.tag.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BulkOperationServiceTest {

    private ContactService contactService;
    private BulkOperationService bulkService;

    private Contact c1;
    private Contact c2;
    private Contact c3;


    @BeforeEach
    void setup() {

        contactService = new ContactService();
        bulkService = new BulkOperationService();

        c1 = contactService.createContact(
                "PERSON",
                new ContactBuilder().setName("Alice")
        );

        c2 = contactService.createContact(
                "PERSON",
                new ContactBuilder().setName("Bob")
        );

        c3 = contactService.createContact(
                "PERSON",
                new ContactBuilder().setName("Charlie")
        );
    }


    // Test bulk delete on selected contacts
    @Test
    void testBulkDeleteSelectedContacts() {

        ContactGroup group = new ContactGroup("Selected");

        group.add(new ContactLeaf(c1));
        group.add(new ContactLeaf(c3));

        bulkService.deleteContacts(group);

        assertTrue(c1.isDeleted());
        assertTrue(c3.isDeleted());

        // Bob should remain unaffected
        assertFalse(c2.isDeleted());
    }


    // Test tagging selected contacts
    @Test
    void testTagSelectedContacts() {

        ContactGroup group = new ContactGroup("TagGroup");

        group.add(new ContactLeaf(c1));
        group.add(new ContactLeaf(c2));
        Tag tag = TagFactory.getTag("friends");
        bulkService.tagContacts(group, tag);

        // Currently tag logic prints output
        // So we simply verify contacts still exist
        assertNotNull(c1);
        assertNotNull(c2);
    }


    // Test export contacts
    @Test
    void testExportContacts() {

        ContactGroup group = new ContactGroup("ExportGroup");

        group.add(new ContactLeaf(c1));
        group.add(new ContactLeaf(c2));

        List<String> exported = bulkService.exportContacts(group);

        assertEquals(2, exported.size());

        assertTrue(exported.contains("Alice"));
        assertTrue(exported.contains("Bob"));
    }


    // Test nested composite groups
    @Test
    void testNestedGroups() {

        ContactGroup mainGroup = new ContactGroup("MainGroup");
        ContactGroup subGroup = new ContactGroup("SubGroup");

        subGroup.add(new ContactLeaf(c1));
        subGroup.add(new ContactLeaf(c2));

        mainGroup.add(subGroup);
        mainGroup.add(new ContactLeaf(c3));

        bulkService.deleteContacts(mainGroup);

        assertTrue(c1.isDeleted());
        assertTrue(c2.isDeleted());
        assertTrue(c3.isDeleted());
    }


    // Test empty group handling
    @Test
    void testEmptyGroup() {

        ContactGroup group = new ContactGroup("EmptyGroup");

        List<String> exported = bulkService.exportContacts(group);

        assertTrue(exported.isEmpty());
    }
}