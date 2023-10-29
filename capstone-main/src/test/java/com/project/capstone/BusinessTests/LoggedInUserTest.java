package com.project.capstone.BusinessTests;
import com.project.capstone.business.LoggedInUser;
import com.project.capstone.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class LoggedInUserTest {

    private LoggedInUser loggedInUser;

    @BeforeEach
    void setUp() {
        loggedInUser = new LoggedInUser();
    }

    @Test
    void testGetLoggedInUser() {
        User user = mock(User.class);

        loggedInUser.setLoggedInUser(user);

        assertEquals(user, loggedInUser.getLoggedInUser());
    }

    @Test
    void testSetLoggedInUser() {
        User user = mock(User.class);

        loggedInUser.setLoggedInUser(user);

        assertEquals(user, loggedInUser.getLoggedInUser());
    }

    @Test
     void testGetLoggedIn() {
        User user = new User();
        loggedInUser.setLoggedIn(user); 
        assertEquals(user, loggedInUser.getLoggedIn());
    }

    @Test
     void testSetLoggedIn() {
        User user = new User(); 
        loggedInUser.setLoggedIn(user);
        assertEquals(user, loggedInUser.getLoggedIn());
    }
}
