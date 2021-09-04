package com.example.dnd.controllers;

import com.example.dnd.dto.TaskDto;
import com.example.dnd.entities.Task;
import com.example.dnd.repos.CriteriaRepo;
import com.example.dnd.repos.TaskRepo;
import com.example.dnd.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class TaskController {
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    CriteriaRepo criteriaRepo;

    @PostMapping("/task")
    public void createRest(TaskDto taskDto){
        Task task = taskRepo.findById(taskDto.getTeam_id()).get();

        task.setTeam_id(taskDto.getTeam_id());
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setPrice(Double.parseDouble(taskDto.getPrice()));
        task.setAssigned(userRepo.findById(taskDto.getAssigned()).get());

        taskRepo.save(task);
    }

    @PutMapping("task")
    public void updateRest(TaskDto taskDto){
        Task task = taskRepo.findById(taskDto.getTeam_id()).get();

        task.setTeam_id(taskDto.getTeam_id());
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setPrice(Double.parseDouble(taskDto.getPrice()));
        task.setAssigned(userRepo.findById(taskDto.getAssigned()).get());
        task.setCriteriaList(Arrays.stream(taskDto.getCriteriaList())
                .map((id)-> criteriaRepo.findById(Integer.parseInt(id)).get())
                .collect(Collectors.toList()));

        taskRepo.save(task);
    }

    @DeleteMapping("task")
    public void  deleteRest(TaskDto taskDto){
        Task task = taskRepo.findById(taskDto.getTeam_id()).get();

        taskRepo.delete(task);
    }
}
