package com.example.test.controllers;


import com.example.test.dto.CriteriaDto;
import com.example.test.entities.Criteria;
import com.example.test.repos.CriteriaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class CriteriaController {
    @Autowired
    CriteriaRepo criteriaRepo;

    @PostMapping("/criteria")
    public void createRest(CriteriaDto criteriaDto){
        Criteria criteria = criteriaRepo.findById(criteriaDto.getId()).get();

        criteria.setCriteria_id(criteriaDto.getCriteria_id());
        criteria.setTask(criteriaDto.getTask());
        criteria.setType(criteriaDto.getType());
        criteria.setUser(criteriaDto.getUser());

        criteriaRepo.save(criteria);
    }

    @PutMapping("criteria")
    public void updateRest(CriteriaDto criteriaDto){
        Criteria criteria = criteriaRepo.findById(criteriaDto.getId()).get();

        criteria.setCriteria_id(criteriaDto.getCriteria_id());
        criteria.setTask(criteriaDto.getTask());
        criteria.setType(criteriaDto.getType());
        criteria.setUser(criteriaDto.getUser());

        criteriaRepo.save(criteria);
    }

    @DeleteMapping ("criteria")
    public void deleteRest(CriteriaDto criteriaDto){
        Criteria criteria = criteriaRepo.findById(criteriaDto.getId()).get();

        criteriaRepo.delete(criteria);
    }

}
