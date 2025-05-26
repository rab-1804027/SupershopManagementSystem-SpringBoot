package com.bappi.supershopmanagementsystemspringboot.validation;

import com.bappi.supershopmanagementsystemspringboot.dto.RegistrationRequestDto;
import com.bappi.supershopmanagementsystemspringboot.utils.ConstantUtils;
import com.bappi.supershopmanagementsystemspringboot.validation.annotations.PasswordMatchValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordMatchValidatorImpl implements ConstraintValidator<PasswordMatchValidator, RegistrationRequestDto> {

    @Override
    public boolean isValid(RegistrationRequestDto userRegistrationDto, ConstraintValidatorContext context) {
        boolean isValid = userRegistrationDto.getPassword().equals(userRegistrationDto.getConfirmPassword());

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ConstantUtils.ErrorMessage.PASSWORD_NOT_MATCH)
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
        }
        return isValid;
    }

}