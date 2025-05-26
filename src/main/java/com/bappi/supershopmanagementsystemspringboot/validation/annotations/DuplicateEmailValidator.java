package com.bappi.supershopmanagementsystemspringboot.validation.annotations;

import com.bappi.supershopmanagementsystemspringboot.validation.DuplicateEmailValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DuplicateEmailValidatorImpl.class)
public @interface DuplicateEmailValidator {
    String message() default "Email already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
