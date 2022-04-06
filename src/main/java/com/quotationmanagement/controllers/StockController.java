package com.quotationmanagement.controllers;

import com.quotationmanagement.services.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stockcache")
public class StockController {

    @Autowired
    private StockService service;

    @DeleteMapping
    public ResponseEntity<Void> deleteCache() {
        service.deleteCache();
        return ResponseEntity.noContent().build();
    }
}