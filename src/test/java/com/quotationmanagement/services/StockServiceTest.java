package com.quotationmanagement.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        service.createCache();
        assertNotNull(service.getListStock());
    }

    @Test
    void testDeleteCache() {
        service.deleteCache();
        assertNull(service.getListStock());
    }
}