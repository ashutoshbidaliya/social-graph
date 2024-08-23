package com.ab.proj.userservice.repository;

import java.util.Set;


public interface UserProjection {
    //Long getId();
    String getUsername();
    String getEmail();

    Set<FriendProjection> getFriends();
}
