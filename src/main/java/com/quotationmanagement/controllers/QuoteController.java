package com.quotationmanagement.controllers;

import java.util.List;

import com.quotationmanagement.dtos.QuoteDTO;
import com.quotationmanagement.entities.Quote;
import com.quotationmanagement.services.QuoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    @Autowired
    private QuoteService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Quote> save(@RequestBody QuoteDTO dto) {
        return ResponseEntity.ok(service.save(dto));
    }

    @GetMapping(value = "/findByStockId/{stockId}")
    public ResponseEntity<Quote> findByStockId(@PathVariable String stockId) {
        return ResponseEntity.ok(service.findByStockId(stockId));
    }

    @GetMapping
    public ResponseEntity<List<Quote>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}