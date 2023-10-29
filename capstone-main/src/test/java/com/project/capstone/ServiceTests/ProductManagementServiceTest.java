package com.project.capstone.ServiceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.project.capstone.entity.Product;
import com.project.capstone.repository.ProductRepository;
import com.project.capstone.service.ProductManagementService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

 class ProductManagementServiceTest {

    @InjectMocks
    private ProductManagementService productManagementService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
     void testAddProduct_Success() {
        Product product = new Product();

        Mockito.when(productRepository.save(product)).thenReturn(product);

        boolean result = productManagementService.addProduct(product);

        assertTrue(result);
    }

    @Test
     void testAddProduct_Failure() {
        Product product = new Product();

        Mockito.when(productRepository.save(product)).thenThrow(new RuntimeException("Test exception"));

        boolean result = productManagementService.addProduct(product);

        assertFalse(result);
    }

    @Test
     void testGetProduct_Success() {
        long productId = 1L;
        Product product = new Product();

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        Product result = productManagementService.getProduct(productId);

        assertEquals(product, result);
    }

    @Test
     void testGetProduct_NotFound() {
        long productId = 1L;

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.empty());

        Product result = productManagementService.getProduct(productId);

        assertNull(result);
    }

    @Test
     void testUpdateProduct_Success() {
        long productId = 1L;
        Product existingProduct = new Product();
        Product updatedProductDetails = new Product();

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        Mockito.when(productRepository.save(existingProduct)).thenReturn(existingProduct);

        boolean result = productManagementService.updateProduct(productId, updatedProductDetails);

        assertTrue(result);
    }

    @Test
     void testUpdateProduct_ProductNotFound() {
        long productId = 1L;
        Product updatedProductDetails = new Product();

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.empty());

        boolean result = productManagementService.updateProduct(productId, updatedProductDetails);

        assertFalse(result);
    }

    @Test
     void testUpdateProduct_Failure() {
        long productId = 1L;
        Product existingProduct = new Product();
        Product updatedProductDetails = new Product();

        Mockito.when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        Mockito.when(productRepository.save(existingProduct)).thenThrow(new RuntimeException("Test exception"));

        boolean result = productManagementService.updateProduct(productId, updatedProductDetails);

        assertFalse(result);
    }

    @Test
    void testGetProductFeatures() {
        Object result = productManagementService.getProductFeatures();
        assertNull(result);
    }
}
