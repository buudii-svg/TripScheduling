package com.example.tripscheduling.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "trip")
public class Trip {

    @ManyToMany(mappedBy="trips",fetch=FetchType.EAGER)
    private Set<Station> stations;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne(cascade= CascadeType.MERGE)
    private Station fromStation;
    @OneToOne(cascade= CascadeType.MERGE)
    private Station toStation;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

}
