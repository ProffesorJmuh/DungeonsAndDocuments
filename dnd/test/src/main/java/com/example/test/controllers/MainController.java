package com.example.test.controllers;

import com.example.test.repos.TeamRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @Autowired
    TeamRepo teamRepo;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("title", "login");
        return "login";
    }

    @GetMapping("/login/new")
    public String signUp(Model model){
        model.addAttribute("title", "registration");
        return "reg";
    }

//    @PostMapping("login")
//    @ResponseBody
//    public void signIn(UserDto userDto){
//        if()
//    }
}
