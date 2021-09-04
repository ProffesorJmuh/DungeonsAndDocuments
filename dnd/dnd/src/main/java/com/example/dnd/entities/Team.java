package com.example.dnd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer team_id;

    private String name;

    private String icon;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<com.example.dnd.entities.User> users = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "captain_id", referencedColumnName = "user_id")
    private com.example.dnd.entities.User captain;

}
