package com.example.test.controllers;

import com.example.test.dto.LabelAndValueDto;
import com.example.test.dto.UserDto;
import com.example.test.entities.Team;
import com.example.test.entities.User;
import com.example.test.repos.TeamRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    @PostMapping("/login/new")
    public String createUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhone(userDto.getPhone());
//        Optional<Team> team = teamRepo.findById(userDto.getTeam_id());
//        user.setTeam(team.get());
        userRepo.save(user);
        return "redirect:/login";
    }
//    @PostMapping("login")
//    @ResponseBody
//    public void signIn(UserDto userDto){
//        if()
//    }


    @GetMapping("/getUsersByTerm")
    @ResponseBody
    public List<LabelAndValueDto> getUsersByTerm(

            @RequestParam(value = "term", required = false, defaultValue = "") String term) {
        List<User> userList = userRepo.findAll();


        List<LabelAndValueDto> suggestions = userList.stream()
                .filter(user -> user.getEmail().contains(term))
                .map(user -> new LabelAndValueDto(user.getEmail(), user.getUser_id().toString()))
                .collect(Collectors.toList());
        return suggestions;
    }

}
