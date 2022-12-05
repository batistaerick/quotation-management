package com.quotationmanagement.converters;

import com.quotationmanagement.dtos.QuoteDTO;
import com.quotationmanagement.entities.Quote;
import com.quotationmanagement.exceptions.QuoteException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class QuoteConverter {

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
