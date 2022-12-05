package com.quotationmanagement.dtos;

import java.io.Serial;
import java.io.Serializable;

import lombok.*;

@Getter
@Setter
public class StockDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String description;
}