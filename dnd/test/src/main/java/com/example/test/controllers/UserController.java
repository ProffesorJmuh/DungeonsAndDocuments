package com.example.test.controllers;


import com.example.test.dto.UserDto;
import com.example.test.entities.Level;
import com.example.test.entities.Team;
import com.example.test.entities.User;
import com.example.test.repos.CriteriaRepo;
import com.example.test.repos.LevelRepo;
import com.example.test.repos.TeamRepo;
import com.example.test.repos.UserRepo;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    TeamRepo teamRepo;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    LevelRepo levelRepo;
    @Autowired
    CriteriaRepo criteriaRepo;


    @GetMapping()
    public String userCard(@Autowired Authentication authentication, Model model){
        model.addAttribute("title", "Карточка Игрока");
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        String email = userDetails.getUsername();
        User user = userRepo.findByEmail(email);
        if(user.getAvatar() == null || user.getAvatar().isEmpty()){
            return "redirect:/user/chooseAvatar";
        }
        model.addAttribute("user", user);
        model.addAttribute("addMax", levelRepo.findByLevelNumber(user.getLevel().getLevelNumber() + 1).getExp());

        Double userExp = criteriaRepo.getUserExp(user.getUser_id());
        model.addAttribute("currEx", userExp!=null?userExp.intValue():0);

        return "user/user";
    }
    @GetMapping("/{user_id}")
    public String getUserPage(Model model,
                              @PathVariable("user_id") Integer user_id) {
        User user = userRepo.findById(user_id).get();
        model.addAttribute("title", "Карточка игрока");
        model.addAttribute("user", user);
        return "user";
    }
    @DeleteMapping("login")
    @ResponseBody
    public void deleteUser(UserDto userDto){
        User user = userRepo.findById(userDto.getUser_id()).get();
        userRepo.delete(user);
    }
    @PutMapping("login")
    @ResponseBody
    public void updateUser(UserDto userDto){
        User user = userRepo.findById(userDto.getUser_id()).get();
        user.setUser_id(userDto.getUser_id());
        user.setEmail(userDto.getEmail());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPhone(userDto.getPhone());
        Optional<Team> team = teamRepo.findById(userDto.getTeam_id());
//        user.setTeam(team.get());
        userRepo.save(user);
    }


    @GetMapping("chooseAvatar")
    public String chooseAvatar(Model model){
        model.addAttribute("title", "Выберете свой аватар");
        return "user/chooseAvatar";
    }

    @PostMapping("chooseAvatar")
    public String chooseAvatar(@Autowired Authentication authentication, String avatar){
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        String email = userDetails.getUsername();
        User user = userRepo.findByEmail(email);

        user.setAvatar(avatar);
        userRepo.save(user);
        return "redirect:/";
    }
}
