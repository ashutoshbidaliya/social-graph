package com.ab.proj.userservice.service;

import com.ab.proj.userservice.model.User;
import com.ab.proj.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User getUserById(Long userId) {
        return repository.findById(userId).orElseThrow();
    }

    public User createUser(String userName, String email) {
        User user = new User();
        user.setUsername(userName);
        user.setEmail(email);
        //user.setFriends();
        return repository.save(user);
    }

    public void addFriend(Long userId, Long friendId) {
        User user = repository.findById(userId).orElseThrow();
        User friend = repository.findById(friendId).orElseThrow();

        //Update friend list for both user and friend
        user.getFriends().add(friend);
        friend.getFriends().add(user);

        repository.save(user);
        repository.save(friend);
    }
}
