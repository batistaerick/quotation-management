package com.quotationmanagement.dtos;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.*;

@Getter
@Setter
public class QuoteDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String stockId;
    private Map<Date, Double> quotes;
}