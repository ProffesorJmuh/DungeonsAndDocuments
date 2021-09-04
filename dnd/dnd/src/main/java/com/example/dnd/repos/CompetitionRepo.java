package com.example.dnd.repos;

import com.example.dnd.entities.Competition;
import com.example.dnd.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepo extends JpaRepository<Competition, Integer> {//extends JpaRepository<Competition, Long> {
}
