package com.project.capstone.EntityTests;
import com.project.capstone.entity.Quote;
import com.project.capstone.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

 class QuoteTest {

    private Quote quote;

    @Mock
    private User user;

    @BeforeEach
    void setUp() {
        quote = new Quote();
        user = mock(User.class);
    }

    @Test
    void testGettersAndSetters() {
        quote.setId(1L);
        quote.setCustomerName("John Doe");
        quote.setAccountStatus("Active");
        quote.setQuoteName("Test Quote");
        quote.setQuoteOwner("Owner");
        quote.setQuoteId("Q123");
        quote.setUser(user);
        quote.setUserName("User Name");

        assertEquals(1L, quote.getId());
        assertEquals("John Doe", quote.getCustomerName());
        assertEquals("Active", quote.getAccountStatus());
        assertEquals("Test Quote", quote.getQuoteName());
        assertEquals("Owner", quote.getQuoteOwner());
        assertEquals("Q123", quote.getQuoteId());
        assertEquals(user, quote.getUser());
        assertEquals("User Name", quote.getUserName());
    }

    @Test
    void testIdGetterAndSetter() {
        quote.setId(1L);
        assertEquals(1L, quote.getId());
    }

    @Test
    void testCustomerNameGetterAndSetter() {
        quote.setCustomerName("John Doe");
        assertEquals("John Doe", quote.getCustomerName());
    }

    @Test
    void testAccountStatusGetterAndSetter() {
        quote.setAccountStatus("Active");
        assertEquals("Active", quote.getAccountStatus());
    }

    @Test
    void testQuoteNameGetterAndSetter() {
        quote.setQuoteName("Test Quote");
        assertEquals("Test Quote", quote.getQuoteName());
    }

    @Test
    void testQuoteOwnerGetterAndSetter() {
        quote.setQuoteOwner("Owner");
        assertEquals("Owner", quote.getQuoteOwner());
    }

    @Test
    void testQuoteIdGetterAndSetter() {
        quote.setQuoteId("Q123");
        assertEquals("Q123", quote.getQuoteId());
    }

    @Test
    void testUserGetterAndSetter() {
        quote.setUser(user);
        assertEquals(user, quote.getUser());
    }

    @Test
    void testUserNameGetterAndSetter() {
        quote.setUserName("User Name");
        assertEquals("User Name", quote.getUserName());
    }

    @Test
    void testUserInteraction() {
        when(user.getName()).thenReturn("John Smith");

        quote.setUser(user);

        assertEquals(user, quote.getUser());
        assertEquals(null, quote.getUserName());
    }
}
