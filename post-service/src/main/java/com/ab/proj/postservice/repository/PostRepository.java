package com.ab.proj.postservice.repository;

import com.ab.proj.postservice.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Integer> {

    Optional<Post> findByUserId(Long userId);
}
