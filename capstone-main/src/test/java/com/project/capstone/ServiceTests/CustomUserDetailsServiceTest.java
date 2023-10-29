package com.project.capstone.ServiceTests;

import com.project.capstone.entity.User;
import com.project.capstone.service.CustomUserDetailsService;
import com.project.capstone.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

 class CustomUserDetailsServiceTest {

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
     void testLoadUserByUsername_UserExists() {
        String username = "testuser";
        String password = "testpassword";

        User user = new User();
        user.setName(username);
        user.setPassword(password);

        Mockito.when(userService.getByName(username)).thenReturn(Optional.of(user));

        UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);

        assertEquals(username, userDetails.getUsername());
        assertEquals(password, userDetails.getPassword());
    }

    @Test
     void testLoadUserByUsername_UserNotFound() {
        String username = "nonexistentuser";

        Mockito.when(userService.getByName(username)).thenReturn(Optional.empty());

        try {
            customUserDetailsService.loadUserByUsername(username);
        } catch (UsernameNotFoundException e) {
            assertEquals("No user found with username " + username, e.getMessage());
        }
    }

    @Test
     void testPasswordEncoder() {
        PasswordEncoder actualEncoder = customUserDetailsService.passwordEncoder();

        equals( actualEncoder.encode("password"));
    }
}

