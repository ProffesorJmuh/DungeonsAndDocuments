package com.example.test.controllers;

import com.example.test.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskRepo taskRepo;

    @GetMapping("/new")
    public String createTask(Model model){
        model.addAttribute("title", "Новый мотстр появился");
        return "task/new";
    }

    
}
