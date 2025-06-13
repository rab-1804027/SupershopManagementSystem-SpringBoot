package com.bappi.supershopmanagementsystemspringboot.mapper;

import com.bappi.supershopmanagementsystemspringboot.dto.ProductCreateRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.Product;
import com.bappi.supershopmanagementsystemspringboot.entity.User;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product dtoToEntity(ProductCreateRequestDto productCreateRequestDto, User user)
    {
        return Product.builder()
                .User(user)
                .name(productCreateRequestDto.name())
                .price(productCreateRequestDto.price())
                .stockQuantity(productCreateRequestDto.stockQuantity())
                .build();
    }
}
