package com.bappi.supershopmanagementsystemspringboot.validation;


import com.bappi.supershopmanagementsystemspringboot.dto.AddToCartRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.Product;
import com.bappi.supershopmanagementsystemspringboot.service.ProductService;
import com.bappi.supershopmanagementsystemspringboot.validation.annotations.IsValidQuantityValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class IsValidQuantityValidatorImpl implements ConstraintValidator<IsValidQuantityValidator, AddToCartRequestDto> {
    private final ProductService productService;

    @Override
    public boolean isValid(AddToCartRequestDto addToCartRequestDto, ConstraintValidatorContext constraintValidatorContext) {
        Product product = productService.findById(addToCartRequestDto.getProductId());

        return addToCartRequestDto.getQuantity()>0 && addToCartRequestDto.getQuantity()<=product.getStockQuantity();
    }
}
