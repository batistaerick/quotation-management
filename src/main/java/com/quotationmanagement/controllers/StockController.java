package com.quotationmanagement.controllers;

import com.quotationmanagement.services.StockService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stockcache")
@RequiredArgsConstructor
public class StockController {

    private final StockService service;

    @DeleteMapping
    public ResponseEntity<Void> deleteCache() {
        service.deleteCache();
        return ResponseEntity.noContent().build();
    }

}
