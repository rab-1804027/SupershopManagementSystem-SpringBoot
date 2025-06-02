package com.bappi.supershopmanagementsystemspringboot.validation;

import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.service.UserService;
import com.bappi.supershopmanagementsystemspringboot.utils.Constants;
import com.bappi.supershopmanagementsystemspringboot.validation.annotations.DuplicateUsernameValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class DuplicateUsernameValidationImpl implements ConstraintValidator<DuplicateUsernameValidator, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        User user = userService.findByUsername(username);
        log.info("Validating username: {}", username);
        boolean isValid = (user == null);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(Constants.ErrorMessage.DUPLICATE_USERNAME)
                    .addPropertyNode("username")
                    .addConstraintViolation();
        }
        return isValid;
    }
}
