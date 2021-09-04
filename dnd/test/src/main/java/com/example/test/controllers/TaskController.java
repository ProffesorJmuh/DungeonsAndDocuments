package com.example.test.controllers;


import com.example.test.dto.TaskDto;
import com.example.test.entities.Task;
import com.example.test.repos.CriteriaRepo;
import com.example.test.repos.TaskRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskRepo taskRepo;

    @GetMapping("/new")
    public String createTask(Model model){
        model.addAttribute("title", "Добавить задачу");
        return "task/new";
    }

    

    @Autowired
    UserRepo userRepo;
    @Autowired
    CriteriaRepo criteriaRepo;

    @PostMapping()
    public void createRest(TaskDto taskDto){
        Task task = new Task();

//        task.setTeam_id(taskDto.getTeam_id());
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
//        task.setPrice(Double.parseDouble(taskDto.getPrice()));
        task.setAssigned(userRepo.findById(taskDto.getAssigned()).get());

        taskRepo.save(task);
    }

    @PutMapping()
    public void updateRest(TaskDto taskDto){
        Task task = taskRepo.findById(taskDto.getId()).get();

        task.setTask_id(taskDto.getId());
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setPrice(Double.parseDouble(taskDto.getPrice()));
        task.setAssigned(userRepo.findById(taskDto.getAssigned()).get());
        task.setCriteriaList(Arrays.stream(taskDto.getCriteriaList())
                .map((id)-> criteriaRepo.findById(Integer.parseInt(id)).get())
                .collect(Collectors.toList()));

        taskRepo.save(task);
    }

    @DeleteMapping()
    public void  deleteRest(TaskDto taskDto){
        Task task = taskRepo.findById(taskDto.getId()).get();

        taskRepo.delete(task);
    }

}
