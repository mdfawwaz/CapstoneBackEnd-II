package com.project.capstone.EntityTests;
import com.project.capstone.entity.Product;
import com.project.capstone.entity.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;
    @Mock
    private User user;

    @BeforeEach
    void setUp() {
        product = new Product();
    }

    @Test
    void testGettersAndSetters() {
        product.setId(1L);
        product.setName("Test Product");
        product.setInternalName("Test Internal Name");
        product.setDetails("Test Product Details");
        product.setMaxProductsPerLocation(10);
        product.setPrice(0.0);
        product.setImageURL("test-image.jpg");

        assertEquals(1L, product.getId());
        assertEquals("Test Product", product.getName());
        assertEquals("Test Internal Name", product.getInternalName());
        assertEquals("Test Product Details", product.getDetails());
        assertEquals(10, product.getMaxProductsPerLocation());
        assertEquals(0.0, product.getPrice());
        assertEquals("test-image.jpg", product.getImageURL());
    }

    @Test
    void testGetPrice() {
        product.setPrice(0.0);

        assertEquals(0.0, product.getPrice());
    }

    @Test
    void testSetPrice() {
        product.setPrice(0.0);

        assertEquals(0.0, product.getPrice());
    }

    @Test
    void testGetImageURL() {
        product.setImageURL("test-image.jpg");

        assertEquals("test-image.jpg", product.getImageURL());
    }

    @Test
    void testSetImageURL() {
        product.setImageURL("test-image.jpg");

        assertEquals("test-image.jpg", product.getImageURL());
    }

    @Test
    void testGetProductDetails() {
        Object result = product.getProductDetails();

        assertNull(result);
    }

    @Test
     void testGetUser() {
        assertEquals(user, product.getUser());
    }

    @Test
     void testSetUser() {
        User newUser = new User(); // Create a new User instance
        product.setUser(newUser); // Set the new User
        assertEquals(newUser, product.getUser());
    }
}
