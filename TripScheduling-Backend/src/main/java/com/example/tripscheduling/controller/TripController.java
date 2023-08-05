package com.example.tripscheduling.controller;

import com.example.tripscheduling.dto.TripDTO;
import com.example.tripscheduling.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
@CrossOrigin( allowedHeaders="*",origins="*")
public class TripController {
    @Autowired
    private TripService tripService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createTrip(@RequestBody TripDTO trip) {
        tripService.createTrip(trip);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TripDTO> getTrip(@PathVariable Long id) {
        return ResponseEntity.ok(tripService.getTripById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateTrip(@RequestBody TripDTO trip, @PathVariable Long id) {
        tripService.updateTrip(trip, id);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTrip(@PathVariable Long id) {
        tripService.deleteTrip(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("")
    public ResponseEntity<List<TripDTO>> getAllTrips() {
        return ResponseEntity.ok(tripService.getAllTrips());
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<HttpStatus> deleteAllTrips() {
        tripService.deleteAllTrips();
        return ResponseEntity.ok().body(null);
    }

}
