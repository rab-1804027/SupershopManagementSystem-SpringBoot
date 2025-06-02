package com.bappi.supershopmanagementsystemspringboot.validation;

import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.service.UserService;
import com.bappi.supershopmanagementsystemspringboot.utils.Constants;
import com.bappi.supershopmanagementsystemspringboot.validation.annotations.DuplicateEmailValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class DuplicateEmailValidatorImpl implements ConstraintValidator<DuplicateEmailValidator, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        log.info("Validating email: {}", email);
        User user = userService.findByEmail(email);
        boolean isValid = (user == null);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Constants.ErrorMessage.DUPLICATE_EMAIL)
                    .addPropertyNode("email")
                    .addConstraintViolation();
        }
        return isValid;
    }
}
