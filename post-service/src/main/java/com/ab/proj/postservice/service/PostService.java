package com.ab.proj.postservice.service;

import com.ab.proj.postservice.entity.Post;
import com.ab.proj.postservice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post savePost(Post post) {
        return repo.save(post);
    }

    public void deletePostById(Integer id) {
        repo.deleteById(id);
    }

    public List<Post> getAllPosts(){
        return repo.findAll();
    }

    public Optional<Post> getPostById(Integer id) {
        return repo.findById(id);
    }

    public List<Post> getAllPostByUserId(Long userId) {
        return repo.findAllPostsByUserId(userId);
    }
}
