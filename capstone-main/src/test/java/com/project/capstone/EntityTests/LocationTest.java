package com.project.capstone.EntityTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.capstone.entity.Location;

 class LocationTest {

    @Mock
    private Location location;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testLocationProperties() {
        String loc = "123 Main St";
        String suite = "Suite 456";
        String city = "Sample City";
        String state = "CA";
        String zipCode = "12345";
        String country = "US";

        Mockito.when(location.getLocation()).thenReturn(loc);
        Mockito.when(location.getSuite()).thenReturn(suite);
        Mockito.when(location.getCity()).thenReturn(city);
        Mockito.when(location.getState()).thenReturn(state);
        Mockito.when(location.getZipCode()).thenReturn(zipCode);
        Mockito.when(location.getCountry()).thenReturn(country);

        assertEquals(loc, location.getLocation());
        assertEquals(suite, location.getSuite());
        assertEquals(city, location.getCity());
        assertEquals(state, location.getState());
        assertEquals(zipCode, location.getZipCode());
        assertEquals(country, location.getCountry());
    }

    @Test
     void testId() {
        Long id = 1L;

        Mockito.when(location.getId()).thenReturn(id);

        assertEquals(id, location.getId());
    }

    @Test
     void testGetId() {
        assertEquals(0L, location.getId());
    }

    @Test
     void testGetLocation() {
        assertEquals(null, location.getLocation());
    }

    @Test
     void testGetSuite() {
        assertEquals(null, location.getSuite());
    }

    @Test
     void testGetCity() {
        assertEquals(null, location.getCity());
    }

    @Test
     void testGetState() {
        assertEquals(null, location.getState());
    }

    @Test
     void testGetZipCode() {
        assertEquals(null, location.getZipCode());
    }

    @Test
     void testGetCountry() {
        assertEquals(null, location.getCountry());
    }

}
