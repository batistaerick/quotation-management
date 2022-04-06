package com.quotationmanagement.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuoteDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String stockId;
    private Map<Date, Double> quotes;
}