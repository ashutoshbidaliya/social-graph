package com.ab.proj.userservice.controller;

import com.ab.proj.userservice.model.User;
import com.ab.proj.userservice.service.LoginService;
import com.ab.proj.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    @GetMapping("/signin")
    public User longin(@RequestParam(name = "email")String email, @RequestParam(name = "password")String password) {
        return loginService.login(email, password);
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        User createduser = userService.createUser(user.getUsername(), user.getEmail(), user.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(createduser);

    }
}
