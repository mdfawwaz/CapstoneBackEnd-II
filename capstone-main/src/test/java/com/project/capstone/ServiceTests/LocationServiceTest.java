package com.project.capstone.ServiceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.capstone.business.LocationDTO;
import com.project.capstone.entity.Location;
import com.project.capstone.repository.LocationRepository;
import com.project.capstone.service.LocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

 class LocationServiceTest {

    @InjectMocks
    private LocationService locationService;

    @Mock
    private LocationRepository locationRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testGetLocationInfo() {
        String expectedLocationInfo = "Location: SomeLocationInfo";
        String locationInfo = locationService.getLocationInfo();
        assertEquals(expectedLocationInfo, locationInfo);
    }

    @Test
     void testSaveLocation() {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setAddress("123 Main St");
        locationDTO.setAptSuite("Apt 101");
        locationDTO.setCity("City");
        locationDTO.setState("State");
        locationDTO.setZip("12345");
        locationDTO.setCountry("Country");

        Location location = new Location();
        location.setLocation(locationDTO.getAddress());
        location.setSuite(locationDTO.getAptSuite());
        location.setCity(locationDTO.getCity());
        location.setState(locationDTO.getState());
        location.setZipCode(locationDTO.getZip());
        location.setCountry(locationDTO.getCountry());

        when(locationRepository.save(Mockito.any(Location.class))).thenReturn(location);

        assertTrue(locationService.saveLocation(locationDTO));
    }

    @Test
     void testSaveLocationWithError() {
        when(locationRepository.save(Mockito.any(Location.class))).thenThrow(new RuntimeException("Test exception"));

        assertFalse(locationService.saveLocation(new LocationDTO()));
    }

    @Test
     void testFindLocationById() {
        long locationId = 1L;
        Location location = new Location();
        location.setId(locationId);

        when(locationRepository.findById(locationId)).thenReturn(Optional.of(location));

        Optional<Location> foundLocation = locationService.findLocationById(locationId);
        assertTrue(foundLocation.isPresent());
        assertEquals(locationId, foundLocation.get().getId());
    }

    @Test
     void testFindAllLocations() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location());
        locations.add(new Location());

        when(locationRepository.findAll()).thenReturn(locations);

        List<Location> foundLocations = locationService.findAllLocations();
        assertEquals(locations.size(), foundLocations.size());
    }
}

