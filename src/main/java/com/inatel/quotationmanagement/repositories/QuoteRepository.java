package com.inatel.quotationmanagement.repositories;

import com.inatel.quotationmanagement.entities.Quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, String> {
    Quote findByStockId(String stockId);
}