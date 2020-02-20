package com.mbor.dao;

import com.mbor.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends RawDao<Post> {

    public PostDao() {
        this.clazz = Post.class;
    }

}
