package com.example.dnd.repos;

import com.example.dnd.entities.Criteria;
import com.example.dnd.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriteriaRepo extends JpaRepository<Criteria, Integer> {
}
