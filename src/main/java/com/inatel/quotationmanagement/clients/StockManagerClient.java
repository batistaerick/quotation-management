package com.inatel.quotationmanagement.clients;

import java.util.List;

import com.inatel.quotationmanagement.dtos.StockDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "stock-manager", url = "localhost:8080")
public interface StockManagerClient {

    @GetMapping("/stock")
    public List<StockDTO> findAll();
}