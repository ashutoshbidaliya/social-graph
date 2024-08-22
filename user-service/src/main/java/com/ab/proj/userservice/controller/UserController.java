package com.ab.proj.userservice.controller;

import com.ab.proj.userservice.model.User;
import com.ab.proj.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/user")
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
