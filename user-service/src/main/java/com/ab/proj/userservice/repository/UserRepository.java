package com.ab.proj.userservice.repository;

import com.ab.proj.userservice.dto.UserDto;
import com.ab.proj.userservice.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {

    Optional<User> findByUsername(String username);

    //@Query("MATCH (u:User {username: $username})-[:FRIENDS_WITH*1]-(f:User) RETURN u AS user, collect(f) AS friends")
    //@Query("MATCH (u:User)-[:FRIENDS_WITH]->(f:User) WHERE u.username = $username RETURN u, collect(f) AS friends")

    @Query("MATCH (u:User)-[:FRIENDS_WITH]->(f:User) " +
            "WHERE u.username = $username " +
            "RETURN u.username AS username, u.email AS email, " +
            "collect(f.username) AS friendUsernames, collect(f.email) AS friendEmails")
    List<UserDto> findUserWithFriendsByUserName(String username);

    @Query("MATCH (u:User {id: $userId})-[:FRIENDS_WITH*1]-(f:User) RETURN u AS user, collect(f) AS friends")
    UserProjection findUserWithFriendsByUserId(Long userId);

    @Query("MATCH (u:User)-[:FRIENDS_WITH]->(f:User) WHERE u.username = $username RETURN f")
    List<User> findFirstLevelFriendsByUsername(String username);

}

