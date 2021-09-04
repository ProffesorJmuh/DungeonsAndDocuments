package com.example.dnd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tasks")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer team_id;

    private String name;
    private String description;
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private com.example.dnd.entities.User assigned;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "criteria_id")
    private List<com.example.dnd.entities.Criteria> criteriaList = new ArrayList<>();
}
