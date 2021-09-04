package com.example.test.dto;

import com.example.test.entities.User;
import lombok.Data;

@Data
public class CompetitionDto {
    private Integer id;
    private Integer competition_id;
    private String name;
    private User user;
}
