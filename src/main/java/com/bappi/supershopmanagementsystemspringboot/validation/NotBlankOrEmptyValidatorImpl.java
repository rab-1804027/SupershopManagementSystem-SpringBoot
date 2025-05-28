package com.bappi.supershopmanagementsystemspringboot.validation;

import com.bappi.supershopmanagementsystemspringboot.validation.annotations.NotBlankOrEmptyValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankOrEmptyValidatorImpl implements ConstraintValidator<NotBlankOrEmptyValidator, String> {
    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        if(input == null)
            return true;
        else
            return !input.trim().isEmpty();
    }
}
