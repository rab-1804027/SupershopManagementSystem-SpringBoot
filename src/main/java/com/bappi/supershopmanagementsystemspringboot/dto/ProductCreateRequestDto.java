package com.bappi.supershopmanagementsystemspringboot.dto;

import jakarta.validation.constraints.*;

public record ProductCreateRequestDto (
    @NotNull(message = "Product Name cannot be null")
    @NotBlank(message = "Product Name cannot be blank")
    String name,

    @NotNull(message = "Product Price cannot be null")
    @Positive(message = "Product Price should be Positive Number")
    Double price,

    @NotNull(message = "Product Stock Quantity cannot be null")
    @PositiveOrZero(message = "Product Stock Quantity cannot be a Negative number")
    Integer stockQuantity
){}
