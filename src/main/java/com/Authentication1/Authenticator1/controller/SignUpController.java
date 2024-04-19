package com.Authentication1.Authenticator1.controller;

import com.Authentication1.Authenticator1.model.User;
import com.Authentication1.Authenticator1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUpUser(@RequestBody User newUser) {
        User savedUser = userService.saveUser(newUser);
        if (savedUser != null) {
            savedUser.setPassword(null); // Ensure password is not returned
            return ResponseEntity.ok(savedUser);
        } else {
            return ResponseEntity.badRequest().body("Error during signup");
        }
    }
}
