package com.mycontactsapp.service;

import com.mycontactsapp.tag.Tag;
import com.mycontactsapp.tag.TagFactory;
import com.mycontactsapp.tag.TagRepository;

import java.util.Set;

public class TagService {

    public Tag createTag(String name) {

        if(TagRepository.exists(name))
            throw new RuntimeException("Tag already exists");

        Tag tag = TagFactory.getTag(name);

        TagRepository.addTag(tag);

        return tag;
    }

    public Set<Tag> getAllTags() {

        return TagRepository.getAllTags();
    }
}