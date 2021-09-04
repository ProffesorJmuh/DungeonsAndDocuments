package com.example.dnd.controllers;


import com.example.dnd.dto.UserDto;
import com.example.dnd.entities.Team;
import com.example.dnd.entities.User;
import com.example.dnd.repos.TeamRepo;
import com.example.dnd.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    TeamRepo teamRepo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

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
    @DeleteMapping("login")
    public void deleteUser(UserDto userDto){
        User user = userRepo.findById(userDto.getUser_id()).get();
        userRepo.delete(user);
    }
    @PutMapping("login")
    public void updateUser(UserDto userDto){
        User user = userRepo.findById(userDto.getUser_id()).get();
        user.setUser_id(userDto.getUser_id());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhone(userDto.getPhone());
        Optional<Team> team = teamRepo.findById(userDto.getTeam_id());
        user.setTeam(team.get());
        userRepo.save(user);
    }
    @PostMapping("/login")
    public User createUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhone(userDto.getPhone());
        Optional<Team> team = teamRepo.findById(userDto.getTeam_id());
        user.setTeam(team.get());
        userRepo.save(user);

        return user;
    }
}
