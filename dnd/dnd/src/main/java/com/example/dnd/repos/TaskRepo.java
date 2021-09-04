package com.example.dnd.repos;

import com.example.dnd.entities.Task;
import com.example.dnd.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {

}
