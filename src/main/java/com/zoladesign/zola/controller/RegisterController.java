package com.zoladesign.zola.controller;

import com.zoladesign.zola.entity.User;
import com.zoladesign.zola.service.UserService;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";  // Display the registration form
    }

   @PostMapping("/register")
public String register(@RequestParam String username, @RequestParam String password, Model model) {
    User existingUser = userService.findByUsername(username);

    if (existingUser != null) {
        model.addAttribute("errorMessage", "Username already taken.");
        return "register";
    }

    // Create a new user with the default role "CLIENT"
    User newUser = new User();
    
    newUser.setUsername(username);
    newUser.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
    newUser.setRole("CLIENT");  // Default role

    userService.saveUser(newUser);

    model.addAttribute("successMessage", "Registration successful! You can now login.");
    return "register";
}

}
