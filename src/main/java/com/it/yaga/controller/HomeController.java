package com.it.yaga.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String homePage(Model model, Principal principal) {
        // Kiểm tra nếu đã login, hiển thị username
        if (principal != null) {
            model.addAttribute("username", principal.getName());
        }
        return "home";
    }
}