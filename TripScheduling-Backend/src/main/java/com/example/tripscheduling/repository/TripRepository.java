package com.example.tripscheduling.repository;

import com.example.tripscheduling.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
