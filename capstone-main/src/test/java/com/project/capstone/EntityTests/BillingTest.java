package com.project.capstone.EntityTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.capstone.entity.Billing;
import com.project.capstone.entity.User;
import com.project.capstone.repository.UserRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

 class BillingTest {

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testGettersAndSetters() {
        Billing billing = new Billing();

        billing.setId(1L);
        billing.setProductName("Test Product");
        billing.setProductDetails("Test Details");
        billing.setPrice(100.0);
        billing.setLocation("Test Location");

        assertEquals(1L, billing.getId());
        assertEquals("Test Product", billing.getProductName());
        assertEquals("Test Details", billing.getProductDetails());
        assertEquals(100.0, billing.getPrice(), 0.001); 
        assertEquals("Test Location", billing.getLocation());
    }

    @Test
     void testUserAssociation() {
        Billing billing = new Billing();
        User user = new User();
        user.setId(1L);

        billing.setUser(user);

        assertEquals(user, billing.getUser());
    }
}
