package com.mbor.service;

import com.mbor.dao.PostDao;
import com.mbor.dao.TagDao;
import com.mbor.domain.Post;
import com.mbor.domain.Tag;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataLoader {

    private final PostDao postDao;

    private final TagDao tagDao;

    public DataLoader(PostDao postDao, TagDao tagDao) {
        this.postDao = postDao;
        this.tagDao = tagDao;
    }

    @Transactional
    public  void prepareData(){
        Post post = new Post();
        post.setTitle("Post title");
        Tag tag = new Tag();
        tag.setName("TagTitle");
        Long id = tagDao.save(tag).get().getId();
        post.addTag(tagDao.find(id));
        postDao.save(post);
    }
}
