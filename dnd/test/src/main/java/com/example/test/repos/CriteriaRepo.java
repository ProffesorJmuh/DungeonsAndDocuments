package com.example.test.repos;


import com.example.test.dto.UserResult;
import com.example.test.entities.Criteria;
import com.example.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.Collection;
import java.util.List;

public interface CriteriaRepo extends JpaRepository<Criteria, Integer> {
    @Query(value = "SELECT u.user_id, SUM(cost) as result FROM users u join criteria c on c.user_id = u.user_id group by u.user_id order by result desc",nativeQuery = true)
    List<Tuple> getRatingUsers();
}
