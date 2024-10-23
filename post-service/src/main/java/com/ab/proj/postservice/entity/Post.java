package com.ab.proj.postservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;


@Entity
@Table(name = "Posts", indexes = @Index(columnList = "userId"))
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postID;


    @Column(name = "userID", nullable = false)
    private Long userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "createdAt", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Like> likes;

    /*@ManyToMany
    @JoinTable(
            name = "PostTags",
            joinColumns = @JoinColumn(name = "postID"),
            inverseJoinColumns = @JoinColumn(name = "tagID")
    )
    private Set<Tag> tags;*/


}

