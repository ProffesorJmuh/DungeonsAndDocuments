package com.example.test.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer category_id;
    private String name;
    private double ratio;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    private List<Criteria> criteriaListList = new ArrayList<>();
}
