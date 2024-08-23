package com.ab.proj.userservice.controller;

import com.ab.proj.userservice.model.User;
import com.ab.proj.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    /*@GetMapping
    public ResponseEntity<UserDto> getUser(@RequestParam(name = "user")  String userName) {
        UserDto userDto = userService.getUserByName(userName);


        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }*/

    @GetMapping
    public List<User> getFirstLevelFriendsByUsername(@RequestParam(name = "user")  String userName) {
        return userService.getFirstLevelFriendsByUsername(userName);
    }


    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser =  userService.createUser(user.getUsername(), user.getEmail());
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PostMapping("/friend")
    public void addFriend(@RequestParam(name = "userId") Long userId,
                          @RequestParam (name="friendId")Long friendId) {
        userService.addFriend(userId, friendId);
    }
}
