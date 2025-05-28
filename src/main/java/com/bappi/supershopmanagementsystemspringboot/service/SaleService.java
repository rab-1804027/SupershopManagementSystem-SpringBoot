package com.bappi.supershopmanagementsystemspringboot.service;

import com.bappi.supershopmanagementsystemspringboot.entity.Sale;
import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

    public Sale save(User user, Double totalPrice){
        Sale sale = Sale.builder()
                .user(user)
                .totalPrice(totalPrice)
                .build();
        return saleRepository.save(sale);
    }
}
