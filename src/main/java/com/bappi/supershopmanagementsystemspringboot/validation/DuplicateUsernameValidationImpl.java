package com.bappi.supershopmanagementsystemspringboot.validation;

import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.service.UserService;
import com.bappi.supershopmanagementsystemspringboot.utils.ConstantUtils;
import com.bappi.supershopmanagementsystemspringboot.validation.annotations.DuplicateUsernameValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DuplicateUsernameValidationImpl implements ConstraintValidator<DuplicateUsernameValidator, String> {

    private final UserService userService;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        User user = userService.findByUsername(username);
        boolean isValid = (user == null);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ConstantUtils.ErrorMessage.DUPLICATE_USERNAME)
                    .addPropertyNode("username")
                    .addConstraintViolation();
        }
        return isValid;
    }
}
