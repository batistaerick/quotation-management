package com.inatel.quotationmanagement.services;

import java.util.List;

import com.inatel.quotationmanagement.clients.StockManagerClient;
import com.inatel.quotationmanagement.dtos.QuoteDTO;
import com.inatel.quotationmanagement.dtos.StockDTO;
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
    private StockManagerClient stockManagerClient;

    public Quote save(QuoteDTO quoteDTO) {
        try {
            List<StockDTO> listStock = stockManagerClient.findAll();
            Boolean contains = listStock.stream().anyMatch(x -> quoteDTO.getStockId().equals(x.getId()));

            if (Boolean.TRUE.equals(contains)) {
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

    private Quote dtoToEntity(QuoteDTO dto) {
        try {
            Quote entity = new Quote();
            BeanUtils.copyProperties(dto, entity);
            return entity;
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}