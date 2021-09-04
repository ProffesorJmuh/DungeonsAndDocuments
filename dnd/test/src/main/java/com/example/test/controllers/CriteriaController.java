package com.example.test.controllers;


import com.example.test.dto.CriteriaDto;
import com.example.test.entities.Criteria;
import com.example.test.repos.CriteriaRepo;
import com.example.test.repos.TaskRepo;
import com.example.test.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class CriteriaController {
    @Autowired
    CriteriaRepo criteriaRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    UserRepo userRepo;

    @PostMapping("/criteria")
    public void createRest(CriteriaDto criteriaDto){
        Criteria criteria = new Criteria();

//        criteria.setCriteria_id(criteriaDto.getCriteria_id());
        criteria.setTask(taskRepo.findById(criteriaDto.getTask()).get());
        criteria.setType(criteriaDto.getType());
        criteria.setUser(userRepo.findById(criteriaDto.getUser()).get());

        criteriaRepo.save(criteria);
    }

    @PutMapping("criteria")
    public void updateRest(CriteriaDto criteriaDto){
        Criteria criteria = criteriaRepo.findById(criteriaDto.getId()).get();

        criteria.setCriteria_id(criteriaDto.getCriteria_id());
        criteria.setTask(taskRepo.findById(criteriaDto.getTask()).get());
        criteria.setType(criteriaDto.getType());
        criteria.setUser(userRepo.findById(criteriaDto.getUser()).get());

        criteriaRepo.save(criteria);
    }

    @DeleteMapping ("criteria")
    public void deleteRest(CriteriaDto criteriaDto){
        Criteria criteria = criteriaRepo.findById(criteriaDto.getId()).get();

        criteriaRepo.delete(criteria);
    }

}
