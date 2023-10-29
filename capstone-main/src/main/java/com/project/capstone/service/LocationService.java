package com.project.capstone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capstone.business.LocationDTO;
import com.project.capstone.entity.Location;
import com.project.capstone.repository.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public String getLocationInfo() {
        return "Location: SomeLocationInfo";
    }

    public Boolean saveLocation(LocationDTO locationDTO) {
        try {
            Location location = new Location();
            location.setLocation(locationDTO.getAddress());
            location.setSuite(locationDTO.getAptSuite());
            location.setCity(locationDTO.getCity());
            location.setState(locationDTO.getState());
            location.setZipCode(locationDTO.getZip());
            location.setCountry(locationDTO.getCountry());
            locationRepository.save(location);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Optional<Location> findLocationById(long id) {
        return locationRepository.findById(id);
    }

    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }
}
