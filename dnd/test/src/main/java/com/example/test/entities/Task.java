package com.example.test.entities;

import com.example.test.entities.Criteria;
import com.example.test.entities.User;
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
    private Integer task_id;

    private String name;
    private String description;
    private double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User assigned;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "task")
    private List<Criteria> criteriaList = new ArrayList<>();
}
