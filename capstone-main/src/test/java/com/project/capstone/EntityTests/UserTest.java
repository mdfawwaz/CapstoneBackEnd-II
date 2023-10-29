package com.project.capstone.EntityTests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.capstone.entity.User;
import com.project.capstone.repository.UserRepository;

@SpringBootTest
 class UserTest {

    @Mock
    private UserRepository userRepository; 

    private User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        user = new User();
        user.setId(1L);
        user.setName("TestUser");
        user.setPassword("TestPassword");
    }

    @Test
     void testGettersAndSetters() {
        assertEquals(1L, user.getId());
        assertEquals("TestUser", user.getName());
        assertEquals("TestPassword", user.getPassword());

        user.setId(2L);
        user.setName("UpdatedUser");
        user.setPassword("UpdatedPassword");

        assertEquals(2L, user.getId());
        assertEquals("UpdatedUser", user.getName());
        assertEquals("UpdatedPassword", user.getPassword());
    }

    @Test
     void testSaveUser() {
        Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(user);

        User savedUser = userRepository.save(user);

        Mockito.verify(userRepository).save(user);
        assertEquals(user, savedUser);
    }
}
