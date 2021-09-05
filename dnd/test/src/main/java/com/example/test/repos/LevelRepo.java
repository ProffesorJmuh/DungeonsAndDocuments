package com.example.test.repos;

import com.example.test.entities.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LevelRepo extends JpaRepository<Level, Integer> {
    @Query(value = "select l.* * from level l where l.exp < exp order by l.level_number desc limit 1", nativeQuery = true)
    Level getCurrLevel(Double exp);
    Level findByLevelNumber(Integer levelNumber);
}
