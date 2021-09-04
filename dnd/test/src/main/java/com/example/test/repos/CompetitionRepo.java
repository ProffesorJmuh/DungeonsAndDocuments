package com.example.test.repos;

import com.example.test.entities.Competition;
import com.example.test.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepo extends JpaRepository<Competition, Integer> {//extends JpaRepository<Competition, Long> {
}
