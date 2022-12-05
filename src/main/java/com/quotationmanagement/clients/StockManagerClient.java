package com.quotationmanagement.clients;

import java.util.List;

import com.quotationmanagement.dtos.StockDTO;
import com.quotationmanagement.dtos.StockNotificationDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "stock-manager", url = "localhost:8080")
public interface StockManagerClient {

    @GetMapping("/stock")
    List<StockDTO> findAll();

    @PostMapping("/notification")
    void notification(@RequestBody StockNotificationDTO stockNotificationDTO);

}