package com.example.test.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "level")
@Data
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer level_id;
    private Integer levelNumber;
    private Long exp;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "level")
    List<User> users = new ArrayList<>();
}
