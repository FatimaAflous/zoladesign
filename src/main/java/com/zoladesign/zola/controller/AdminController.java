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

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

 @GetMapping("/admin")
    public String showAdminDashboard(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("currentUser");
        
        if (currentUser == null || !currentUser.getRole().equals("ADMIN")) {
            return "redirect:/login"; // Redirect to login page if not authorized
        }
 // Retrieve all users and add them to the model
 model.addAttribute("users", userService.getAllUsers());

        // Add admin-specific logic here
        return "admin-dashboard";
    }
    @PostMapping("/admin/assign-role")
    public String assignRole(@RequestParam Long userId, @RequestParam String role, Model model) {
        userService.assignRoleToUser(userId, role);
        model.addAttribute("message", "Role updated successfully.");
        return "redirect:/admin";
    }
    @PostMapping("/admin/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return "redirect:/login"; // Redirect to login page after logout
    }

}
