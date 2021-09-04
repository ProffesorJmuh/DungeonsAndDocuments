package com.example.test.dto;

import com.example.test.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserResult {
    User user;
    String result;
}
