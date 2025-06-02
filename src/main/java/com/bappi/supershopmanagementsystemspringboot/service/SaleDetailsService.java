package com.bappi.supershopmanagementsystemspringboot.service;

import com.bappi.supershopmanagementsystemspringboot.entity.CartItem;
import com.bappi.supershopmanagementsystemspringboot.entity.Sale;
import com.bappi.supershopmanagementsystemspringboot.mapper.SaleDetailsMapper;
import com.bappi.supershopmanagementsystemspringboot.repository.SaleDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleDetailsService {
    private final SaleDetailsRepository saleDetailsRepository;
    private final SaleDetailsMapper saleDetailsMapper;

    public void save(Sale sale, ProductCartService productCartService){

        for(CartItem cartItem : productCartService.getCartItems()){
            saleDetailsRepository.save(saleDetailsMapper.cartItemToEntity(sale, cartItem));
        }
    }
}
