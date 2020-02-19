package com.mbor.service;

import com.mbor.domain.Tag;

public interface ITagService {

    Tag save(Tag tag);

    Tag find(Long id);
}
