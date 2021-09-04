package com.example.test.controllers;

import com.example.test.dto.UserResult;
import com.example.test.entities.Category;
import com.example.test.repos.CategoryRepo;
import com.example.test.repos.CriteriaRepo;
import com.example.test.repos.TeamRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    CriteriaRepo criteriaRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    TeamRepo teamRepo;
    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping
    public String mainRating(Model model, @RequestParam(name = "category", required = false) String category,
                             @RequestParam(name = "team_id", required = false) Integer team_id){
        model.addAttribute("title", "Рейтинг");


        List<Tuple> resList = new ArrayList<>();
        if(category != null && !category.isEmpty()){
            model.addAttribute("category", category);
            if (team_id != null){
                model.addAttribute("team_id", team_id);
                model.addAttribute("team_name", teamRepo.findById(team_id).get().getName());

                resList = criteriaRepo.getTeamRatingCategoryUsers(team_id, category);
            }else {
                resList = criteriaRepo.getRatingCategoryUsers(category);
            }
        }else if (team_id != null){
            model.addAttribute("team_id", team_id);
            model.addAttribute("team_name", team_id);
            resList = criteriaRepo.getTeamRatingUsers(team_id);
        }else{
            resList = criteriaRepo.getRatingUsers();
        }

        List<UserResult> rating = resList.stream()
                .map(tuple -> new UserResult(userRepo.findById(Integer.parseInt(tuple.get("user_id").toString())).get(), tuple.get("result").toString()))
                .collect(Collectors.toList());
                ;

        System.out.println(rating.getClass());
        model.addAttribute("userList", rating);

        return "rating/rating";
    }

}
