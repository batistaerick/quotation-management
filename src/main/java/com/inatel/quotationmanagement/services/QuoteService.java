package com.inatel.quotationmanagement.services;

import java.util.List;

import com.inatel.quotationmanagement.dtos.QuoteDTO;
import com.inatel.quotationmanagement.entities.Quote;
import com.inatel.quotationmanagement.exceptions.QuoteException;
import com.inatel.quotationmanagement.repositories.QuoteRepository;

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
            throw new QuoteException(e.getMessage());
        }
    }

    public Quote findByStockId(String stockId) {
        return repository.findByStockId(stockId);
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
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public QuoteDTO entityToDTO(Quote entity) {
        try {
            QuoteDTO dto = new QuoteDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}