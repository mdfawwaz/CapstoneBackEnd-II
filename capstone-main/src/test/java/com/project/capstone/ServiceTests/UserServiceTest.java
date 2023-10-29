package com.project.capstone.ServiceTests;

import com.project.capstone.entity.User;
import com.project.capstone.exception.QuotationBusinessException;
import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

 class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private UserService userService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        passwordEncoder = new BCryptPasswordEncoder();
        userService = new UserService(userRepository);
    }

    @Test
     void testAuthenticateUserNotFound() {
        when(userRepository.findByName("nonexistentuser")).thenReturn(Optional.empty());

        assertThrows(QuotationBusinessException.class, () -> userService.authenticate("nonexistentuser", "password"));
    }

    @Test
     void testAuthenticateInvalidPassword() {
        User user = new User();
        user.setId(1L);
        user.setName("testuser");
        user.setPassword("{bcrypt}" + passwordEncoder.encode("testpassword"));

        when(userRepository.findByName("testuser")).thenReturn(Optional.of(user));

        Optional<User> authenticatedUser = userService.authenticate("testuser", "invalidpassword");

        assertFalse(authenticatedUser.isPresent());
    }

    @Test
     void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setName("testuser");
        user.setPassword("testpassword");

        when(userRepository.save(user)).thenReturn(user);

        User createdUser = userService.create(user);

        assertNotNull(createdUser);
        assertEquals(user.getName(), createdUser.getName());
        assertTrue(createdUser.getPassword().startsWith("{bcrypt}"));
    }
}
