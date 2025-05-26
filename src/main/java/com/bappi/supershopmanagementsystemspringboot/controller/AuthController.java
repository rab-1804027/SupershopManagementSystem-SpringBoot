package com.bappi.supershopmanagementsystemspringboot.controller;

import com.bappi.supershopmanagementsystemspringboot.dto.LoginRequestDto;
import com.bappi.supershopmanagementsystemspringboot.dto.RegistrationRequestDto;
import com.bappi.supershopmanagementsystemspringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegistrationRequestDto registrationRequestDto) {
        userService.save(registrationRequestDto);
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody LoginRequestDto loginRequestDto){

    }
}
