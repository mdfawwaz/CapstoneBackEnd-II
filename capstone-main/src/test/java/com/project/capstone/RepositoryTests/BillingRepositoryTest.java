// package com.project.capstone.RepositoryTests;import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.project.capstone.entity.Billing;
// import com.project.capstone.repository.BillingRepository;
// import com.project.capstone.service.BillingService;

// import java.util.Arrays;
// import java.util.List;
// import static org.junit.jupiter.api.Assertions.assertEquals;

// @DataJpaTest
// public class BillingRepositoryTest {

//     @InjectMocks
//     private BillingService billingService;

//     @Mock
//     private BillingRepository billingRepository;

//     @Test
//     public void testFindByProductName() {
//         // Define a sample product name to search for
//         String productNameToFind = "Test Product";

//         // Define some sample Billing objects
//         Billing billing1 = new Billing();
//         billing1.setProductName(productNameToFind);

//         Billing billing2 = new Billing();
//         billing2.setProductName("Another Product");

//         // Mock the behavior of the findByProductName method
//         List<Billing> expectedResults = Arrays.asList(billing1);
//         Mockito.when(billingRepository.findByProductName(productNameToFind)).thenReturn(expectedResults);

//         // Perform the test
//         List<Billing> foundBillings = billingService.findByProductName(productNameToFind);

//         // Assertions
//         assertEquals(1, foundBillings.size());
//         assertEquals(productNameToFind, foundBillings.get(0).getProductName());
//     }
// }
