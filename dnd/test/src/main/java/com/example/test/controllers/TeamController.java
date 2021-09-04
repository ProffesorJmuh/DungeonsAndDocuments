package com.example.test.controllers;

import com.example.test.dto.TeamDto;
import com.example.test.entities.Task;
import com.example.test.entities.Team;
import com.example.test.repos.TeamRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    TeamRepo teamRepo;
    @Autowired
    UserRepo userRepo;

    @GetMapping("{team_id}")
    public void showTeam(@PathVariable("team_id") Integer teamId, Model model){
        Team team = teamRepo.findById(teamId).get();

        model.addAttribute("title", team.getName());
        model.addAttribute("team", team);

    }
    @PostMapping("/team")
    public void createRest(TeamDto teamDto){
        Team team = new Team();

        team.setCaptain(userRepo.findById(teamDto.getId()).get());
        team.setName(teamDto.getName());
        team.setIcon(teamDto.getIcon());
        team.setUsers(Arrays.stream(teamDto.getUsers())
                .map((id)-> userRepo.findById(Integer.parseInt(id)).get())
                .collect(Collectors.toList()));

        teamRepo.save(team);
    }

    @PutMapping("team")
    public void updateRest(TeamDto teamDto){
        Team team = teamRepo.findById(teamDto.getId()).get();

        team.setTeam_id(teamDto.getTeam_id());
        team.setCaptain(userRepo.findById(teamDto.getId()).get());
        team.setName(teamDto.getName());
        team.setIcon(teamDto.getIcon());
        team.setUsers(Arrays.stream(teamDto.getUsers())
                .map((id)-> userRepo.findById(Integer.parseInt(id)).get())
                .collect(Collectors.toList()));

        teamRepo.save(team);
    }

    @DeleteMapping("team")
    public void deleteRest(TeamDto teamDto){
        Team team = teamRepo.findById(teamDto.getId()).get();

        teamRepo.delete(team);
    }
}
