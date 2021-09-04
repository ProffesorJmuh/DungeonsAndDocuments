package com.example.test.repos;

import com.example.test.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepo extends JpaRepository<Team, Integer> {

}
