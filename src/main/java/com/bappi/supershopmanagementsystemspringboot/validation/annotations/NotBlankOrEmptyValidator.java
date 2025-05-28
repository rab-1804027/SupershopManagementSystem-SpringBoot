package com.bappi.supershopmanagementsystemspringboot.validation.annotations;

import com.bappi.supershopmanagementsystemspringboot.validation.NotBlankOrEmptyValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NotBlankOrEmptyValidatorImpl.class)
public @interface NotBlankOrEmptyValidator {
    String message() default "Name cannot be blank or empty";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}



