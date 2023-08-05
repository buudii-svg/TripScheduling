package com.example.tripscheduling.dto;

import com.example.tripscheduling.model.Trip;
import lombok.Data;

import java.util.Set;

@Data
public class StationDTO {
    private Long id;
    private String name;
    private Set<Trip> trips;

}

