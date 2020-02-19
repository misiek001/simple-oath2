package com.mbor.service;

import com.mbor.domain.Post;

public interface IPostService {


     Post save(Post post);

     Post find(Long id);

}
