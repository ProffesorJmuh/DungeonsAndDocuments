package com.example.test.dto;

import com.example.test.entities.Task;
import com.example.test.entities.User;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class CriteriaDto {
    private Integer id;
    private Integer criteria_id;
    private String type;
    private Task task;
    private User user;
}
