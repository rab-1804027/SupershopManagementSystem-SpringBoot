package com.bappi.supershopmanagementsystemspringboot.dto;

import com.bappi.supershopmanagementsystemspringboot.validation.annotations.DuplicateEmailValidator;
import com.bappi.supershopmanagementsystemspringboot.validation.annotations.DuplicateUsernameValidator;
import com.bappi.supershopmanagementsystemspringboot.validation.annotations.PasswordMatchValidator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@PasswordMatchValidator
public record RegistrationRequestDto (

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    String name,

    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email is not valid")
    @DuplicateEmailValidator
    String email,

    @NotNull(message = "Username cannot be null")
    @NotBlank(message = "Username cannot be blank")
    @DuplicateUsernameValidator
    String username,

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    String password,

    @NotNull(message = "Confirm Password cannot be null")
    @NotBlank(message = "Confirm Password cannot be blank")
    String confirmPassword
){}
