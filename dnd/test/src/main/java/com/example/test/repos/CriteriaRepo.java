package com.example.test.repos;

import com.example.test.entities.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriteriaRepo extends JpaRepository<Criteria, Integer> {
}
