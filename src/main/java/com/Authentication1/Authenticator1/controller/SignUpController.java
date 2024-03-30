package com.Authentication1.Authenticator1.controller;

import com.Authentication1.Authenticator1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody SignUpRequest request) {
        // Call the UserService to handle sign-up logic
        boolean signUpSuccessful = userService.signUpUser(request.getUserId(), request.getPassword());

        if (signUpSuccessful) {
            return "Sign-up successful";
        } else {
            return "User already exists. Please choose a different user ID.";
        }
    }

    // Inner class for sign-up request body
    static class SignUpRequest {
        private String userId;
        private String password;

        // Getters and setters
        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}