package com.ab.proj.userservice.repository;

import com.ab.proj.userservice.model.Post;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PostRepository extends Neo4jRepository<Post, Long> {

}
