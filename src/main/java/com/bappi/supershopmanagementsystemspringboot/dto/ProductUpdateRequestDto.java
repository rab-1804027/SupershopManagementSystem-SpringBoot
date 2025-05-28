package com.bappi.supershopmanagementsystemspringboot.dto;

import com.bappi.supershopmanagementsystemspringboot.validation.annotations.NotBlankOrEmptyValidator;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductUpdateRequestDto {

    @NotBlankOrEmptyValidator(message = "Product Name cannot be blank or empty")
    private String name;

    @Positive(message = "Product Price should be a positive number")
    private Double price;

    @PositiveOrZero(message = "Product Stock Quantity cannot be a negative number")
    private Integer stockQuantity;
}
