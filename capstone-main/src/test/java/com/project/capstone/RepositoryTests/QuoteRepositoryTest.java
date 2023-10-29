package com.project.capstone.RepositoryTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.project.capstone.entity.Quote;
import com.project.capstone.repository.QuoteRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

 class QuoteRepositoryTest {

    @Autowired
    private QuoteRepository quoteRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
     void testSaveQuote() {
        Quote quote = new Quote();
        quote.setQuoteName("This is a test quote");

        quote = entityManager.persistAndFlush(quote);

        Quote savedQuote = quoteRepository.findById(quote.getId()).orElse(null);

        assertNotNull(savedQuote);
        assertEquals("This is a test quote", savedQuote.getQuoteName());
    }

    @Test
     void testFindById() {
        Quote quote = new Quote();
        quote.setQuoteName("Another test quote");
        entityManager.persistAndFlush(quote);

        Quote savedQuote = quoteRepository.findById(quote.getId()).orElse(null);

        assertNotNull(savedQuote);
        assertEquals("Another test quote", savedQuote.getQuoteName());
    }

}

