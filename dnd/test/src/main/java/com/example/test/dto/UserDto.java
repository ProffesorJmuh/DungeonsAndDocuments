package com.example.test.dto;


import lombok.Data;

@Data
public class UserDto {
    private Integer user_id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String position;
    private int lvl;

    private String phone;


    private Integer team_id;

    private String[] criteriaIdList;
}
