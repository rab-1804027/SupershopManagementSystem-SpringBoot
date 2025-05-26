package com.bappi.supershopmanagementsystemspringboot.validation.annotations;

import com.bappi.supershopmanagementsystemspringboot.validation.DuplicateUsernameValidationImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DuplicateUsernameValidationImpl.class)
public @interface DuplicateUsernameValidator {
    String message() default "Duplicate username";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
