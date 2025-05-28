package com.bappi.supershopmanagementsystemspringboot.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ProductCreateRequestDto {
    @NotNull(message = "Product Name cannot be null")
    @NotBlank(message = "Product Name cannot be blank")
    private String name;

    @NotNull(message = "Product Price cannot be null")
    @Positive(message = "Product Price should be Positive Number")
    private Double price;

    @NotNull(message = "Product Stock Quantity cannot be null")
    @PositiveOrZero(message = "Product Stock Quantity cannot be a Negative number")
    private Integer stockQuantity;
}
