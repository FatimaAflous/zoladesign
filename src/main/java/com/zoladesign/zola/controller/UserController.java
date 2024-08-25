package com.zoladesign.zola.controller;

import com.zoladesign.zola.entity.User;
import com.zoladesign.zola.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/users")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }
    
    @GetMapping("/")
    public String home() {
        return "home";  // Page d'accueil
    }
}