package com.project.capstone.RepositoryTests;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import com.project.capstone.service.UserService;
import com.project.capstone.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void testExistsByNameWhenUserDoesNotExist() {
        boolean userExists = userService.checkIfUserExists();
        assertFalse(userExists);
    }
}
