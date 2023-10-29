package com.project.capstone;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.web.cors.CorsConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class CorsConfigTest {

    @InjectMocks
    private CorsConfig corsConfig;

    @Test
     void testGetCorsConfiguration() {
        MockitoAnnotations.openMocks(this);

        CorsConfiguration corsConfiguration = corsConfig.getCorsConfiguration(null);

        assertEquals("*", corsConfiguration.getAllowedOrigins().get(0));
        assertEquals("*", corsConfiguration.getAllowedMethods().get(0));
        assertEquals("*", corsConfiguration.getAllowedHeaders().get(0));
    }
}
