package com.ab.proj.postservice.service;

import com.ab.proj.postservice.entity.Comment;
import com.ab.proj.postservice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repo;

    public Comment saveComment(Comment comment) {
            return repo.save(comment);
    }

    public void deleteComment(Integer id) {
        repo.deleteById(id);
    }

    public List<Comment> getAllComments() {
         return repo.findAll();
    }

    public Comment findByPostId(Integer id) {
        return repo.findById(id).orElseThrow();

    }

    public List<Comment> findAllCommentsByIds(List<Integer> ids) {
        return repo.findAllById(ids);
    }
}
