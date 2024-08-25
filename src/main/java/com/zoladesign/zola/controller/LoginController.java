package com.zoladesign.zola.controller;

import com.zoladesign.zola.entity.User;
import com.zoladesign.zola.service.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.mindrot.jbcrypt.BCrypt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        logger.info("Displaying login form.");
        return "login";  // Display the login form
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        logger.info("Attempting to login user: {}", username);
        User user = userService.findByUsername(username);

        if (user != null) {
            logger.info("User found: {}", username);
            // Use BCrypt to check the password
            if (BCrypt.checkpw(password, user.getPassword())) {
                logger.info("Login successful for user: {}", username);
                session.setAttribute("currentUser", user); // Set the user in the session
                model.addAttribute("message", "Welcome " + user.getUsername() + "!");
                return "welcome";  // A simple welcome page
            } else {
                logger.warn("Password mismatch for user: {}", username);
            }
        } else {
            logger.warn("User not found: {}", username);
        }

        model.addAttribute("errorMessage", "Invalid username or password.");
        return "login";  // Stay on the login page with an error message
    }
}
