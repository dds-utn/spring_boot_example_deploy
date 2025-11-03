package com.example.basespringboot.controller;

import com.example.basespringboot.entity.User;
import com.example.basespringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public String home(Model model) {
        User user = userService.createRandomUser();
        model.addAttribute("user", user);
        return "welcome";
    }
}
