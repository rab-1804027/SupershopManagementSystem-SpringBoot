package com.bappi.supershopmanagementsystemspringboot.validation.annotations;

import com.bappi.supershopmanagementsystemspringboot.validation.IsValidQuantityValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IsValidQuantityValidatorImpl.class)
public @interface IsValidQuantityValidator {
    String message() default "Quantity must be positive and not exceed stockQuantity";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
