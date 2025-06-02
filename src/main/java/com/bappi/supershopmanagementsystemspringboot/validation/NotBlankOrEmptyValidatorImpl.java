package com.bappi.supershopmanagementsystemspringboot.validation;

import com.bappi.supershopmanagementsystemspringboot.validation.annotations.NotBlankOrEmptyValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotBlankOrEmptyValidatorImpl implements ConstraintValidator<NotBlankOrEmptyValidator, String> {
    @Override
    public boolean isValid(String input, ConstraintValidatorContext constraintValidatorContext) {
        log.info("Validating input: {}", input);
        if(input == null)
            return true;
        else
            return !input.trim().isEmpty();
    }
}
