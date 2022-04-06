package com.quotationmanagement.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_quote")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Quote implements Serializable {

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