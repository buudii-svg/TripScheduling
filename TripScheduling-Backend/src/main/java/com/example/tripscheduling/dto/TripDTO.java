package com.example.tripscheduling.dto;

import com.example.tripscheduling.model.Station;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class TripDTO {
    private Long id;
    private Station fromStation;
    private Station toStation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private Set<Station> stations;

}
