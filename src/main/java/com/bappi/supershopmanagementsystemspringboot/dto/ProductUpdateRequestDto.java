package com.bappi.supershopmanagementsystemspringboot.dto;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductUpdateRequestDto {

    @NotNull(message = "Product Name cannot be null")
    String name;

    @NotNull(message = "Product Price cannot be null")
    @NegativeOrZero(message = "Product Price cannot be negative or zero")
    Double price;

    @NotNull(message = "Product Stock Quantity cannot be null")
    @NegativeOrZero(message = "Product Stock Quantity cannot be negative or zero")
    Integer stockQuantity;
}
