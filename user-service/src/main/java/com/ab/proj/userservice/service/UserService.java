package com.ab.proj.userservice.service;

import com.ab.proj.userservice.dto.FriendDto;
import com.ab.proj.userservice.dto.UserDto;
import com.ab.proj.userservice.model.User;
import com.ab.proj.userservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    public List<User> getFirstLevelFriendsByUsername(String username) {
        return repository.findFirstLevelFriendsByUsername(username);
    }

    @Transactional
    public UserDto getUserByName(String userName) {
        List<UserDto> results = repository.findUserWithFriendsByUserName(userName);

        if (results.isEmpty()) {
            return null;
        }
        UserDto userDto = results.get(0);
        //Set<FriendDto> friends = new HashSet<>();

        Set<FriendDto> friends = userDto.getFriends().stream()
                .filter(Objects::nonNull)
                .map(friend -> {
                    return FriendDto.builder()
                            //.id(friend.getId())
                            .username(friend.getUsername())
                            .email(friend.getEmail()).build();
                }).collect(Collectors.toSet());


        userDto.setFriends(friends);
        return userDto;


    }

    public User createUser(String userName, String email) {
        User user = new User();
        user.setUsername(userName);
        user.setEmail(email);
        //user.setFriends();
        return repository.save(user);
    }

    @Transactional
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
