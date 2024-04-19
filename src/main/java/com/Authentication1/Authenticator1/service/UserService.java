package com.Authentication1.Authenticator1.service;

import com.Authentication1.Authenticator1.model.User;
import com.Authentication1.Authenticator1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Date;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        // Assuming password is hashed at the client or an earlier stage
        return userRepository.save(user);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent() && checkPassword(password, user.get().getPassword())) {
            User loggedInUser = user.get();
            loggedInUser.setLastLoggedIn(new Date()); // Update last logged in time
            userRepository.save(loggedInUser); // Save the updated user
            return loggedInUser;
        }
        return null;
    }

    private boolean checkPassword(String rawPassword, String storedPasswordHash) {
        // Implement password checking logic, possibly using a hashing function
        // Example: return BCryptPasswordEncoder().matches(rawPassword, storedPasswordHash);
        return rawPassword.equals(storedPasswordHash); // Simplified for demonstration
    }
}
