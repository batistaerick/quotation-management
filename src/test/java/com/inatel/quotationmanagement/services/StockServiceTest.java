package com.inatel.quotationmanagement.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class StockServiceTest {

    @Autowired
    private StockService service;

    @Test
    void testCreateCache() {
    }

    @Test
    void testDeleteCache() {
    }
}