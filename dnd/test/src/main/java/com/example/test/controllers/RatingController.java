package com.example.test.controllers;

import com.example.test.dto.UserResult;
import com.example.test.repos.CriteriaRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Tuple;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    CriteriaRepo criteriaRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping
    public String mainRating(Model model){
        model.addAttribute("title", "Рейтинг");
        List<UserResult> rating = criteriaRepo.getRatingUsers().stream()
                .map(tuple -> new UserResult(userRepo.findById(Integer.parseInt(tuple.get("user_id").toString())).get(), tuple.get("result").toString()))
                .collect(Collectors.toList());
                ;

        System.out.println(rating.getClass());
        model.addAttribute("userList", rating);

        return "rating/rating";
    }

}
