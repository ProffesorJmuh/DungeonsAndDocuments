package com.example.test.repos;

import com.example.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


    User findByEmail(String email);
}
