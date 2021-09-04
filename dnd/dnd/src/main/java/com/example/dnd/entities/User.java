package com.example.dnd.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String position;
    private int lvl;

    @Column(unique = true)
    private String phone;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id")
    private List<Competition> competitionList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "criteria_id")
    private List<Criteria> criteriaList = new ArrayList<>();
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id")

//    private Address address;

//    @ManyToMany(mappedBy = "customerList", cascade = CascadeType.DETACH)
//    @ToString.Exclude
//    @JsonIgnore
}
