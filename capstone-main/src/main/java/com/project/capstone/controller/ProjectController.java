package com.project.capstone.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.capstone.repository.UserRepository;
import com.project.capstone.service.BillingService;
import com.project.capstone.service.ProductManagementService;

import com.project.capstone.entity.Billing;
import com.project.capstone.entity.Location;
import com.project.capstone.entity.Product;
import com.project.capstone.entity.Quote;
import com.project.capstone.entity.User;
import com.project.capstone.repository.LocationRepository;
import com.project.capstone.repository.ProductRepository;
import com.project.capstone.repository.QuoteRepository;

@RestController
@RequestMapping("/api")
public class ProjectController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BillingService billingService;

    @GetMapping("/health")
    public String checkhealth() {
        return "healthy";
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {

            if (userRepository.existsByName(user.getName())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
            }

            user.setName(user.getName());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed: " + e.getMessage());
        }
    }

    @GetMapping("/selectpage")
    public ResponseEntity<List<Quote>> selectAllQuotes() {
        List<Quote> quotes = quoteRepository.findAll();
        return ResponseEntity.ok(quotes);
    }

    @PostMapping("/selectpage")

    public ResponseEntity<Quote> storeQuote(@RequestBody Quote quote) {
        try {
            Quote savedQuote = quoteRepository.save(quote);
            return new ResponseEntity<>(savedQuote, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/location/save")
    public ResponseEntity<String> saveLocation(@RequestBody Location location) {
        locationRepository.save(location);
        return ResponseEntity.ok("Location saved successfully");
    }

    @GetMapping("/location/get")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/selection")
    @ResponseBody
    public List<Product> productSelection() {
        List<Product> products = productRepository.findAll();
        products.stream().forEach(c -> System.out.print(c.getPrice()));

        if (products != null && !products.isEmpty()) {
            return products;
        } else {
            return Collections.emptyList();
        }
    }

    @RequestMapping("/products")
    public class ProductController {
        @Autowired
        private ProductManagementService productService;

        @GetMapping

        public Product getAllProducts() {
            return productService.getProduct(null);
        }
    }

    @GetMapping("/{productId}/details")
    public ResponseEntity<Product> getProductDetails(@PathVariable Long productId) {
        return getProductDetails(productId);
    }

    @GetMapping("/{productId}/features")

    public ResponseEntity<List<Product>> getProductFeatures(@PathVariable Long productId) {
        return getProductFeatures(productId);
    }

    public List<Product> getAllProducts() {
        return getAllProducts();
    }

    @PostMapping("/billing")
    public ResponseEntity<String> saveBilling(@RequestBody Billing billingData) {
        billingService.saveBillingData(billingData);
        return ResponseEntity.ok("Billing data saved successfully");
    }

    @GetMapping("/billing")
    public ResponseEntity<List<Billing>> getAllBillingData() {
        List<Billing> billingData = billingService.getAllBillingData();
        return ResponseEntity.ok(billingData);
    }

}