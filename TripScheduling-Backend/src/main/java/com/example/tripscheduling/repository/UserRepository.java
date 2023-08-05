package com.example.tripscheduling.repository;

import com.example.tripscheduling.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User,Long> {
    @Query("SELECT u from User u WHERE u.username = :name")
    User findByUsername(@Param("name") String name);
}