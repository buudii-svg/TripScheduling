package com.example.tripscheduling.controller;

import com.example.tripscheduling.dto.StationDTO;
import com.example.tripscheduling.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("/stations")
@CrossOrigin( allowedHeaders="*",origins="*")

public class StationController {
    @Autowired
    private StationService stationService;

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createStation(@RequestBody StationDTO station){
        stationService.createStation(station);
        return ResponseEntity.status(CREATED).body(null);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<StationDTO> getStation(@PathVariable Long id){
        return ResponseEntity.ok(stationService.getStation(id));
    }

@PutMapping("/update/{id}")
    public ResponseEntity<HttpStatus> updateStation(@RequestBody StationDTO station, @PathVariable Long id){
        stationService.updateStation(station,id);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteStation(@PathVariable Long id){
        stationService.deleteStation(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("")
    public ResponseEntity<List<StationDTO>> getAllStations(){
        return ResponseEntity.ok(stationService.getAllStations());
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<HttpStatus> deleteAllStations(){
        stationService.deleteAllStations();
        return ResponseEntity.ok().body(null);
    }

}
