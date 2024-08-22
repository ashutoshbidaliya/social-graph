package com.ab.proj.userservice.service;

import com.ab.proj.userservice.model.Post;
import com.ab.proj.userservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public Post createPost() {
        Post post = new Post();
        return post;

    }
}
