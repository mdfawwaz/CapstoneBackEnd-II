package com.project.capstone.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.capstone.entity.Location;
import com.project.capstone.repository.LocationRepository;
import com.project.capstone.service.LocationService;

@ExtendWith(MockitoExtension.class)
 class LocationRepositoryTest {

    @InjectMocks
    private LocationService locationService;

    @Mock
    private LocationRepository locationRepository;

    @Test
     void testFindLocationById() {
      
        Location sampleLocation = new Location();
        sampleLocation.setId(1L);
        sampleLocation.setState("Sample Location");

       
        when(locationRepository.findById(1L)).thenReturn(Optional.of(sampleLocation));

     
        Optional<Location> result = locationService.findLocationById(1L);

    
        verify(locationRepository, times(1)).findById(1L);
        assertEquals("Sample Location", result.get().getState());
    }

    @Test
 void testFindAllLocations() {
    List<Location> sampleLocations = new ArrayList<>();
    
    Location location1 = new Location();
    location1.setId(1L);
    location1.setState("Location 1");
    
    Location location2 = new Location();
    location2.setId(2L);
    location2.setState("Location 2");
    
    sampleLocations.add(location1);
    sampleLocations.add(location2);

    when(locationRepository.findAll()).thenReturn(sampleLocations);

    List<Location> result = locationService.findAllLocations();


    verify(locationRepository, times(1)).findAll();
    assertEquals(2, result.size());
}
}