package com.project.capstone.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.capstone.entity.Product;
import com.project.capstone.repository.ProductRepository;

@Service
public class ProductManagementService {

	@Autowired
	private ProductRepository productRepository;

	public boolean addProduct(Product product) {
		try {
			productRepository.save(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Product getProduct(Long productId) {
		return productRepository.findById(productId).orElse(null);
	}

	public boolean updateProduct(Long productId, Product updatedProductDetails) {
		try {
			Product existingProduct = productRepository.findById(productId).orElse(null);
			if (existingProduct != null) {
				existingProduct.setName(updatedProductDetails.getName());
				existingProduct.setInternalName(updatedProductDetails.getInternalName());
				existingProduct.setDetails(updatedProductDetails.getDetails());
				existingProduct.setMaxProductsPerLocation(updatedProductDetails.getMaxProductsPerLocation());

				productRepository.save(existingProduct);
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

    public Object getProductFeatures() {
        return null;
    }
}
