package com.example.test.repos;


import com.example.test.entities.Criteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Tuple;
import java.util.List;

public interface CriteriaRepo extends JpaRepository<Criteria, Integer> {
    @Query(value = "SELECT u.user_id, SUM(cost * cat.ratio) as result " +
            "FROM users u join criteria c on c.user_id = u.user_id " +
            "join category cat on cat.category_id = c.category_id " +
            "group by u.user_id " +
            "order by result desc",
            nativeQuery = true)
    List<Tuple> getRatingUsers();

    @Query(value = "SELECT u.user_id, SUM(cost * cat.ratio) as result " +
            "FROM users u join criteria c on c.user_id = u.user_id " +
            "join category cat on cat.category_id = c.category_id " +
            "where type = :category " +
            "group by u.user_id " +
            "order by result desc",
            nativeQuery = true)
    List<Tuple> getRatingCategoryUsers(String category);

    @Query(value = "SELECT u.user_id, SUM(cost * cat.ratio) as result " +
            "FROM users u join criteria c on c.user_id = u.user_id " +
            "join category cat on cat.category_id = c.category_id " +
            "where u.team_id = :teamId " +
            "group by u.user_id " +
            "order by result desc",
            nativeQuery = true)
    List<Tuple> getTeamRatingUsers(Integer teamId);

    @Query(value = "SELECT u.user_id, SUM(cost * cat.ratio) as result " +
            "FROM users u join criteria c on c.user_id = u.user_id " +
            "join category cat on cat.category_id = c.category_id " +
            "where u.team_id = :teamId and cat.name = :category " +
            "group by u.user_id " +
            "order by result desc",
            nativeQuery = true)
    List<Tuple> getTeamRatingCategoryUsers(Integer teamId, String category);

    @Query(value = "SELECT SUM(cost * cat.ratio) as result " +
            "FROM users u join criteria c on c.user_id = u.user_id " +
            "join category cat on cat.category_id = c.category_id " +
            "where u.user_id = :user_id " +
            "group by u.user_id",
            nativeQuery = true)
    Double getUserExp(Integer user_id);
}
