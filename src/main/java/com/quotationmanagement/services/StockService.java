package com.quotationmanagement.services;

import java.util.List;

import com.quotationmanagement.clients.StockManagerClient;
import com.quotationmanagement.dtos.StockDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockManagerClient stockManagerClient;

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