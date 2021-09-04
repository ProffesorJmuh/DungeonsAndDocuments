package com.example.dnd.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Integer team_id;
    private String name;
    private String description;
    private String price;
    private String assigned;
    private String[] criteriaList;
}

