package com.bappi.supershopmanagementsystemspringboot.dto;

import com.bappi.supershopmanagementsystemspringboot.validation.annotations.IsValidQuantityValidator;
import lombok.Data;

@Data
@IsValidQuantityValidator
public class AddToCartRequestDto {
    Integer productId;
    Integer quantity;
}
