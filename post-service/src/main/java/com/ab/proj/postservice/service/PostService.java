package com.ab.proj.postservice.service;

import com.ab.proj.postservice.entity.Post;
import com.ab.proj.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post savePost(Post post) {
        return repo.save(post);
    }

    public void deletePost(Integer id) {
        repo.deleteById(id);
    }

    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    public Post getPostById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    public Post getPostByUserId(Long userId) {
        return repo.findByUserId(userId).orElseThrow();
    }
}
