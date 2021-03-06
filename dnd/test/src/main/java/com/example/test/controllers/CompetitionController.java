package com.example.test.controllers;

import com.example.test.dto.CompetitionDto;
import com.example.test.entities.Competition;
import com.example.test.entities.Task;
import com.example.test.repos.CompetitionRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class CompetitionController {
    @Autowired
    CompetitionRepo competitionRepo;
    @Autowired
    UserRepo userRepo;

    @PostMapping("/competition")
    public void createRest(CompetitionDto  competitionDto){
        Competition competition = new Competition();
//        competition.setCompetition_id(competitionDto.getCompetition_id());
        competition.setName(competitionDto.getName());
        competition.setUser_cr(userRepo.findById(competitionDto.getUser()).get());

        competitionRepo.save(competition);
    }

    @PutMapping("competition")
    public void updateRest(CompetitionDto  competitionDto){
        Competition competition = competitionRepo.findById(competitionDto.getId()).get();
        competition.setCompetition_id(competitionDto.getCompetition_id());
        competition.setName(competitionDto.getName());
        competition.setUser_cr(userRepo.findById(competitionDto.getUser()).get());

        competitionRepo.save(competition);
    }

    @DeleteMapping("competition")
    public void deleteRest(CompetitionDto  competitionDto){
        Competition competition = competitionRepo.findById(competitionDto.getId()).get();

        competitionRepo.delete(competition);
    }
}
