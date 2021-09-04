package com.example.test.controllers;

import com.example.test.dto.TeamDto;
import com.example.test.entities.Task;
import com.example.test.entities.Team;
import com.example.test.repos.TeamRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller

public class TeamController {
    @Autowired
    TeamRepo teamRepo;
    @Autowired
    UserRepo userRepo;

    @PostMapping("/team")
    public void createRest(TeamDto teamDto){
        Team team = teamRepo.findById(teamDto.getId()).get();

        team.setTeam_id(teamDto.getTeam_id());
        team.setCaptain(teamDto.getCaptain());
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
        team.setCaptain(teamDto.getCaptain());
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
