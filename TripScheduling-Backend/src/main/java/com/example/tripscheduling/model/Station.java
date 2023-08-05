package com.example.tripscheduling.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "station")
public class Station {

    @ManyToMany
    @JoinTable(
            name="StationXTrip",
            joinColumns= @JoinColumn(name="StationId"),
            inverseJoinColumns= @JoinColumn(name="TripId"))
    @Getter(AccessLevel.NONE)
    private Set <Trip> trips;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
}
