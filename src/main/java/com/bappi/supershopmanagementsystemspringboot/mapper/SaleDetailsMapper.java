package com.bappi.supershopmanagementsystemspringboot.mapper;

import com.bappi.supershopmanagementsystemspringboot.entity.CartItem;
import com.bappi.supershopmanagementsystemspringboot.entity.Sale;
import com.bappi.supershopmanagementsystemspringboot.entity.SaleDetails;
import org.springframework.stereotype.Component;

@Component
public class SaleDetailsMapper {

    public SaleDetails cartItemToEntity(Sale sale, CartItem cartItem) {
        return SaleDetails.builder()
                .sale(sale)
                .product(cartItem.getProduct())
                .unitPrice(cartItem.getProduct().getPrice())
                .quantity(cartItem.getQuantity())
                .price(cartItem.getPrice())
                .build();
    }
}
