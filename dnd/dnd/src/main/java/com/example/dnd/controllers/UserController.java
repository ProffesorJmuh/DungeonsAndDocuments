package com.example.dnd.controllers;


import com.example.dnd.entities.User;
import com.example.dnd.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("title", "login");
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage(HttpServletRequest request, Model model) {
        model.addAttribute("title", "login success");

        return "success";
    }
    @GetMapping("/user/{user_id}")
    public String getUserPage(Model model,
                              @PathVariable("user_id") Integer user_id) {
        model.addAttribute("title", "login success");
        model.addAttribute("user", user_id);
        return "success";
    }
    @PostMapping("/login")
    public User createRest(User user) {
        userRepo.save(user);

        return user;
    }
}
