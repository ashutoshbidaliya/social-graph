package com.ab.proj.postservice.repository;

import com.ab.proj.postservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
