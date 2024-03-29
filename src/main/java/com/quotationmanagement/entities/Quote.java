package com.quotationmanagement.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_quote")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quote implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String stockId;

    @ElementCollection
    @CollectionTable(name = "t_quotes", joinColumns = {
            @JoinColumn(name = "quote_id", referencedColumnName = "id") })
    @MapKeyColumn(name = "stock_date")
    @Column(name = "value")
    private Map<Date, Double> quotes;

}