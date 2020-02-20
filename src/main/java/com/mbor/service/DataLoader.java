package com.mbor.service;


import com.mbor.domain.Post;
import com.mbor.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;

@Service
public class DataLoader {

    private final IPostService postService;

    private final ITagService tagService;

    @Autowired
    public DataLoader(IPostService postService, ITagService tagService) {
        this.postService = postService;
        this.tagService = tagService;
    }

    @PostConstruct
    public  void prepareData(){
        Post post = new Post();
        post.setTitle("Post title");
        Tag tag = new Tag();
        tag.setName("TagTitle");
        post.addTag(tag);
        postService.save(post);
    }
}
