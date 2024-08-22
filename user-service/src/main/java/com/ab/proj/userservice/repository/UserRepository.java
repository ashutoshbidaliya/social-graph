package com.ab.proj.userservice.repository;

import com.ab.proj.userservice.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
