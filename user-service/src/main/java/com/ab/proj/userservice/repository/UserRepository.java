package com.ab.proj.userservice.repository;

import com.ab.proj.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User>  findByEmail(String email);

    @Query("MATCH (u:User)-[:FRIENDS_WITH]->(f:User) WHERE u.username = $username RETURN f")
    List<User> findFirstLevelFriendsByUsername(String username);

    List<User> findAllByEmail(String email);
}

