package com.inatel.quotationmanagement.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String description;
}