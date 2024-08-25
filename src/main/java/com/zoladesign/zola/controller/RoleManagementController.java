package com.zoladesign.zola.controller;

import com.zoladesign.zola.entity.User;
import com.zoladesign.zola.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class RoleManagementController {

    @Autowired
    private UserService userService;

    @PostMapping("/assign-role")
    public String assignRole(@RequestParam Long userId, @RequestParam String role, HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("currentUser");

        if (currentUser == null || !currentUser.getRole().equals("ADMIN")) {
            return "redirect:/login"; // Redirect if not authorized
        }

        userService.assignRoleToUser(userId, role);
        model.addAttribute("message", "Role assigned successfully.");
        return "admin-dashboard"; // Redirect to admin dashboard or any relevant page
    }
}
