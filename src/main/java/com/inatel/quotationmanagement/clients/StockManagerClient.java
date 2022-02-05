package com.inatel.quotationmanagement.clients;

import java.util.List;

import com.inatel.quotationmanagement.dtos.StockDTO;
import com.inatel.quotationmanagement.dtos.StockNotificationDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "stock-manager", url = "localhost:8080")
public interface StockManagerClient {

    @GetMapping(value = "/stock")
    public List<StockDTO> findAll();

    @PostMapping(value = "/notification")
    public void notification(@RequestBody StockNotificationDTO stockNotificationDTO);
}