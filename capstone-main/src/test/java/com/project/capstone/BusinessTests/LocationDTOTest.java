package com.project.capstone.BusinessTests;

import com.project.capstone.business.LocationDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class LocationDTOTest {

    private LocationDTO locationDTO;

    @BeforeEach
    void setUp() {
        locationDTO = new LocationDTO();
    }

    @Test
    void testGettersAndSetters() {
        locationDTO.setAddress("123 Main St");
        locationDTO.setAptSuite("Apt 4B");
        locationDTO.setCity("New York");
        locationDTO.setState("NY");
        locationDTO.setZip("10001");
        locationDTO.setCountry("USA");

        assertEquals("123 Main St", locationDTO.getAddress());
        assertEquals("Apt 4B", locationDTO.getAptSuite());
        assertEquals("New York", locationDTO.getCity());
        assertEquals("NY", locationDTO.getState());
        assertEquals("10001", locationDTO.getZip());
        assertEquals("USA", locationDTO.getCountry());
    }

    @Test
    void testSetAddress() {
        locationDTO.setAddress("456 Elm St");
        assertEquals("456 Elm St", locationDTO.getAddress());
    }

    @Test
    void testSetAptSuite() {
        locationDTO.setAptSuite("Apt 7C");
        assertEquals("Apt 7C", locationDTO.getAptSuite());
    }

    @Test
    void testSetCity() {
        locationDTO.setCity("Los Angeles");
        assertEquals("Los Angeles", locationDTO.getCity());
    }

    @Test
    void testSetState() {
        locationDTO.setState("CA");
        assertEquals("CA", locationDTO.getState());
    }

    @Test
    void testSetZip() {
        locationDTO.setZip("90210");
        assertEquals("90210", locationDTO.getZip());
    }

    @Test
    void testSetCountry() {
        locationDTO.setCountry("Canada");
        assertEquals("Canada", locationDTO.getCountry());
    }

    @Test
    void testSetAddressNull() {
        locationDTO.setAddress(null);
        assertNull(locationDTO.getAddress());
    }

    @Test
    void testSetAptSuiteNull() {
        locationDTO.setAptSuite(null);
        assertNull(locationDTO.getAptSuite());
    }

    @Test
    void testSetCityNull() {
        locationDTO.setCity(null);
        assertNull(locationDTO.getCity());
    }

    @Test
    void testSetStateNull() {
        locationDTO.setState(null);
        assertNull(locationDTO.getState());
    }

    @Test
    void testSetZipNull() {
        locationDTO.setZip(null);
        assertNull(locationDTO.getZip());
    }

    @Test
    void testSetCountryNull() {
        locationDTO.setCountry(null);
        assertNull(locationDTO.getCountry());
    }
}
