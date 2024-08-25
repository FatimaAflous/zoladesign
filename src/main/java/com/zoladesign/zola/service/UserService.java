package com.zoladesign.zola.service;

import com.zoladesign.zola.entity.User;
import com.zoladesign.zola.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        logger.info("Fetched Users: {}", users);  // Log fetched users
        return users;
    }

    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            logger.info("User found: {}", username);
        } else {
            logger.warn("User not found: {}", username);
        }
        return user;
    }

    public User validateUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            logger.info("User found: {}", username);
            if (BCrypt.checkpw(password, user.getPassword())) {
                logger.info("Password match for user: {}", username);
                return user;
            } else {
                logger.warn("Password mismatch for user: {}", username);
            }
        } else {
            logger.warn("User not found: {}", username);
        }
        return null;
    }

    public void saveUser(User user) {
        // Hash the password before saving
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        logger.info("Saving user: {}", user.getUsername());
        userRepository.save(user);
    }

    public void assignRoleToUser(Long userId, String role) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setRole(role);
        logger.info("Assigning role {} to user {}", role, userId);
        userRepository.save(user);
    }
}
