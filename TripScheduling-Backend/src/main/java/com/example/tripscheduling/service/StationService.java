package com.example.tripscheduling.service;

import com.example.tripscheduling.dto.StationDTO;
import com.example.tripscheduling.model.Station;
import com.example.tripscheduling.repository.StationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createStation(StationDTO station){
        stationRepository.save(modelMapper.map(station, Station.class));
    }

    public StationDTO getStation(Long id){
        return modelMapper.map(stationRepository.findById(id).orElse(null), StationDTO.class);
    }

    public void updateStation(StationDTO station,Long id){
        Station station1 = stationRepository.findById(id).orElse(null);
        station1.setName(station.getName());
        stationRepository.save(station1);
    }

    public void deleteStation(Long id){
        stationRepository.deleteById(id);
    }

    public List<StationDTO> getAllStations(){
        return modelMapper.map(stationRepository.findAll(), List.class);
    }

    public void deleteAllStations(){
        stationRepository.deleteAll();
    }


}

