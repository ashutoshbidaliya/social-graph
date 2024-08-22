package com.ab.proj.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Node("Post")
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String content;
    private LocalDateTime createdAt;

    @Relationship(type = "POSTED_BY", direction = Relationship.Direction.OUTGOING)
    private User user;

    @Relationship(type = "LIKED_BY", direction = Relationship.Direction.OUTGOING)
    private Set<User> likes = new HashSet<>();

    // Getters and setters
}