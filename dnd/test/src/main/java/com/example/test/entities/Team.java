package com.example.test.entities;

import com.example.test.entities.User;
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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "team", nullable = true)
    private List<User> users = new ArrayList<>();


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "captain_id", referencedColumnName = "user_id")
    private User captain;

}
