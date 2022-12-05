package com.quotationmanagement.services;

import java.util.List;

import com.quotationmanagement.converters.QuoteConverter;
import com.quotationmanagement.dtos.QuoteDTO;
import com.quotationmanagement.entities.Quote;
import com.quotationmanagement.exceptions.QuoteException;
import com.quotationmanagement.repositories.QuoteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuoteService {

    private final QuoteRepository repository;
    private final QuoteConverter converter;
    private final StockService stockService;

    public Quote save(QuoteDTO quoteDTO) {
        try {
            if (stockService.getListStock() == null) {
                stockService.createCache();
            }
            if (stockService.getListStock().stream()
                    .anyMatch(x -> quoteDTO.getStockId().equals(x.getId()))) {
                return repository.save(converter.dtoToEntity(quoteDTO));
            }
            throw new QuoteException("StockId nao autorizado para salvar");
        } catch (Exception e) {
            throw new QuoteException(e);
        }
    }

    public Quote findByStockId(String stockId) {
        return repository.findByStockId(stockId).orElseThrow(() -> new QuoteException("Quote not found"));
    }

    public List<Quote> findAll() {
        return repository.findAll();
    }

}