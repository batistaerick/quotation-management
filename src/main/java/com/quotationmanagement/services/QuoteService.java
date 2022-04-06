package com.quotationmanagement.services;

import java.util.List;

import com.quotationmanagement.dtos.QuoteDTO;
import com.quotationmanagement.entities.Quote;
import com.quotationmanagement.exceptions.QuoteException;
import com.quotationmanagement.repositories.QuoteRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository repository;

    @Autowired
    private StockService stockService;

    public Quote save(QuoteDTO quoteDTO) {
        try {
            if (stockService.getListStock() == null) {
                stockService.createCache();
            }
            if (stockService.getListStock().stream()
                    .anyMatch(x -> quoteDTO.getStockId().equals(x.getId()))) {
                return repository.save(dtoToEntity(quoteDTO));
            } else {
                throw new QuoteException("StockId nao autorizado para salvar");
            }
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

    public Quote dtoToEntity(QuoteDTO dto) {
        try {
            Quote entity = new Quote();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        } catch (Exception e) {
            throw new QuoteException(e);
        }
    }

    public QuoteDTO entityToDTO(Quote entity) {
        try {
            QuoteDTO dto = new QuoteDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (Exception e) {
            throw new QuoteException(e);
        }
    }
}