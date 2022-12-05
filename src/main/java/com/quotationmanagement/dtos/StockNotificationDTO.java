package com.quotationmanagement.dtos;

import java.io.Serial;
import java.io.Serializable;

import lombok.*;

@Getter
@Setter
public class StockNotificationDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String host;
    private Integer port;
}