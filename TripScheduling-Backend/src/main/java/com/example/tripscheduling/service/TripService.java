package com.example.tripscheduling.service;

import com.example.tripscheduling.dto.TripDTO;
import com.example.tripscheduling.model.Trip;
import com.example.tripscheduling.repository.TripRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createTrip(TripDTO trip) {
        tripRepository.save(modelMapper.map(trip, Trip.class));
    }

    public TripDTO getTripById(Long id) {
        return modelMapper.map(tripRepository.findById(id).orElse(null), TripDTO.class);
    }

    public void updateTrip(TripDTO trip, Long id) {
        Trip trip1 = tripRepository.findById(id).orElse(null);
        trip1.setArrivalTime(trip.getArrivalTime());
        trip1.setDepartureTime(trip.getDepartureTime());
        trip1.setFromStation(trip.getFromStation());
        trip1.setToStation(trip.getToStation());
        tripRepository.save(trip1);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public void deleteAllTrips() {
        tripRepository.deleteAll();
    }

    public List<TripDTO> getAllTrips() {
        return modelMapper.map(tripRepository.findAll(), List.class);
    }
}
