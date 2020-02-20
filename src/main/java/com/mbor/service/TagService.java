package com.mbor.service;

import com.mbor.dao.TagDao;
import com.mbor.domain.Tag;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TagService extends RawService<Tag> implements  ITagService{

    private final TagDao tagDao;

    public TagService(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public Tag save(Tag tag) {
        return tagDao.save(tag).get();
    }

    @Override
    public Tag find(Long id) {
        return tagDao.find(id).get();
    }
}
