package com.mycontactsapp.tag;

import java.util.HashSet;
import java.util.Set;

public class TagRepository {

    private static Set<Tag> tags = new HashSet<>();

    public static void addTag(Tag tag) {

        tags.add(tag);
    }

    public static Set<Tag> getAllTags() {

        return tags;
    }

    public static boolean exists(String name) {

        return tags.stream()
                .anyMatch(t -> t.getName().equalsIgnoreCase(name));
    }
}