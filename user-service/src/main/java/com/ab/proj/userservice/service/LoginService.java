package com.ab.proj.userservice.service;

import com.ab.proj.userservice.model.User;
import com.ab.proj.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User login(String email, String password) {
        User user = userRepo.findByEmail(email);
        if(user != null) {
            return passwordEncoder.matches(password, user.getPassword()) ? user : null;
        }
        return null;
    }
}
