package com.mycontactsapp.test;

import com.mycontactsapp.service.TagService;
import com.mycontactsapp.tag.Tag;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TagServiceTest {

    @Test
    void testCreateTag() {

        TagService service = new TagService();

        Tag tag = service.createTag("Friends");

        assertEquals("friends", tag.getName());
    }

    @Test
    void testDuplicateTag() {

        TagService service = new TagService();

        service.createTag("Work");

        assertThrows(RuntimeException.class,
                () -> service.createTag("Work"));
    }

    @Test
    void testFlyweightSharing() {

        TagService service = new TagService();

        Tag t1 = service.createTag("Family");

        Tag t2 = service.getAllTags()
                .stream()
                .filter(t -> t.getName().equals("family"))
                .findFirst()
                .get();

        assertEquals(t1, t2);
    }
}