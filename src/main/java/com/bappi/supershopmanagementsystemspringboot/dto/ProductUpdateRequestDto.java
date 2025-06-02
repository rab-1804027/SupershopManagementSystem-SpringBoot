package com.bappi.supershopmanagementsystemspringboot.dto;

import com.bappi.supershopmanagementsystemspringboot.validation.annotations.NotBlankOrEmptyValidator;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;


public record ProductUpdateRequestDto (

    @NotBlankOrEmptyValidator(message = "Product Name cannot be blank or empty")
    String name,

    @Positive(message = "Product Price should be a positive number")
    Double price,

    @PositiveOrZero(message = "Product Stock Quantity cannot be a negative number")
    Integer stockQuantity
){}
