package com.example.test.controllers;

import com.example.test.repos.CriteriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    CriteriaRepo criteriaRepo;

    @GetMapping
    public String mainRating(Model model){
        model.addAttribute("title", "Рейтинг");
        model.addAttribute("userList", criteriaRepo.getRatingUsers());

        return "rating/rating";
    }

}
