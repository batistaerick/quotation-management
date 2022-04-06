package com.quotationmanagement.repositories;

import com.quotationmanagement.entities.Quote;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, String> {
    Optional<Quote> findByStockId(String stockId);
}