package com.inatel.quotationmanagement.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inatel.quotationmanagement.entities.Quote;
import com.inatel.quotationmanagement.repositories.QuoteRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class QuoteServiceTest {

    @Mock
    private QuoteRepository repository;

    @Autowired
    private QuoteService service;

    @Test
    void testFindAll() {
        List<Quote> listQuote = service.findAll();
        assertNotNull(listQuote);
    }

    @Test
    void testSave() {
        try {
            Map<Date, Double> map = new HashMap<>();
            map.put(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"), 51d);
            map.put(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-02"), 51d);
            map.put(new SimpleDateFormat("yyyy-MM-dd").parse("2022-01-03"), 51d);

            Quote quote = new Quote("teste-id", "vale5", map);

            assertNotNull(service.save(service.entityToDTO(quote)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}