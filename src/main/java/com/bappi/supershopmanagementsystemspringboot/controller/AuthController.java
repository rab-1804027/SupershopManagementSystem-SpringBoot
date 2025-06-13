package com.bappi.supershopmanagementsystemspringboot.controller;

import com.bappi.supershopmanagementsystemspringboot.config.CustomAuthenticationManager;
import com.bappi.supershopmanagementsystemspringboot.config.CustomUserDetailsService;
import com.bappi.supershopmanagementsystemspringboot.dto.LoginRequestDto;
import com.bappi.supershopmanagementsystemspringboot.dto.LoginResponseDto;
import com.bappi.supershopmanagementsystemspringboot.dto.RegistrationRequestDto;
import com.bappi.supershopmanagementsystemspringboot.service.JwtService;
import com.bappi.supershopmanagementsystemspringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final CustomAuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/register")
    public void register(@Valid @RequestBody RegistrationRequestDto registrationRequestDto) {
        log.info("Username: {} is trying to register", registrationRequestDto.username());
        userService.save(registrationRequestDto);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.username(), loginRequestDto.password())
        );

        String token = jwtService.generateToken(loginRequestDto.username());

        return ResponseEntity
                .ok()
                .body(new LoginResponseDto(token));
    }

}
