package com.inatel.quotationmanagement.services;

import com.inatel.quotationmanagement.repositories.QuoteRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class QuoteServiceTest {

    @Mock
    private QuoteRepository repository;

    @InjectMocks
    private QuoteService service;

    @InjectMocks
    private StockService stockService;

    @Test
    void testFindAll() {
    }

    @Test
    void testFindByStockId() {
    }

    @Test
    void testSave() {

    }
}
