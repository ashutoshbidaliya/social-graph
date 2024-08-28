package com.ab.proj.postservice.repository;

import com.ab.proj.postservice.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {



    @Query("SELECT l FROM Like l WHERE l.post.id = :postId")
    List<Like> findAllLikesByPostId(@Param("postId") Integer postId);
}
