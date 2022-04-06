package com.quotationmanagement.services;

import java.util.List;

import com.quotationmanagement.clients.StockManagerClient;
import com.quotationmanagement.dtos.StockDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {

    @Autowired
    private StockManagerClient stockManagerClient;

    private List<StockDTO> listStock;

    public void createCache() {
        listStock = stockManagerClient.findAll();
    }

    public void deleteCache() {
        listStock = null;
    }

    public List<StockDTO> getListStock() {
        return listStock;
    }
}