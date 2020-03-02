package com.mbor.service;

import com.mbor.dao.PostDao;
import com.mbor.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService implements IPostService {

    private final PostDao postDao;

    @Autowired
    public PostService(PostDao postDao) {
        this.postDao = postDao;
    }

    @Override
    public Post save(Post post) {
        return saveInternal(post);
    }

    private Post saveInternal(Post post){
        return postDao.save(post).get();
    }

    @Override
    public Post find(Long id) {
        return postDao.find(id).get();
    }
}
