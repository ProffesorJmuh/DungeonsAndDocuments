package com.example.dnd.repos;

import com.example.dnd.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {


    User findByEmail(String email);
}
