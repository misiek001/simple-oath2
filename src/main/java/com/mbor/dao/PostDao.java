package com.mbor.dao;

import com.mbor.domain.Post;
import org.springframework.stereotype.Repository;

@Repository
public class PostDao extends RawDao<Post> {

    public Post find(Long id){
        return  entityManager.find(Post.class, id);
    }

}
