package com.example.test.entities;

import com.example.test.entities.Competition;
import com.example.test.entities.Criteria;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id", nullable = true)
    private Level level;

    @Column(unique = true)
    private String phone;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_cr")
    private List<Competition> competitionList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = true)
    private Team team;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_cr")
    private List<Criteria> criteriaList = new ArrayList<>();

    private String avatar;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "address_id")

//    private Address address;

//    @ManyToMany(mappedBy = "customerList", cascade = CascadeType.DETACH)
//    @ToString.Exclude
//    @JsonIgnore
}
