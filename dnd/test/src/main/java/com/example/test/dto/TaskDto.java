package com.example.test.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Integer id;
    private Integer team_id;
    private String name;
    private String description;
    private String price;
    private Integer assigned;
    private String[] criteriaList;
}

