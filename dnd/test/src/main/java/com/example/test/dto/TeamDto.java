package com.example.test.dto;
import com.example.test.entities.User;
import lombok.Data;

@Data
public class TeamDto {
    private  Integer id;
    private Integer team_id;
    private String name;
    private String icon;
    private String[] users;
    private User captain;
}
