package com.inatel.quotationmanagement.components;

import javax.annotation.PostConstruct;

import com.inatel.quotationmanagement.clients.StockManagerClient;
import com.inatel.quotationmanagement.dtos.StockNotificationDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockComponent {

    @Autowired
    private StockManagerClient stockManagerClient;

    @PostConstruct
    public void registry() {
        stockManagerClient.notification(new StockNotificationDTO("host.docker.internal", 8081));
    }
}