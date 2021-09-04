package com.example.dnd.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "criteria")
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer criteria_id;

    private String type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private com.example.dnd.entities.User user;
}
