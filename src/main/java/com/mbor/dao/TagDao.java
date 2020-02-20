package com.mbor.dao;

import com.mbor.domain.Tag;
import org.springframework.stereotype.Repository;

@Repository
public class TagDao extends RawDao<Tag> {

    public TagDao() {
        this.clazz = Tag.class;
    }
}
