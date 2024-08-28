package com.ab.proj.postservice.service;

import com.ab.proj.postservice.entity.Like;
import com.ab.proj.postservice.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository repo;

    public Like saveLike(Like like) {
        return repo.save(like);
    }

    public void deleteLike(Integer id) {
        repo.deleteById(id);
    }

    public List<Like> getAllLikesForPost(Integer postId) {
        return repo.findAllLikesByPostId(postId);
    }

}
