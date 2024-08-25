package com.zoladesign.zola.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // Invalidate the session to log out the user
        return "redirect:/login"; // Redirect to the login page after logout
    }
}
