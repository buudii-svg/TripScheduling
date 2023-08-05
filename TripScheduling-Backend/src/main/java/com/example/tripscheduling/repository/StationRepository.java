package com.example.tripscheduling.repository;

import com.example.tripscheduling.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station,Long> {
}
