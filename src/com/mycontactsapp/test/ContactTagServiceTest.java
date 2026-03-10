package com.mycontactsapp.test;

import com.mycontactsapp.builder.ContactBuilder;
import com.mycontactsapp.model.Contact;
import com.mycontactsapp.service.ContactService;
import com.mycontactsapp.service.ContactTagService;
import com.mycontactsapp.tag.Tag;
import com.mycontactsapp.tag.TagFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTagServiceTest {

    private ContactService contactService;
    private ContactTagService tagService;

    private Contact contact;

    @BeforeEach
    void setup() {

        contactService = new ContactService();
        tagService = new ContactTagService();

        contact = contactService.createContact(
                "PERSON",
                new ContactBuilder()
                        .setName("Alice")
                        .addPhone("9999999999")
                        .addEmail("alice@gmail.com")
        );
    }

    // Test assigning a tag to a contact
    @Test
    void testAssignTag() {

        tagService.assignTag(contact, "friends");

        assertEquals(1, contact.getTags().size());

        Tag tag = contact.getTags().iterator().next();

        assertEquals("friends", tag.getName());
    }


    // Test removing a tag
    @Test
    void testRemoveTag() {

        tagService.assignTag(contact, "work");

        tagService.removeTag(contact, "work");

        assertTrue(contact.getTags().isEmpty());
    }


    // Test multiple tags on same contact
    @Test
    void testMultipleTags() {

        tagService.assignTag(contact, "friends");
        tagService.assignTag(contact, "family");

        assertEquals(2, contact.getTags().size());
    }


    // Test flyweight pattern (same tag instance reused)
    @Test
    void testFlyweightTagSharing() {

        Tag tag1 = TagFactory.getTag("friends");
        Tag tag2 = TagFactory.getTag("friends");

        assertSame(tag1, tag2);
    }


    // Test duplicate tag prevention (Set ensures uniqueness)
    @Test
    void testDuplicateTagAssignment() {

        tagService.assignTag(contact, "friends");
        tagService.assignTag(contact, "friends");

        assertEquals(1, contact.getTags().size());
    }
}